package dc.icdc.pms.projectmanagementsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dc.icdc.pms.projectmanagementsystem.dto.EmployeeDto;
import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.service.EmployeeService;
import dc.icdc.pms.projectmanagementsystem.service.ProjectService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class ProjectControllerTest {

    private static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;

    private MockHttpServletRequest request;

//    First tried with static but has error is null
//    So cannot use for AfterAll I guess?
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    Need the bean thing at main file
//    otherwise "expected at least 1 bean which qualifies as autowire candidate"
    @Autowired
    private Employee employee;

    @PersistenceContext
    private EntityManager entityManager;

    @Mock
    private EmployeeService employeeServiceMock;

    @BeforeEach
    public void setupBeforeAll() {
        request = new MockHttpServletRequest();

        jdbcTemplate.execute("DELETE FROM employees");
//        request.addParameter("projectName", "First project");
    }

    @AfterEach
    public void tearDownAfterAll() {
        jdbcTemplate.execute("DELETE FROM employees");
    }

    @Test
    public void getEmployeeHttpRequest() throws Exception {
        employee.setFirstName("Kok Fei");
        employee.setLastName("Chaw");
        employee.setEmployeeNo("123A");
        employee.setEmail("chaw@mail");
        entityManager.persist(employee);
        entityManager.flush();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void saveStudentHttpRequest() throws Exception {
        employee.setFirstName("Kok Fei");
        employee.setLastName("Chaw");
        employee.setEmployeeNo("123A");
        employee.setEmail("chaw@mail");

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().is(201))
                .andExpect(jsonPath("$", hasEntry("firstName", "Kok Fei")));
    }

    @Test
    public void deleteEmployeeHttpRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/employees/{id}", 0))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message", is("Employee is not found with id: '0'")))
                .andDo(print());

//        bruh u sure can use mock like this?
//        assertNull(employeeServiceMock.findById(1L));
    }

    @Test
    public void deleteEmployeesHttpRequest() throws Exception {
        mockMvc.perform(delete("/api/v1/employees")
                        .param("ids", "0")
                        .param("ids", "1"))
                .andExpect(status().isOk());
//                .andDo(print());

    }
}
