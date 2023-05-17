package dc.icdc.pms.projectmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_emp_id")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

//  Refactor to use as natural key?
    private String employeeNo;

    @Column(nullable = false, unique = true)
    private String email;

//    @NotNull
//    @Past(message = "Date of birth must be in the past")
//    private LocalDate dob;
}
