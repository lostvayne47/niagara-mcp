package com.techDay.niagaraMcp.repository;

import com.techDay.niagaraMcp.model.History;
import com.techDay.niagaraMcp.model.History.HistoryQuality;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HistoryRepository
{

  private final Map<String, History> historiesById = new HashMap<>();

  @PostConstruct
  void init()
  {
    addHistory(new History(
      "HST-001",
      "AHU-1 Zone Temperature",
      "station:|slot:/HVAC/AHU-1/ZoneTemp",
      22.5,
      "°C",
      LocalDateTime.of(2026, 9, 5, 12, 0, 0),
      300,
      HistoryQuality.OK
    ));

    addHistory(new History(
      "HST-002",
      "AHU-2 Supply Air Temperature",
      "station:|slot:/HVAC/AHU-2/SupplyAirTemp",
      14.3,
      "°C",
      LocalDateTime.of(2026, 9, 5, 12, 0, 0),
      300,
      HistoryQuality.OK
    ));

    addHistory(new History(
      "HST-003",
      "Chiller Power Consumption",
      "station:|slot:/HVAC/Chiller-1/PowerConsumption",
      145.7,
      "kWh",
      LocalDateTime.of(2026, 9, 5, 12, 0, 0),
      3600,
      HistoryQuality.OK
    ));

    addHistory(new History(
      "HST-004",
      "Panel-A Main Voltage",
      "station:|slot:/Electrical/Panel-A/MainVoltage",
      230.1,
      "V",
      LocalDateTime.of(2026, 9, 5, 11, 55, 0),
      60,
      HistoryQuality.UNCERTAIN
    ));

    addHistory(new History(
      "HST-005",
      "Zone 2 CO2 Level",
      "station:|slot:/IAQ/Zone-2/CO2Level",
      null,
      "ppm",
      LocalDateTime.of(2026, 9, 5, 11, 50, 0),
      300,
      HistoryQuality.BAD
    ));
  }

  private void addHistory(History history)
  {
    historiesById.put(history.id().toUpperCase(), history);
  }

  public History findById(String id)
  {
    return historiesById.get(id.toUpperCase());
  }

  public History findByName(String displayName)
  {
    return historiesById.values()
      .stream()
      .filter(history -> history.displayName().equalsIgnoreCase(displayName))
      .findFirst()
      .orElse(null);
  }

  public List<History> findAll()
  {
    return historiesById.values()
      .stream()
      .toList();
  }

  public List<History> findBySourcePath(String sourcePath)
  {
    return historiesById.values()
      .stream()
      .filter(history -> history.sourcePath().equalsIgnoreCase(sourcePath))
      .toList();
  }

  public List<History> findByQuality(HistoryQuality quality)
  {
    return historiesById.values()
      .stream()
      .filter(history -> history.quality() == quality)
      .toList();
  }

  public List<History> findByUnit(String unit)
  {
    return historiesById.values()
      .stream()
      .filter(history -> history.unit().equalsIgnoreCase(unit))
      .toList();
  }
}
