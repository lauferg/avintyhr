package com.avinty.hr.model.service;

import com.avinty.hr.model.dto.AppointmentDto;

public interface AppointmentService {

    void saveAppointment(AppointmentDto appointmentDto);

    void deleteAppointment(AppointmentDto appointmentDto);

    AppointmentDto findAppointmentById(String appointmentId);
}
