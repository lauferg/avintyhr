package com.avinty.hr.model.persistence.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    Appointment findAppointmentByAppointmentId(String appointmentId);
}
