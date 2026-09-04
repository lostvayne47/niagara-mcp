package com.techDay.niagaraMcp.service;

import java.util.List;

import com.techDay.niagaraMcp.model.Project;
import com.techDay.niagaraMcp.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;

  public Project getProjectById(String projectId) {
    return projectRepository.findById(projectId.toLowerCase());
  }

  public Project getProjectByName(String projectName) {
    return projectRepository.findByName(projectName);
  }

  public List<Project> getAllProjects() {
    return projectRepository.findAll();
  }
}