package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.converter.EmployeeConverter;
import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.repository.EmployeeRepository;
import dc.icdc.pms.projectmanagementsystem.request.EmployeeRequest;
import dc.icdc.pms.projectmanagementsystem.response.EmployeeResponse;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.stereotype.Service;

import java.util.List;

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
