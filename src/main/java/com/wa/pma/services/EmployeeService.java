package com.wa.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.pma.dao.EmployeeRepository;
import com.wa.pma.dto.EmployeeProjects;
import com.wa.pma.entities.Employee;

@Service
public class EmployeeService {
	
	
//	//field injection
	@Autowired
	EmployeeRepository empRepo; 
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<EmployeeProjects> employeeProjects(){
		return empRepo.employeeProjects();
	}
	
	
//	
//	//Constructor injection
//	public EmployeeService(EmployeeRepository empRepo1) {
//		this.empRepo = empRepo1;
//	}
//	
//	//Setter injection
//	@Autowired
//	public void setEmpRepo(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}
	
}
