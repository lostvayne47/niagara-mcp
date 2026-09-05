package com.techDay.niagaraMcp.tool;

import com.techDay.niagaraMcp.model.Point;
import com.techDay.niagaraMcp.model.Point.PointStatus;
import com.techDay.niagaraMcp.model.Point.PointType;
import com.techDay.niagaraMcp.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PointTool
{

  private final PointService pointService;

  @McpTool(
    name = "getPointById",
    description = "Get a BMS point by its unique ID (e.g. PNT-001)"
  )
  public Point getPointById(String id)
  {
    return pointService.getPointById(id);
  }

  @McpTool(
    name = "getPointByName",
    description = "Get a BMS point by its display name"
  )
  public Point getPointByName(String displayName)
  {
    return pointService.getPointByName(displayName);
  }

  @McpTool(
    name = "getPointByPath",
    description = "Get a BMS point by its full station path (e.g. station:|slot:/HVAC/AHU-1/ZoneTemp)"
  )
  public Point getPointByPath(String path)
  {
    return pointService.getPointByPath(path);
  }

  @McpTool(
    name = "getAllPoints",
    description = "Get all BMS points in the system"
  )
  public List<Point> getAllPoints()
  {
    return pointService.getAllPoints();
  }

  @McpTool(
    name = "getAllWritablePoints",
    description = "Get all BMS points that are writable (operator-commandable)"
  )
  public List<Point> getAllWritablePoints()
  {
    return pointService.getAllWritablePoints();
  }

  @McpTool(
    name = "getPointsByStatus",
    description = "Get all BMS points filtered by status (OK, FAULT, DISABLED, OVERRIDDEN)"
  )
  public List<Point> getPointsByStatus(PointStatus status)
  {
    return pointService.getPointsByStatus(status);
  }

  @McpTool(
    name = "getPointsByType",
    description = "Get all BMS points filtered by data type (NUMERIC, BOOLEAN, ENUM, STRING)"
  )
  public List<Point> getPointsByType(PointType type)
  {
    return pointService.getPointsByType(type);
  }
}
