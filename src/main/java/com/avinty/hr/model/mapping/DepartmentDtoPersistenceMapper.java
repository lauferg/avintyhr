package com.avinty.hr.model.mapping;

import com.avinty.hr.model.dto.DepartmentDto;
import com.avinty.hr.model.persistence.department.Department;
import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.Instant;

@Mapper(componentModel = "spring")
public interface DepartmentDtoPersistenceMapper {

    DepartmentDto departmentToDto(Department department);

    Department dtoToDepartment(DepartmentDto dto);

    default Instant map(Timestamp timestamp) {
        return timestamp == null ? null : Instant.from(timestamp.toInstant());
    }

    default Timestamp map(Instant instant) {
        return instant == null ? null : Timestamp.from(instant);
    }
}
