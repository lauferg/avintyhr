package com.avinty.hr.model.mapping;

import com.avinty.hr.model.dto.EmployeeDto;
import com.avinty.hr.model.persistence.employee.Employee;
import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.Instant;

@Mapper(componentModel = "spring")
public interface EmployeeDtoPersistenceMapper {

    Employee dtoToEmployee(EmployeeDto dto);

    EmployeeDto employeeToDto(Employee employee);

    default Instant map(Timestamp timestamp) {
        return timestamp == null ? null : Instant.from(timestamp.toInstant());
    }

    default Timestamp map(Instant instant) {
        return instant == null ? null : Timestamp.from(instant);
    }
}
