package com.techDay.niagaraMcp.service;

import java.util.List;

import com.techDay.niagaraMcp.model.Employee;
import com.techDay.niagaraMcp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService
{
  private final EmployeeRepository employeeRepository;

  public Employee getEmployeeByAlias(String alias)
  {
    return employeeRepository.findByAlias(alias.toLowerCase());
  }

  public Employee getEmployeeById(Integer employeeId)
  {
    return employeeRepository.findById(employeeId);
  }

  public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }

}