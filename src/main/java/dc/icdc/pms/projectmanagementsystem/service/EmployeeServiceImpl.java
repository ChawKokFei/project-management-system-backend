package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.converter.EmployeeConverter;
import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.repository.EmployeeRepository;
import dc.icdc.pms.projectmanagementsystem.request.EmployeeRequest;
import dc.icdc.pms.projectmanagementsystem.response.EmployeeResponse;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeConverter.toEntity(employeeRequest);

        Employee result = employeeRepository.save(employee);
        return EmployeeConverter.toResponse(result);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        Pageable sortedById = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
//                Sort.by(Sort.Order.asc("id")));
                Sort.by("id").ascending());
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
        Employee employee = new Employee(
                id,
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmployeeNo(),
                employeeRequest.getDob());
        Employee result = employeeRepository.save(employee);
        return EmployeeConverter.toResponse(result);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        employeeRepository.deleteAllById(ids);
    }
}
