package com.techDay.niagaraMcp.tool;

import java.util.List;

import com.techDay.niagaraMcp.model.Project;
import com.techDay.niagaraMcp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectTool {

  private final ProjectService projectService;

  @McpTool(
    name = "getProjectById",
    description = "Get project details by project id"
  )
  public Project getProjectById(String projectId) {

    return projectService.getProjectById(projectId);
  }

  @McpTool(
    name = "getProjectByName",
    description = "Get project details by project name"
  )
  public Project getProjectByName(String projectName) {

    return projectService.getProjectByName(projectName);
  }

  @McpTool(
    name = "getAllProjects",
    description = "Get all projects"
  )
  public List<Project> getAllProjects() {

    return projectService.getAllProjects();
  }
}
