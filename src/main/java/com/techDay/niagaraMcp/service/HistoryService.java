package com.techDay.niagaraMcp.service;

import com.techDay.niagaraMcp.model.History;
import com.techDay.niagaraMcp.model.History.HistoryQuality;
import com.techDay.niagaraMcp.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService
{

  private final HistoryRepository historyRepository;

  public History getHistoryById(String id)
  {
    return historyRepository.findById(id);
  }

  public History getHistoryByName(String displayName)
  {
    return historyRepository.findByName(displayName);
  }

  public List<History> getAllHistories()
  {
    return historyRepository.findAll();
  }

  public List<History> getHistoriesBySourcePath(String sourcePath)
  {
    return historyRepository.findBySourcePath(sourcePath);
  }

  public List<History> getHistoriesByQuality(HistoryQuality quality)
  {
    return historyRepository.findByQuality(quality);
  }

  public List<History> getHistoriesByUnit(String unit)
  {
    return historyRepository.findByUnit(unit);
  }
}
