package dc.icdc.pms.projectmanagementsystem.service.impl;

import dc.icdc.pms.projectmanagementsystem.dto.TaskDto;
import dc.icdc.pms.projectmanagementsystem.entity.Project;
import dc.icdc.pms.projectmanagementsystem.entity.Task;
import dc.icdc.pms.projectmanagementsystem.exception.ProjectDoesNotExistsException;
import dc.icdc.pms.projectmanagementsystem.mapper.AutoTaskMapper;
import dc.icdc.pms.projectmanagementsystem.repository.ProjectRepository;
import dc.icdc.pms.projectmanagementsystem.repository.TaskRepository;
import dc.icdc.pms.projectmanagementsystem.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final AutoTaskMapper taskMapper = AutoTaskMapper.MAPPER;
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Override
    public TaskDto save(TaskDto taskRequest) {
        Optional<Project> project = projectRepository.findById(taskRequest.getProjectId());

        if (project.isEmpty()) {
            throw new ProjectDoesNotExistsException("Project Doesn't Exists");
        }

        Task task = taskMapper.mapToTask(taskRequest);

        Task savedTask = taskRepository.save(task);

        return taskMapper.mapToTaskDto(savedTask);
    }
}
