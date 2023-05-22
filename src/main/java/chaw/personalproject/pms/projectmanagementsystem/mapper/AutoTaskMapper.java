package chaw.personalproject.pms.projectmanagementsystem.mapper;

import chaw.personalproject.pms.projectmanagementsystem.entity.Task;
import chaw.personalproject.pms.projectmanagementsystem.dto.TaskDto;
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
