package com.avinty.hr.model.service.implementation;

import com.avinty.hr.model.dto.AppointmentDto;
import com.avinty.hr.model.mapping.AppointmentDtoPersistenceMapper;
import com.avinty.hr.model.persistence.appointment.Appointment;
import com.avinty.hr.model.persistence.appointment.AppointmentRepository;
import com.avinty.hr.model.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class JpaRepositoryBasedAppointmentService implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentDtoPersistenceMapper persistenceMapper;

    public JpaRepositoryBasedAppointmentService(AppointmentRepository appointmentRepository, AppointmentDtoPersistenceMapper persistenceMapper) {
        this.appointmentRepository = appointmentRepository;
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = persistenceMapper.dtoToAppointment(appointmentDto);
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = persistenceMapper.dtoToAppointment(appointmentDto);
        appointmentRepository.delete(appointment);
    }

    @Override
    public AppointmentDto findAppointmentById(String appointmentId) {
        Appointment appointment = appointmentRepository.findAppointmentByAppointmentId(appointmentId);
        return persistenceMapper.appointmentToDto(appointment);
    }
}
