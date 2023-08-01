package com.wa.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wa.pma.entities.Employee;
import com.wa.pma.entities.Project;
import com.wa.pma.services.EmployeeService;
import com.wa.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	//ProjectRepository proRepo;
	
	@Autowired
	EmployeeService empService;
	//EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		return "/projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model){
		Project aProject = new Project();
		List<Employee> employees = empService.getAll();
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project ,Model model) {
		proService.save(project);
		return "redirect:/projects";
	}
	
}
