package dc.icdc.pms.projectmanagementsystem.service.impl;

import dc.icdc.pms.projectmanagementsystem.dto.ProjectDto;
import dc.icdc.pms.projectmanagementsystem.entity.Project;
import dc.icdc.pms.projectmanagementsystem.exception.ProjectAlreadyExistsException;
import dc.icdc.pms.projectmanagementsystem.mapper.AutoProjectMapper;
import dc.icdc.pms.projectmanagementsystem.repository.ProjectRepository;
import dc.icdc.pms.projectmanagementsystem.service.ProjectService;
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
