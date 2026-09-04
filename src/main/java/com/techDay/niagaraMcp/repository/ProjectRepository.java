package com.techDay.niagaraMcp.repository;

import com.techDay.niagaraMcp.model.Project;
import com.techDay.niagaraMcp.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ProjectRepository
{

  private final EmployeeService employeeService;

  private final Map<String, Project> projectsById = new HashMap<>();

  @PostConstruct
  void init()
  {

    addProject(
      new Project(
        "1a2b3c4d",
        "Niagara MCP",
        "Aayush Kamtikar",
        List.of(
          employeeService.getEmployeeByAlias("aayush"),
          employeeService.getEmployeeByAlias("swapnil"),
          employeeService.getEmployeeByAlias("shubham"),
          employeeService.getEmployeeByAlias("isha")
        )
      ));

    addProject(
      new Project(
        "5e6f7g8h",
        "Apollo Claims",
        "Swapnil Dhamal",
        List.of(
          employeeService.getEmployeeByAlias("swapnil"),
          employeeService.getEmployeeByAlias("isha"),
          employeeService.getEmployeeByAlias("aayush")
        )
      ));

    addProject(
      new Project(
        "9i0j1k2l",
        "Phoenix Portal",
        "Shubham Garje",
        List.of(
          employeeService.getEmployeeByAlias("shubham"),
          employeeService.getEmployeeByAlias("swapnil")
        )
      ));

    addProject(
      new Project(
        "3m4n5o6p",
        "Titan Analytics",
        "Isha Bhargave",
        List.of(
          employeeService.getEmployeeByAlias("isha"),
          employeeService.getEmployeeByAlias("aayush"),
          employeeService.getEmployeeByAlias("shubham")
        )
      ));
  }

  private void addProject(Project project)
  {
    projectsById.put(
      project.projectId().toLowerCase(),
      project
    );
  }

  public Project findById(String projectId)
  {

    return projectsById.get(
      projectId.toLowerCase()
    );
  }

  public Project findByName(String projectName)
  {

    return projectsById.values()
      .stream()
      .filter(project ->
        project.projectName()
          .equalsIgnoreCase(projectName))
      .findFirst()
      .orElse(null);
  }

  public List<Project> findAll()
  {

    return projectsById.values()
      .stream()
      .toList();
  }
}