package com.avinty.hr.model.service;

import com.avinty.hr.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDto employee);

    void deleteEmployee(EmployeeDto employeeDto);

    EmployeeDto findByEmployeeId(String employeeId);

    List<EmployeeDto> findEmployeeByNameOrEmail(String keywords);
}
