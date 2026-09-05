package com.techDay.niagaraMcp.service;

import com.techDay.niagaraMcp.model.Alarm;
import com.techDay.niagaraMcp.model.Alarm.AlarmPriority;
import com.techDay.niagaraMcp.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlarmService
{

  private final AlarmRepository alarmRepository;

  public Alarm getAlarmById(String id)
  {
    return alarmRepository.findById(id);
  }

  public Alarm getAlarmByName(String displayName)
  {
    return alarmRepository.findByName(displayName);
  }

  public List<Alarm> getAllAlarms()
  {
    return alarmRepository.findAll();
  }

  public List<Alarm> getAllActiveAlarms()
  {
    return alarmRepository.findAllActive();
  }

  public List<Alarm> getAllAcknowledgedAlarms()
  {
    return alarmRepository.findAllAcknowledged();
  }

  public List<Alarm> getAllUnacknowledgedAlarms()
  {
    return alarmRepository.findAllUnacknowledged();
  }

  public List<Alarm> getAlarmsByPriority(AlarmPriority priority)
  {
    return alarmRepository.findByPriority(priority);
  }

  public List<Alarm> getAlarmsByClass(String alarmClass)
  {
    return alarmRepository.findByAlarmClass(alarmClass);
  }
}
