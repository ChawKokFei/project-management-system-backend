package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.dto.TaskDto;

public interface TaskService {
    TaskDto save(TaskDto taskRequest);
}
