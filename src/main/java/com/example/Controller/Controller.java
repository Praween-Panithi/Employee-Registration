package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojoclass.EmployeeRegistration;
import com.example.service.EmployeeServiceImplementation;

@RestController
public class Controller {
	
	@Autowired
	private EmployeeServiceImplementation employeeservice;
	
	@GetMapping("/getemployees")
	public void GetEmployeeDetails() {
		employeeservice.getEmployee();
	}
	
	@PostMapping("/createemployee")
	public void CreateEmployee(@RequestBody EmployeeRegistration employeereg) {
		employeeservice.createEmployee(employeereg);
	}
	
	@PutMapping("/updateemployee/{emailid}")
	public void UpdateEmployee(@RequestBody EmployeeRegistration employeereg,@PathVariable("emailid") String email) {
		employeeservice.updateEmployee(employeereg, email);
	}
	
	@DeleteMapping("/deleteemployee/{emailid}")
	public void DeleteEmployee(@PathVariable("emailid") String emailid) {
		employeeservice.deleteRecord(emailid);
	}

}
