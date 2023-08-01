package com.wa.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wa.pma.dto.ChartData;
import com.wa.pma.dto.EmployeeProjects;
import com.wa.pma.entities.Project;
import com.wa.pma.services.EmployeeService;
import com.wa.pma.services.ProjectService;

@Controller
public class HomeController {
	
	@Value("${version:default value}")
	private String ver;
	
	@Autowired
	ProjectService proService;
	//ProjectRepository proRepo;
	
	@Autowired
	EmployeeService empService;
	//EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		//Map<String, Object> map = new HashMap<>();
		
		model.addAttribute("versionNumber", ver);
		
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = proService.getProjectStatus();
		
		//Lets convert projectData object to JSON format for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		//jsonString looks like ==> [["NOTSTARTED",1], ["INPROGRESS",2], ["COMPLETED",1]]
		
		model.addAttribute("projectStatusCnt",jsonString);
		
		//List<Employee> employees = empRepo.findAll();
		//model.addAttribute("employeesList",employees);
		List<EmployeeProjects> employeeProjectCnt = empService.employeeProjects();
		model.addAttribute("employeeProjectCntList",employeeProjectCnt);
		
		return "main/home";
	}
}
