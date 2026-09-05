package com.techDay.niagaraMcp.model;

import java.time.LocalDateTime;

public record Alarm(
  String id,
  String displayName,
  String sourcePath,
  AlarmPriority priority,
  AlarmState state,
  boolean acknowledged,
  LocalDateTime timestamp,
  String acknowledgedBy,
  String alarmClass
) {

  public enum AlarmPriority {
    CRITICAL, HIGH, MEDIUM, LOW
  }

  public enum AlarmState {
    ACTIVE, NORMAL, OFFNORMAL
  }
}
