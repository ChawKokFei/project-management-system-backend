package dc.icdc.pms.projectmanagementsystem.service;

import dc.icdc.pms.projectmanagementsystem.dto.EmployeeDto;
import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @BeforeEach
//    public void setupBeforeEach() {
//        jdbcTemplate.execute("""
//                INSERT INTO employees VALUES
//                (100, 'Kok Fei', 'Chaw', '123A', 'kok@mail')
//                """);
//    }
//
//    @AfterEach
//    public void tearDownAfterEach() {
//        jdbcTemplate.execute("""
//                DELETE FROM employees WHERE pk_emp_id = 100
//                """);
//        jdbcTemplate.execute("""
//                DELETE FROM employees
//                """);
//    }

    @Test
    public void saveEmployeeMock() {
        when(employeeRepository.save(new Employee(
                        null,
                        "Kok Fei",
                        "Chaw",
                        "123A",
                        "chaw@mail"
                )
        )).thenReturn(new Employee(
                        1L,
                        "Kok Fei",
                        "Chaw",
                        "123A",
                        "chaw@mail"
                )
        );

        EmployeeDto employeeDto = new EmployeeDto(null,
                "Kok Fei",
                "Chaw",
                "123A",
                "chaw@mail");

        EmployeeDto savedEmployee = employeeService.save(employeeDto);

        String expected = "chaw@mail";
        String actual = savedEmployee.getEmail();

        assertEquals(expected, actual, "Find by email");
    }
}
