package com.techDay.niagaraMcp.tool;

import com.techDay.niagaraMcp.model.History;
import com.techDay.niagaraMcp.model.History.HistoryQuality;
import com.techDay.niagaraMcp.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HistoryTool
{

  private final HistoryService historyService;

  @McpTool(
    name = "getHistoryById",
    description = "Get a BMS history (trend) record by its unique ID (e.g. HST-001)"
  )
  public History getHistoryById(String id)
  {
    return historyService.getHistoryById(id);
  }

  @McpTool(
    name = "getHistoryByName",
    description = "Get a BMS history record by its display name"
  )
  public History getHistoryByName(String displayName)
  {
    return historyService.getHistoryByName(displayName);
  }

  @McpTool(
    name = "getAllHistories",
    description = "Get all BMS history (trend) records"
  )
  public List<History> getAllHistories()
  {
    return historyService.getAllHistories();
  }

  @McpTool(
    name = "getHistoriesBySourcePath",
    description = "Get all BMS history records for a specific source path (e.g. station:|slot:/HVAC/AHU-1/ZoneTemp)"
  )
  public List<History> getHistoriesBySourcePath(String sourcePath)
  {
    return historyService.getHistoriesBySourcePath(sourcePath);
  }

  @McpTool(
    name = "getHistoriesByQuality",
    description = "Get all BMS history records filtered by data quality (OK, BAD, UNCERTAIN)"
  )
  public List<History> getHistoriesByQuality(HistoryQuality quality)
  {
    return historyService.getHistoriesByQuality(quality);
  }

  @McpTool(
    name = "getHistoriesByUnit",
    description = "Get all BMS history records filtered by engineering unit (e.g. °C, kWh, V)"
  )
  public List<History> getHistoriesByUnit(String unit)
  {
    return historyService.getHistoriesByUnit(unit);
  }
}
