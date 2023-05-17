package dc.icdc.pms.projectmanagementsystem.repository;

import dc.icdc.pms.projectmanagementsystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
