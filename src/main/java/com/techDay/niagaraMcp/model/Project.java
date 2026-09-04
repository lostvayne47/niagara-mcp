package com.techDay.niagaraMcp.model;

import java.util.List;

public record Project(
  String projectId,
  String projectName,
  String projectManager,
  List<Employee> projectTeam
) {
}