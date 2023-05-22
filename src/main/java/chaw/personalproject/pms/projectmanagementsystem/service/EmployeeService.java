package chaw.personalproject.pms.projectmanagementsystem.service;

import chaw.personalproject.pms.projectmanagementsystem.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeRequest);

    List<EmployeeDto> findAll();

    Page<EmployeeDto> findAll(Pageable pageable);

    EmployeeDto findById(Long id);

    EmployeeDto update(EmployeeDto employeeRequest);

    void deleteById(Long id);

    void deleteAllById(List<Long> ids);


}
