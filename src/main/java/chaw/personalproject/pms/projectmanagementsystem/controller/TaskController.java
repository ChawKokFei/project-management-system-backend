package chaw.personalproject.pms.projectmanagementsystem.controller;

import chaw.personalproject.pms.projectmanagementsystem.dto.TaskDto;
import chaw.personalproject.pms.projectmanagementsystem.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskRequest) {
        TaskDto task = taskService.save(taskRequest);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
