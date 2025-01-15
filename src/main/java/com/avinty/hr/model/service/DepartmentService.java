package com.avinty.hr.model.service;

import com.avinty.hr.model.dto.DepartmentDto;
import com.avinty.hr.model.dto.EmployeeDto;

import java.util.List;

public interface DepartmentService {

    void saveDepartment(DepartmentDto departmentDto);

    void deleteDepartment(DepartmentDto departmentDto);

    DepartmentDto findDepartmentById(String departmentId);

    List<EmployeeDto> findAllEmployeesInDepartment(DepartmentDto departmentDto);

}
