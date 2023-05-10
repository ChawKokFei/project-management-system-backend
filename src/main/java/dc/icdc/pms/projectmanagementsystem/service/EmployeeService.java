package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
//    Page<Employee> findAll(Pageable pageable);

    EmployeeDto save(EmployeeDto employeeRequest);

    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    EmployeeDto update(Long id, EmployeeDto employeeRequest);

    void deleteById(Long id);

    void deleteAllById(List<Long> ids);


}
