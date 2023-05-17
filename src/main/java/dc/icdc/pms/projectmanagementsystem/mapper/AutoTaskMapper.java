package dc.icdc.pms.projectmanagementsystem.mapper;

import dc.icdc.pms.projectmanagementsystem.dto.TaskDto;
import dc.icdc.pms.projectmanagementsystem.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoTaskMapper {
    AutoTaskMapper MAPPER = Mappers.getMapper(AutoTaskMapper.class);

    @Mapping(source = "projectId", target = "project.id")
    Task mapToTask(TaskDto taskRequest);

    @Mapping(source = "project.id", target = "projectId")
    TaskDto mapToTaskDto(Task savedTask);
}
