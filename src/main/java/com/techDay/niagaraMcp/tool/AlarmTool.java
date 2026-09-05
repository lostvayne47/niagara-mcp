package com.techDay.niagaraMcp.tool;

import com.techDay.niagaraMcp.model.Alarm;
import com.techDay.niagaraMcp.model.Alarm.AlarmPriority;
import com.techDay.niagaraMcp.service.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AlarmTool
{

  private final AlarmService alarmService;

  @McpTool(
    name = "getAlarmById",
    description = "Get a BMS alarm by its unique ID (e.g. ALM-001)"
  )
  public Alarm getAlarmById(String id)
  {
    return alarmService.getAlarmById(id);
  }

  @McpTool(
    name = "getAlarmByName",
    description = "Get a BMS alarm by its display name"
  )
  public Alarm getAlarmByName(String displayName)
  {
    return alarmService.getAlarmByName(displayName);
  }

  @McpTool(
    name = "getAllAlarms",
    description = "Get all BMS alarms regardless of state or acknowledgement"
  )
  public List<Alarm> getAllAlarms()
  {
    return alarmService.getAllAlarms();
  }

  @McpTool(
    name = "getAllActiveAlarms",
    description = "Get all currently active BMS alarms (state = ACTIVE)"
  )
  public List<Alarm> getAllActiveAlarms()
  {
    return alarmService.getAllActiveAlarms();
  }

  @McpTool(
    name = "getAllAcknowledgedAlarms",
    description = "Get all BMS alarms that have been acknowledged by an operator"
  )
  public List<Alarm> getAllAcknowledgedAlarms()
  {
    return alarmService.getAllAcknowledgedAlarms();
  }

  @McpTool(
    name = "getAllUnacknowledgedAlarms",
    description = "Get all BMS alarms that are pending acknowledgement"
  )
  public List<Alarm> getAllUnacknowledgedAlarms()
  {
    return alarmService.getAllUnacknowledgedAlarms();
  }

  @McpTool(
    name = "getAlarmsByPriority",
    description = "Get all BMS alarms filtered by priority (CRITICAL, HIGH, MEDIUM, LOW)"
  )
  public List<Alarm> getAlarmsByPriority(AlarmPriority priority)
  {
    return alarmService.getAlarmsByPriority(priority);
  }

  @McpTool(
    name = "getAlarmsByClass",
    description = "Get all BMS alarms filtered by alarm class (e.g. LifeSafety, Mechanical, Electrical)"
  )
  public List<Alarm> getAlarmsByClass(String alarmClass)
  {
    return alarmService.getAlarmsByClass(alarmClass);
  }
}
