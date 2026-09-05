package com.techDay.niagaraMcp.repository;

import com.techDay.niagaraMcp.model.History;
import com.techDay.niagaraMcp.model.History.HistoryQuality;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class HistoryRepository
{

  private final Map<String, History> historiesById = new HashMap<>();

  @PostConstruct
  void init()
  {
    try
    {
      Reader reader = new InputStreamReader(
        new ClassPathResource("mock-data/histories.csv").getInputStream()
      );

      Iterable<CSVRecord> records = CSVFormat.DEFAULT
        .builder()
        .setHeader()
        .setSkipHeaderRecord(true)
        .build()
        .parse(reader);

      for (CSVRecord record : records)
      {
        String rawValue = record.get("value");

        History history = new History(
          record.get("id"),
          record.get("displayName"),
          record.get("sourcePath"),
          rawValue.isBlank() ? null : Double.parseDouble(rawValue),
          record.get("unit"),
          LocalDateTime.parse(record.get("timestamp")),
          Integer.parseInt(record.get("interval")),
          HistoryQuality.valueOf(record.get("quality"))
        );

        addHistory(history);
      }

      log.info("Loaded {} history records from CSV", historiesById.size());
    }
    catch (Exception e)
    {
      log.error("Failed to load histories from CSV", e);
    }
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
