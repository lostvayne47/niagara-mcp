package com.techDay.niagaraMcp.tool;

import java.util.List;

import com.techDay.niagaraMcp.model.Employee;
import com.techDay.niagaraMcp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeTool
{

  private final EmployeeService employeeService;

  @McpTool(
    name = "getEmployeeByAlias",
    description = "Get employee details by alias"
  )
  public Employee getEmployeeByAlias(String alias) {

    return employeeService.getEmployeeByAlias(alias);
  }

  @McpTool(
    name = "getEmployeeById",
    description = "Get employee details by employee id"
  )
  public Employee getEmployeeById(Integer employeeId) {

    return employeeService.getEmployeeById(employeeId);
  }

  @McpTool(
    name = "getAllEmployees",
    description = "Get details of all employees"
  )
  public List<Employee> getAllEmployees() {

    return employeeService.getAllEmployees();
  }
}