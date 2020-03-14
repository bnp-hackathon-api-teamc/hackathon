package com.bnpparibas.hackathon.employee.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.employee.api.controller.impl.EmployeeController;
import com.bnpparibas.hackathon.employee.api.model.Employee;
import com.bnpparibas.hackathon.employee.api.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
public class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeRepository repository;

	@Test
	public void testGetAllEmployees() {
		// Given conditions
		Employee employee1 = new Employee(1, "person1", "hello", "employee1email@gmail.com");
		Employee employee2 = new Employee(2, "person2", "hello", "employee2email@gmail.com");

		when(repository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

		// when...
		List<Employee> result = employeeController.getAllEmployees();

		// then outcome is validated
		assertThat(result.size()).isEqualTo(2);

		assertThat(result.get(0).getFirstName()).isEqualTo(employee1.getFirstName());

		assertThat(result.get(1).getFirstName()).isEqualTo(employee2.getFirstName());

	}

	@Test
	public void testGetEmployeeById() {
		// Given conditions
		String email = "theemployeeemail@gmail.com";
		String firstName = "First";
		String lastName = "and Last Name";

		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));

		when(repository.findById(eq(1L))).thenReturn(Optional.of(new Employee(1, firstName, lastName, email)));

		// when...
		ResponseEntity<Employee> responseEntity;
		try {
			responseEntity = employeeController.getEmployeeById(1L);
		} catch (ResourceNotFoundException e) {
			fail("Unexpected exception, employee not found.");
			return;
		}

		// then the outcome is validated
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

		Employee returnedEmployee = responseEntity.getBody();
		assertThat(returnedEmployee).isNotNull();
		assertThat(returnedEmployee.getEmailId()).isEqualTo(email);
		assertThat(returnedEmployee.getFirstName()).isEqualTo(firstName);
		assertThat(returnedEmployee.getLastName()).isEqualTo(lastName);
		assertThat(returnedEmployee.getId()).isEqualTo(1);
	}

	@Test
	public void testGetEmployeeByIdInexistent() {
		// Given conditions
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));

		when(repository.findById(eq(1L))).thenReturn(Optional.empty());

		try {
			// when...
			employeeController.getEmployeeById(1L);
		} catch (ResourceNotFoundException e) {
			//then we should have a controlled exception...
			assertThat(e.getMessage()).contains("Employee not found");
			return;
		}

		//else if we reach this point the method is not thrown the expected exception 
		fail("Failed to throw ResourceNotFoundException when searching for inexistent user.");
	}
	
	@Test
	public void testGetEmployeeByIdNull() {
		// Given conditions
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));

		try {
			// when...
			employeeController.getEmployeeById(null);
		} catch (ResourceNotFoundException e) {
			//then we should have a controlled exception...
			assertThat(e.getMessage()).contains("Employee not found");
			return;
		}

		//else if we reach this point the method is not thrown the expected exception 
		fail("Failed to throw ResourceNotFoundException when searching for inexistent user.");
	}

	@Test
	public void testCreateEmployee() {
		// Given conditions
		String email = "theemployeeemail@gmail.com";
		String firstName = "First";
		String lastName = "and Last Name";

		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));

		when(repository.save(any(Employee.class))).thenReturn(new Employee(1, firstName, lastName, email));

		// when...
		ResponseEntity<Employee> responseEntity = employeeController
				.createEmployee(new Employee(firstName, lastName, email));

		// then the outcome is validated
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

		Employee returnedEmployee = responseEntity.getBody();
		assertThat(returnedEmployee).isNotNull();
		assertThat(returnedEmployee.getEmailId()).isEqualTo(email);
		assertThat(returnedEmployee.getFirstName()).isEqualTo(firstName);
		assertThat(returnedEmployee.getLastName()).isEqualTo(lastName);
		assertThat(returnedEmployee.getId()).isEqualTo(1);
	}

	@Test
	public void testUpdateEmployee() {
		//TODO hackathon unit test development

		Employee employee1 = new Employee(1, "person1", "hello", "employee1email@gmail.com");

	}

	
	
	@Test
	public void testDeleteEmployee() {
		//TODO hackathon unit test development
	}
	
	//TODO hackathon identify which other unit tests are missing

}
