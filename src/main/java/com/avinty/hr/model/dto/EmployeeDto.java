package com.avinty.hr.model.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class EmployeeDto {

    private String employeeId;
    private String name;
    private String email;
    private String phone;
    private PositionDto position;
    private Instant startDateOfWork;
    private Instant endDateOfWork;
    private List<AppointmentDto> appointments;
}
