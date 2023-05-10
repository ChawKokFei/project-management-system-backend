package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.dto.EmployeeDto;
import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.mapper.AutoEmployeeMapper;
import dc.icdc.pms.projectmanagementsystem.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AutoEmployeeMapper employeeMapper = AutoEmployeeMapper.MAPPER;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeRequest) {
        Employee employee = employeeMapper.mapToEmployee(employeeRequest);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();

        return employees
                .stream()
                .map(employeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return employee.map(employeeMapper::mapToEmployeeDto).orElse(null);
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeRequest) {
        employeeRequest.setId(id);

        Employee employee = employeeMapper.mapToEmployee(employeeRequest);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.mapToEmployeeDto(savedEmployee);
    }

    //    @Override
//    public Page<Employee> findAll(Pageable pageable) {
//        Pageable sortedById = PageRequest.of(
//                pageable.getPageNumber(),
//                pageable.getPageSize(),
////                Sort.by(Sort.Order.asc("id")));
//                Sort.by("id").ascending());
//        return employeeRepository.findAll(pageable);
//    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        employeeRepository.deleteAllById(ids);
    }
}
