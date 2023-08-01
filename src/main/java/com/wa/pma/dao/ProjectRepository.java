package com.wa.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wa.pma.dto.ChartData;
import com.wa.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery=true, value = "SELECT stage as label, COUNT(project_id) as count "
			+ "FROM project "
			+ "GROUP BY stage;")
	public List<ChartData> getProjectStatus();
}
