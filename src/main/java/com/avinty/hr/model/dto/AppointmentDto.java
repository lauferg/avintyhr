package com.avinty.hr.model.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class AppointmentDto {

    private String appointmentId;
    private Instant startDateTime;
    private Instant endDateTime;
    private String location;
    private String title;
    private String description;
    private List<EmployeeDto> participants;
}
