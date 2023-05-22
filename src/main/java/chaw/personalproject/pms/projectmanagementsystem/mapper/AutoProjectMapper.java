package chaw.personalproject.pms.projectmanagementsystem.mapper;

import chaw.personalproject.pms.projectmanagementsystem.dto.ProjectDto;
import chaw.personalproject.pms.projectmanagementsystem.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoProjectMapper {
    AutoProjectMapper MAPPER = Mappers.getMapper(AutoProjectMapper.class);

    Project mapToProject(ProjectDto projectRequest);

    ProjectDto mapToProjectDto(Project savedProject);
}
