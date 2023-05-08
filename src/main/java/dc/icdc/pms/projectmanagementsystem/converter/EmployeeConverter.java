package dc.icdc.pms.projectmanagementsystem.converter;

import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.request.EmployeeRequest;
import dc.icdc.pms.projectmanagementsystem.response.EmployeeResponse;

public class EmployeeConverter {
    public static Employee toEntity(EmployeeRequest employeeRequest) {
        return new Employee(
                null,
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmployeeNo(),
                employeeRequest.getDob()
        );
    }

    public static EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmployeeNo(),
                employee.getDob()
        );
    }
}
