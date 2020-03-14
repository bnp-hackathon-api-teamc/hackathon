package com.bnpparibas.hackathon.employee.api.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.employee.api.model.Employee;

public interface EmployeeControllerAPI {

	public Map<String, Boolean> deleteEmployee(Long employeeId) throws com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;

	public ResponseEntity<Employee> updateEmployee(Long employeeId, @Valid Employee employeeDetails) throws ResourceNotFoundException;

	public ResponseEntity<Employee> createEmployee(@Valid Employee employee);

	public ResponseEntity<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException;

	public List<Employee> getAllEmployees();

	public ResponseEntity<Timestamp> getTime();

}
