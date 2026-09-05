package com.techDay.niagaraMcp.model;

import java.time.LocalDateTime;

public record History(
  String id,
  String displayName,
  String sourcePath,
  Double value,
  String unit,
  LocalDateTime timestamp,
  int interval,
  HistoryQuality quality
) {

  public enum HistoryQuality {
    OK, BAD, UNCERTAIN
  }
}
