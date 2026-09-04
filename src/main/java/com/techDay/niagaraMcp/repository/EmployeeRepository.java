package com.techDay.niagaraMcp.repository;

import com.techDay.niagaraMcp.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

  private final Map<Integer, Employee> employeesById = new HashMap<>();
  private final Map<String, Employee> employeesByAlias = new HashMap<>();

  @PostConstruct
  void init() {

    addEmployee(
      new Employee(1001, "aayush",
        "Aayush Kamtikar",
        "Software Engineer I",
        "Pune"));

    addEmployee(
      new Employee(1002, "swapnil",
        "Swapnil Dhamal",
        "Advanced Software Eng",
        "Pune"));

    addEmployee(
      new Employee(1003, "shubham",
        "Shubham Garje",
        "Software Engineer II",
        "Pune"));

    addEmployee(
      new Employee(1004, "isha",
        "Isha Bhargave",
        "Software Engineer I",
        "Pune"));
  }

  private void addEmployee(Employee employee) {
    employeesById.put(employee.id(), employee);
    employeesByAlias.put(employee.alias(), employee);
  }

  public Employee findByAlias(String alias) {
    return employeesByAlias.get(alias.toLowerCase());
  }

  public Employee findById(Integer employeeId) {
    return employeesById.get(employeeId);
  }

  public List<Employee> findAll() {
    return employeesById.values()
      .stream()
      .toList();
  }
}