package com.avinty.hr.controller;

import com.avinty.hr.model.dto.AppointmentDto;
import com.avinty.hr.model.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/V1/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> deleteAppointment(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.deleteAppointment(appointmentDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id")
    public ResponseEntity<AppointmentDto> findById(@RequestParam String appointmentId) {
        AppointmentDto appointmentDto = appointmentService.findAppointmentById(appointmentId);
        return ResponseEntity.ok(appointmentDto);
    }
}
