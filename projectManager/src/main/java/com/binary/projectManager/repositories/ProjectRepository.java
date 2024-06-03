package com.binary.projectManager.repositories;

import com.binary.projectManager.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
