package com.example.service;

import java.util.List;

import com.example.pojoclass.EmployeeRegistration;

public interface EmployeeService {

	String createEmployee(EmployeeRegistration e);

	String updateEmployee(EmployeeRegistration e, String Emailid);

	List<EmployeeRegistration> getEmployee();

	String deleteRecord(String emailid);

}
