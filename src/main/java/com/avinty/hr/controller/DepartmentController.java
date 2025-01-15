package com.avinty.hr.controller;

import com.avinty.hr.model.dto.AppointmentDto;
import com.avinty.hr.model.dto.DepartmentDto;
import com.avinty.hr.model.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/V1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> saveAppointment(@RequestBody  DepartmentDto departmentDto) {
        departmentService.saveDepartment(departmentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> deleteDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentService.deleteDepartment(departmentDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id")
    public ResponseEntity<DepartmentDto> getDepartment(@RequestParam String departmentId) {
        return ResponseEntity.ok(departmentService.findDepartmentById(departmentId));
    }
}
