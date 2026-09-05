package com.techDay.niagaraMcp.service;

import com.techDay.niagaraMcp.model.Point;
import com.techDay.niagaraMcp.model.Point.PointStatus;
import com.techDay.niagaraMcp.model.Point.PointType;
import com.techDay.niagaraMcp.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService
{

  private final PointRepository pointRepository;

  public Point getPointById(String id)
  {
    return pointRepository.findById(id);
  }

  public Point getPointByName(String displayName)
  {
    return pointRepository.findByName(displayName);
  }

  public Point getPointByPath(String path)
  {
    return pointRepository.findByPath(path);
  }

  public List<Point> getAllPoints()
  {
    return pointRepository.findAll();
  }

  public List<Point> getAllWritablePoints()
  {
    return pointRepository.findAllWritable();
  }

  public List<Point> getPointsByStatus(PointStatus status)
  {
    return pointRepository.findByStatus(status);
  }

  public List<Point> getPointsByType(PointType type)
  {
    return pointRepository.findByType(type);
  }
}
