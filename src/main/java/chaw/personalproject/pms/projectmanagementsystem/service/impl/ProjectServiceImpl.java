package chaw.personalproject.pms.projectmanagementsystem.service.impl;

import chaw.personalproject.pms.projectmanagementsystem.entity.Project;
import chaw.personalproject.pms.projectmanagementsystem.dto.ProjectDto;
import chaw.personalproject.pms.projectmanagementsystem.exception.ProjectAlreadyExistsException;
import chaw.personalproject.pms.projectmanagementsystem.mapper.AutoProjectMapper;
import chaw.personalproject.pms.projectmanagementsystem.repository.ProjectRepository;
import chaw.personalproject.pms.projectmanagementsystem.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final AutoProjectMapper projectMapper = AutoProjectMapper.MAPPER;
    private final ProjectRepository projectRepository;

    @Override
    public ProjectDto save(ProjectDto projectRequest) {
        Optional<Project> optionalProject = projectRepository.findByProjectName(projectRequest.getProjectName());

        if (optionalProject.isPresent()) {
            throw new ProjectAlreadyExistsException("Project Already Exists");
        }

        Project project = projectMapper.mapToProject(projectRequest);

        Project savedProject = projectRepository.save(project);

        return projectMapper.mapToProjectDto(savedProject);
    }
}
