package com.techDay.niagaraMcp.model;

public record Point(
  String id,
  String displayName,
  String path,
  String value,
  String unit,
  PointType type,
  boolean writable,
  PointStatus status
) {

  public enum PointType {
    NUMERIC, BOOLEAN, ENUM, STRING
  }

  public enum PointStatus {
    OK, FAULT, DISABLED, OVERRIDDEN
  }
}
