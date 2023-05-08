package dc.icdc.pms.projectmanagementsystem.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String employeeNo;
    private LocalDate dob;
}
