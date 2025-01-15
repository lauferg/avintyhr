package com.avinty.hr.controller;

import com.avinty.hr.model.dto.EmployeeDto;
import com.avinty.hr.model.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/V1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Integer> createNewEmployee(@RequestBody EmployeeDto employee) {
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<EmployeeDto>> findEmployeesByNameOrEmail(@RequestParam String keywords) {
        return ResponseEntity.ok(employeeService.findEmployeeByNameOrEmail(keywords));
    }

    @GetMapping(path = "/id")
    public ResponseEntity<EmployeeDto> findById(@RequestParam String employeeId) {
        return ResponseEntity.ok(employeeService.findByEmployeeId(employeeId));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Integer> deleteEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.deleteEmployee(employeeDto);
        return ResponseEntity.ok().build();
    }
}

