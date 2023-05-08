package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.request.EmployeeRequest;
import dc.icdc.pms.projectmanagementsystem.response.EmployeeResponse;

public interface EmployeeService {
    Iterable<Employee> findAll();

    EmployeeResponse save(EmployeeRequest employeeRequest);

    void deleteById(Long id);

    EmployeeResponse update(Long id, EmployeeRequest employeeRequest);
}
