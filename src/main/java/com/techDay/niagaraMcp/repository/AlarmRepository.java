package com.techDay.niagaraMcp.repository;

import com.techDay.niagaraMcp.model.Alarm;
import com.techDay.niagaraMcp.model.Alarm.AlarmPriority;
import com.techDay.niagaraMcp.model.Alarm.AlarmState;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AlarmRepository
{

  private final Map<String, Alarm> alarmsById = new HashMap<>();

  @PostConstruct
  void init()
  {
    addAlarm(new Alarm(
      "ALM-001",
      "High Zone Temperature",
      "station:|slot:/HVAC/AHU-1/ZoneTempAlarm",
      AlarmPriority.CRITICAL,
      AlarmState.ACTIVE,
      false,
      LocalDateTime.of(2026, 9, 5, 8, 15, 0),
      null,
      "LifeSafety"
    ));

    addAlarm(new Alarm(
      "ALM-002",
      "Chiller Fault",
      "station:|slot:/HVAC/Chiller-1/FaultAlarm",
      AlarmPriority.HIGH,
      AlarmState.OFFNORMAL,
      false,
      LocalDateTime.of(2026, 9, 5, 9, 30, 0),
      null,
      "Mechanical"
    ));

    addAlarm(new Alarm(
      "ALM-003",
      "Low Differential Pressure",
      "station:|slot:/HVAC/AHU-2/DiffPressAlarm",
      AlarmPriority.MEDIUM,
      AlarmState.NORMAL,
      true,
      LocalDateTime.of(2026, 9, 4, 14, 0, 0),
      "operator1",
      "Mechanical"
    ));

    addAlarm(new Alarm(
      "ALM-004",
      "Panel Door Open",
      "station:|slot:/Electrical/Panel-A/DoorAlarm",
      AlarmPriority.LOW,
      AlarmState.NORMAL,
      true,
      LocalDateTime.of(2026, 9, 3, 11, 45, 0),
      "operator2",
      "Electrical"
    ));

    addAlarm(new Alarm(
      "ALM-005",
      "Fire Detector Triggered",
      "station:|slot:/Fire/Zone-2/SmokeDetectorAlarm",
      AlarmPriority.CRITICAL,
      AlarmState.ACTIVE,
      false,
      LocalDateTime.of(2026, 9, 5, 10, 5, 0),
      null,
      "LifeSafety"
    ));
  }

  private void addAlarm(Alarm alarm)
  {
    alarmsById.put(alarm.id().toUpperCase(), alarm);
  }

  public Alarm findById(String id)
  {
    return alarmsById.get(id.toUpperCase());
  }

  public Alarm findByName(String displayName)
  {
    return alarmsById.values()
      .stream()
      .filter(alarm -> alarm.displayName().equalsIgnoreCase(displayName))
      .findFirst()
      .orElse(null);
  }

  public List<Alarm> findAll()
  {
    return alarmsById.values()
      .stream()
      .toList();
  }

  public List<Alarm> findAllActive()
  {
    return alarmsById.values()
      .stream()
      .filter(alarm -> alarm.state() == AlarmState.ACTIVE)
      .toList();
  }

  public List<Alarm> findAllAcknowledged()
  {
    return alarmsById.values()
      .stream()
      .filter(Alarm::acknowledged)
      .toList();
  }

  public List<Alarm> findAllUnacknowledged()
  {
    return alarmsById.values()
      .stream()
      .filter(alarm -> !alarm.acknowledged())
      .toList();
  }

  public List<Alarm> findByPriority(AlarmPriority priority)
  {
    return alarmsById.values()
      .stream()
      .filter(alarm -> alarm.priority() == priority)
      .toList();
  }

  public List<Alarm> findByAlarmClass(String alarmClass)
  {
    return alarmsById.values()
      .stream()
      .filter(alarm -> alarm.alarmClass().equalsIgnoreCase(alarmClass))
      .toList();
  }
}
