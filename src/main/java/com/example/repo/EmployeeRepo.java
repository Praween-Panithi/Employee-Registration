package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojoclass.EmployeeRegistration;

public interface EmployeeRepo extends JpaRepository<EmployeeRegistration,String> {

	void deleteByEmail(String emailid);

}
