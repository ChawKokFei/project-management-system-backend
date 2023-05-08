package dc.icdc.pms.projectmanagementsystem.controller;

import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.request.EmployeeRequest;
import dc.icdc.pms.projectmanagementsystem.response.EmployeeResponse;
import dc.icdc.pms.projectmanagementsystem.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Scanner;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Log4j2
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        log.info(employeeRequest);
        EmployeeResponse newEmployee = employeeService.save(employeeRequest);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        log.info(employeeRequest);
        log.info(id);
        EmployeeResponse newEmployee = employeeService.update(id, employeeRequest);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>("Deleted ".concat(id.toString()), HttpStatus.OK);
    }
}
