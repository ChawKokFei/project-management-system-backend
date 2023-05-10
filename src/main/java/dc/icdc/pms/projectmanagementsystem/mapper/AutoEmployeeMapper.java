package dc.icdc.pms.projectmanagementsystem.mapper;

import dc.icdc.pms.projectmanagementsystem.dto.EmployeeDto;
import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);
}
