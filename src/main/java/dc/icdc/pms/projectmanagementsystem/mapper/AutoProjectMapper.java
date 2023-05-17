package dc.icdc.pms.projectmanagementsystem.mapper;

import dc.icdc.pms.projectmanagementsystem.dto.ProjectDto;
import dc.icdc.pms.projectmanagementsystem.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoProjectMapper {
    AutoProjectMapper MAPPER = Mappers.getMapper(AutoProjectMapper.class);

    Project mapToProject(ProjectDto projectRequest);

    ProjectDto mapToProjectDto(Project savedProject);
}
