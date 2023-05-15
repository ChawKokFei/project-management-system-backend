package dc.icdc.pms.projectmanagementsystem.service.impl;

import dc.icdc.pms.projectmanagementsystem.dto.EmployeeDto;
import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.exception.EmailAlreadyExistsException;
import dc.icdc.pms.projectmanagementsystem.exception.ResourceNotFoundException;
import dc.icdc.pms.projectmanagementsystem.mapper.AutoEmployeeMapper;
import dc.icdc.pms.projectmanagementsystem.repository.EmployeeRepository;
import dc.icdc.pms.projectmanagementsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AutoEmployeeMapper employeeMapper = AutoEmployeeMapper.MAPPER;

    @Override
    public EmployeeDto save(EmployeeDto employeeRequest) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeRequest.getEmail());

        if (optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already Exists");
        }

        Employee employee = employeeMapper.mapToEmployee(employeeRequest);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();

//        return employees
//                .stream()
//                .map(employeeMapper::mapToEmployeeDto)
//                .collect(Collectors.toList());

        // Added collection mapping method for Employee to EmployeeDto
        return employeeMapper.mapToEmployeesDto(employees);
    }

    @Override
    public Page<EmployeeDto> findAll(Pageable pageable) {
        Pageable sortedById = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
//                Sort.by(Sort.Order.asc("id")));
                Sort.by("id").ascending());
        return employeeRepository.findAll(pageable).map(employeeMapper::mapToEmployeeDto);
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(
                        getResourceNotFoundExceptionSupplier(id)
                );

        return employeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeRequest) {
        Employee employee = employeeRepository.findById(employeeRequest.getId())
                        .orElseThrow(
                                getResourceNotFoundExceptionSupplier(employeeRequest.getId())
                        );

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = employeeRepository.findById(id)
                        .orElseThrow(
                                getResourceNotFoundExceptionSupplier(id)
                        );

        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        // Exception handling(?)

        employeeRepository.deleteAllById(ids);
    }

    private static Supplier<ResourceNotFoundException> getResourceNotFoundExceptionSupplier(Long id) {
        return () -> new ResourceNotFoundException(
                "Employee",
                "id",
                id
        );
    }
}
