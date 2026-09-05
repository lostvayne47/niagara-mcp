package com.techDay.niagaraMcp.repository;

import com.techDay.niagaraMcp.model.Alarm;
import com.techDay.niagaraMcp.model.Alarm.AlarmPriority;
import com.techDay.niagaraMcp.model.Alarm.AlarmState;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class AlarmRepository
{

  private final Map<String, Alarm> alarmsById = new HashMap<>();

  @PostConstruct
  void init()
  {
    try
    {
      Reader reader = new InputStreamReader(
        new ClassPathResource("mock-data/alarms.csv").getInputStream()
      );

      Iterable<CSVRecord> records = CSVFormat.DEFAULT
        .builder()
        .setHeader()
        .setSkipHeaderRecord(true)
        .build()
        .parse(reader);

      for (CSVRecord record : records)
      {
        String acknowledgedBy = record.get("acknowledgedBy");

        Alarm alarm = new Alarm(
          record.get("id"),
          record.get("displayName"),
          record.get("sourcePath"),
          AlarmPriority.valueOf(record.get("priority")),
          AlarmState.valueOf(record.get("state")),
          Boolean.parseBoolean(record.get("acknowledged")),
          LocalDateTime.parse(record.get("timestamp")),
          acknowledgedBy.isBlank() ? null : acknowledgedBy,
          record.get("alarmClass")
        );

        addAlarm(alarm);
      }

      log.info("Loaded {} alarms from CSV", alarmsById.size());
    }
    catch (Exception e)
    {
      log.error("Failed to load alarms from CSV", e);
    }
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
