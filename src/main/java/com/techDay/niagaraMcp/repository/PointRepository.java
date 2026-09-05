package com.techDay.niagaraMcp.repository;

import com.techDay.niagaraMcp.model.Point;
import com.techDay.niagaraMcp.model.Point.PointStatus;
import com.techDay.niagaraMcp.model.Point.PointType;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class PointRepository
{

  private final Map<String, Point> pointsById = new HashMap<>();

  @PostConstruct
  void init()
  {
    try
    {
      Reader reader = new InputStreamReader(
        new ClassPathResource("mock-data/points.csv").getInputStream()
      );

      Iterable<CSVRecord> records = CSVFormat.DEFAULT
        .builder()
        .setHeader()
        .setSkipHeaderRecord(true)
        .build()
        .parse(reader);

      for (CSVRecord record : records)
      {
        Point point = new Point(
          record.get("id"),
          record.get("displayName"),
          record.get("path"),
          record.get("value"),
          record.get("unit"),
          PointType.valueOf(record.get("type")),
          Boolean.parseBoolean(record.get("writable")),
          PointStatus.valueOf(record.get("status"))
        );

        addPoint(point);
      }

      log.info("Loaded {} points from CSV", pointsById.size());
    }
    catch (Exception e)
    {
      log.error("Failed to load points from CSV", e);
    }
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
