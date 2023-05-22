package chaw.personalproject.pms.projectmanagementsystem.controller;

import chaw.personalproject.pms.projectmanagementsystem.dto.ProjectDto;
import chaw.personalproject.pms.projectmanagementsystem.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDto> saveProject(@RequestBody ProjectDto projectRequest) {
        ProjectDto project = projectService.save(projectRequest);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
