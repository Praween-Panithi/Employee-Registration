package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojoclass.EmployeeRegistration;
import com.example.repo.EmployeeRepo;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public String createEmployee(EmployeeRegistration e) {
		repo.save(e);
		return "Inserted_Record";
	}

	@Override
	public  String updateEmployee(EmployeeRegistration e,String Emailid) {
		List<EmployeeRegistration> list = new ArrayList<EmployeeRegistration>();
		repo.findAll().forEach(list::add);
		for(int i=0;i<list.size();i++){
			EmployeeRegistration employeeregistration = list.get(i);
			if(employeeregistration.getEmail().equals(Emailid)) {
				repo.save(e);
				return "Row updated";
			}
		}
		return "User not exists";
	}

	@Override
	public List<EmployeeRegistration> getEmployee() {
		// TODO Auto-generated method stub
		List<EmployeeRegistration> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
		
	}
	
	@Override
	public String deleteRecord(String emailid) {
		repo.deleteByEmail(emailid);
		return "deleted";
	}

}
