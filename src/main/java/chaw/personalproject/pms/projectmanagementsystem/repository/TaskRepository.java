package chaw.personalproject.pms.projectmanagementsystem.repository;

import chaw.personalproject.pms.projectmanagementsystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
