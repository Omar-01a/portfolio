package com.omar.portfolio.service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.omar.portfolio.dto.ProjectRequest;
import com.omar.portfolio.entity.Project;
import com.omar.portfolio.entity.Technology;
import com.omar.portfolio.exception.ResourceNotFoundException;
import com.omar.portfolio.repository.ProjectRepository;
import com.omar.portfolio.repository.TechnologyRepository;

@Service

public class ProjectService
 { 
    private final ProjectRepository projectRepository;
private final TechnologyRepository technologyRepository;

public ProjectService(
        ProjectRepository projectRepository,
        TechnologyRepository technologyRepository) {

    this.projectRepository = projectRepository;
    this.technologyRepository = technologyRepository;
}
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

 public Project getProjectById(Long id) {
    return projectRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Project not found"));
}
   

   public Project createProject(ProjectRequest request) {

    Project project = new Project();

    project.setTitle(request.getTitle());
    project.setDescription(request.getDescription());
    project.setCategory(request.getCategory());
    project.setGithubUrl(request.getGithubUrl());
    project.setLiveUrl(request.getLiveUrl());
    project.setImageUrl(request.getImageUrl());

    if (request.getTechnologyIds() != null) {

        Set<Technology> technologies =
                new HashSet<>(technologyRepository.findAllById(
                        request.getTechnologyIds()
                ));

        project.setTechnologies(technologies);
    }

    return projectRepository.save(project);
}

    public Project updateProject(Long id, Project project) {

        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        existingProject.setCategory(project.getCategory());
        existingProject.setGithubUrl(project.getGithubUrl());
        existingProject.setLiveUrl(project.getLiveUrl());
        existingProject.setImageUrl(project.getImageUrl());

        return projectRepository.save(existingProject);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}