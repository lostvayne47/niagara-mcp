package com.techDay.niagaraMcp.repository;

import com.techDay.niagaraMcp.model.Point;
import com.techDay.niagaraMcp.model.Point.PointStatus;
import com.techDay.niagaraMcp.model.Point.PointType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PointRepository
{

  private final Map<String, Point> pointsById = new HashMap<>();

  @PostConstruct
  void init()
  {
    addPoint(new Point(
      "PNT-001",
      "AHU-1 Zone Temperature",
      "station:|slot:/HVAC/AHU-1/ZoneTemp",
      "22.5",
      "°C",
      PointType.NUMERIC,
      false,
      PointStatus.OK
    ));

    addPoint(new Point(
      "PNT-002",
      "AHU-1 Fan Status",
      "station:|slot:/HVAC/AHU-1/FanStatus",
      "true",
      "",
      PointType.BOOLEAN,
      false,
      PointStatus.OK
    ));

    addPoint(new Point(
      "PNT-003",
      "Chiller Operating Mode",
      "station:|slot:/HVAC/Chiller-1/OperatingMode",
      "COOLING",
      "",
      PointType.ENUM,
      true,
      PointStatus.OK
    ));

    addPoint(new Point(
      "PNT-004",
      "AHU-2 Damper Position",
      "station:|slot:/HVAC/AHU-2/DamperPosition",
      "75.0",
      "%",
      PointType.NUMERIC,
      true,
      PointStatus.OVERRIDDEN
    ));

    addPoint(new Point(
      "PNT-005",
      "Zone 2 Occupancy Sensor",
      "station:|slot:/IAQ/Zone-2/OccupancySensor",
      "OCCUPIED",
      "",
      PointType.ENUM,
      false,
      PointStatus.OK
    ));

    addPoint(new Point(
      "PNT-006",
      "Panel-A Circuit Breaker 3",
      "station:|slot:/Electrical/Panel-A/CB-3/Status",
      "false",
      "",
      PointType.BOOLEAN,
      false,
      PointStatus.FAULT
    ));

    addPoint(new Point(
      "PNT-007",
      "BMS System Status Message",
      "station:|slot:/System/StatusMessage",
      "All systems operational",
      "",
      PointType.STRING,
      true,
      PointStatus.OK
    ));
  }

  private void addPoint(Point point)
  {
    pointsById.put(point.id().toUpperCase(), point);
  }

  public Point findById(String id)
  {
    return pointsById.get(id.toUpperCase());
  }

  public Point findByName(String displayName)
  {
    return pointsById.values()
      .stream()
      .filter(point -> point.displayName().equalsIgnoreCase(displayName))
      .findFirst()
      .orElse(null);
  }

  public Point findByPath(String path)
  {
    return pointsById.values()
      .stream()
      .filter(point -> point.path().equalsIgnoreCase(path))
      .findFirst()
      .orElse(null);
  }

  public List<Point> findAll()
  {
    return pointsById.values()
      .stream()
      .toList();
  }

  public List<Point> findAllWritable()
  {
    return pointsById.values()
      .stream()
      .filter(Point::writable)
      .toList();
  }

  public List<Point> findByStatus(PointStatus status)
  {
    return pointsById.values()
      .stream()
      .filter(point -> point.status() == status)
      .toList();
  }

  public List<Point> findByType(PointType type)
  {
    return pointsById.values()
      .stream()
      .filter(point -> point.type() == type)
      .toList();
  }
}
