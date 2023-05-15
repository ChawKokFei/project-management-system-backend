package dc.icdc.pms.projectmanagementsystem.controller;

import dc.icdc.pms.projectmanagementsystem.dto.EmployeeDto;
import dc.icdc.pms.projectmanagementsystem.entity.Employee;
import dc.icdc.pms.projectmanagementsystem.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Log4j2
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeRequest) {
        EmployeeDto employee = employeeService.save(employeeRequest);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = employeeService.findById(id);

        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDto>> getEmployeesByPage(@PageableDefault(size = 5) Pageable page) {
        try {
            return new ResponseEntity<>(employeeService.findAll(page), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.findAll();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDto employeeRequest) {
        EmployeeDto employee = employeeService.update(id, employeeRequest);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteById(id);

        return new ResponseEntity<>("Deleted ".concat(id.toString()), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployeeByIds(@RequestParam Optional<List<Long>> ids) {
        if (ids.isPresent()) {
            employeeService.deleteAllById(ids.get());

            return new ResponseEntity<>("Deleted ".concat(ids.get().toString()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Please provide at least 1 id", HttpStatus.NO_CONTENT);
        }

    }
}
