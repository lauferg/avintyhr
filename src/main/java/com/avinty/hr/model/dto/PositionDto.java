package com.avinty.hr.model.dto;

import lombok.Data;

@Data
public class PositionDto {

    private String positionId;
    private String name;
    private DepartmentDto department;
}
