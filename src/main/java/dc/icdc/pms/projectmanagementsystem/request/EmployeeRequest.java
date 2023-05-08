package dc.icdc.pms.projectmanagementsystem.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String employeeNo;
    private LocalDate dob;

    public EmployeeRequest(String firstName, String lastName, String employeeNo, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNo = employeeNo;
        this.dob = dob;
    }
}
