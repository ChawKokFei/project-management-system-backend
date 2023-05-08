package dc.icdc.pms.projectmanagementsystem.repository;

import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
