package com.wa.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wa.pma.dto.EmployeeProjects;
import com.wa.pma.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	@Override
	List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount "
			+ "FROM employee AS e left join project_employee AS pe "
			+ "ON e.employee_id = pe.employee_id "
			+ "GROUP BY e.first_name, e.last_name "
			+ "ORDER BY 3 DESC;")
	public List<EmployeeProjects> employeeProjects();
}
