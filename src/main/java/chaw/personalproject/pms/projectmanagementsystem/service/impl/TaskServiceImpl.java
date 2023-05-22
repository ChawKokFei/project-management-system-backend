package chaw.personalproject.pms.projectmanagementsystem.service.impl;

import chaw.personalproject.pms.projectmanagementsystem.dto.TaskDto;
import chaw.personalproject.pms.projectmanagementsystem.entity.Project;
import chaw.personalproject.pms.projectmanagementsystem.entity.Task;
import chaw.personalproject.pms.projectmanagementsystem.exception.ProjectDoesNotExistsException;
import chaw.personalproject.pms.projectmanagementsystem.mapper.AutoTaskMapper;
import chaw.personalproject.pms.projectmanagementsystem.repository.ProjectRepository;
import chaw.personalproject.pms.projectmanagementsystem.repository.TaskRepository;
import chaw.personalproject.pms.projectmanagementsystem.service.TaskService;
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
