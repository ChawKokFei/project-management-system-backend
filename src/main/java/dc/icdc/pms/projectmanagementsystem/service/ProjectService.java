package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.dto.ProjectDto;

public interface ProjectService {
    ProjectDto save(ProjectDto projectRequest);
}
