package chaw.personalproject.pms.projectmanagementsystem.mapper;

import chaw.personalproject.pms.projectmanagementsystem.dto.EmployeeDto;
import chaw.personalproject.pms.projectmanagementsystem.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AutoEmployeeMapper {
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    List<EmployeeDto> mapToEmployeesDto(List<Employee> employees);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);
}
