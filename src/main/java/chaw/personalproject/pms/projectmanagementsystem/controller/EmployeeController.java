package chaw.personalproject.pms.projectmanagementsystem.controller;

import chaw.personalproject.pms.projectmanagementsystem.dto.EmployeeDto;
import chaw.personalproject.pms.projectmanagementsystem.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(
        name = "CRUD REST APIs for Employee Resource",
        description = "CRUD REST APIs - Create Employee, Update Employee, Get Employee, Get All Employees, Delete Employee"
)
@RestController
@AllArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Operation(
            summary = "Create Employee REST API",
            description = "Create Employee REST API is used to save employee in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeRequest) {
        EmployeeDto employee = employeeService.save(employeeRequest);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = employeeService.findById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDto>> getEmployeesByPage(@PageableDefault(size = 5) Pageable page) {
        return new ResponseEntity<>(employeeService.findAll(page), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.findAll();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id,
                                                          @Valid @RequestBody EmployeeDto employeeRequest) {
        employeeRequest.setId(id);
        EmployeeDto employee = employeeService.update(employeeRequest);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteById(id);

        return new ResponseEntity<>("Deleted ".concat(id.toString()), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployeeByIds(@RequestParam Optional<List<Long>> ids) {
        employeeService.deleteAllById(ids.get());

        return new ResponseEntity<>("Deleted ".concat(ids.get().toString()), HttpStatus.OK);
    }
}
