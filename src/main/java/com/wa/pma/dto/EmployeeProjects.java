package com.wa.pma.dto;

public interface EmployeeProjects {
	//method names in DTO should start with get followed by the alias name in the select query in DAO annotation
	public String getfirstName();
	public String getlastName();
	public int getprojectCount();
}
