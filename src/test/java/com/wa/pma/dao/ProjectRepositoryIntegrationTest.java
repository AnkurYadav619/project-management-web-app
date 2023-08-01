package com.wa.pma.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wa.pma.entities.Project;


//@ContextConfiguration(classes=ProjectManagementApplication.class) //not needed when we modify the package name to be the same as main class and we use @SpringBootTest
//@DataJpaTest
//@SqlGroup({@Sql(executionPhase= ExecutionPhase.BEFORE_TEST_METHOD, scripts={"classpath:schema.sql", "classpath:import.sql"}),
//})
//@Sql(executionPhase= ExecutionPhase.AFTER_TEST_METHOD, scripts="classpath:drop.sql")
//Correcting the package name and replacing the above annotations with @SpringBootTest
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProjectRepositoryIntegrationTest {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New IT1", "COMPLETED", "Test Description");
		proRepo.save(newProject);
		
		//Post save, check if there are 5 projects in the DB
		assertEquals(5, proRepo.findAll().size());
	}
}
