package dc.icdc.pms.projectmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;

    @NotEmpty(message = "First Name cannot be null or empty.")
    private String firstName;

    @NotEmpty(message = "Last Name cannot be null or empty.")
    private String lastName;

    private String employeeNo;

    @NotEmpty(message = "Email cannot be null or empty.")
    @Email(message = "Email address should be valid.")
    private String email;
}
