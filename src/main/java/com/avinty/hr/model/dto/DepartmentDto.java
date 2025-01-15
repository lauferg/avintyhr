package com.avinty.hr.model.dto;

import lombok.Data;

@Data
public class DepartmentDto {

    private String departmentId;
    private String name;
    private EmployeeDto manager;
}
