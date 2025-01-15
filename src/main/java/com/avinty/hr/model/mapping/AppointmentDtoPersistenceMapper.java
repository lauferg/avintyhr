package com.avinty.hr.model.mapping;

import com.avinty.hr.model.dto.AppointmentDto;
import com.avinty.hr.model.persistence.appointment.Appointment;
import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.Instant;

@Mapper(componentModel = "spring")
public interface AppointmentDtoPersistenceMapper {

    AppointmentDto appointmentToDto(Appointment appointmentDto);

    Appointment dtoToAppointment(AppointmentDto appointmentDto);

    default Instant map(Timestamp timestamp) {
        return timestamp == null ? null : Instant.from(timestamp.toInstant());
    }

    default Timestamp map(Instant instant) {
        return instant == null ? null : Timestamp.from(instant);
    }
}
