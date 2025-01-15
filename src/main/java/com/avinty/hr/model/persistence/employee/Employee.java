package com.avinty.hr.model.persistence.employee;

import com.avinty.hr.model.persistence.appointment.Appointment;
import com.avinty.hr.model.persistence.position.Position;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "start_date_of_work")
    private Instant startDateOfWork;

    @Column(name = "end_date_of_work")
    private Instant endDateOfWork;

    @ManyToOne(fetch = FetchType.EAGER)
    private Position position;

    @ManyToMany
    @JoinTable(
            name = "employee_appointment",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id"))

    private Set<Appointment> appointments;
}
