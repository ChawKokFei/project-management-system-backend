package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.request.EmployeeRequest;
import dc.icdc.pms.projectmanagementsystem.response.EmployeeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Iterable<Employee> findAll();

    EmployeeResponse save(EmployeeRequest employeeRequest);

    void deleteById(Long id);

    void deleteAllById(List<Long> ids);

    EmployeeResponse update(Long id, EmployeeRequest employeeRequest);

    Optional<Employee> findById(Long id);
}
