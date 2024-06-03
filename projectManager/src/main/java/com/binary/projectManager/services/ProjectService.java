package com.binary.projectManager.services;


import com.binary.projectManager.dtos.ProjectDto;
import com.binary.projectManager.entities.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project createProject(ProjectDto projectDto);
    Project updateProject(Long id, ProjectDto projectDto);
    void deleteProject(Long id);
    Project getProjectById(Long id);
}
