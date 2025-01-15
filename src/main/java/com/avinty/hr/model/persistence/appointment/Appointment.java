package com.avinty.hr.model.persistence.appointment;

import com.avinty.hr.model.persistence.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "appointment_id")
    private String appointmentId;

    @Column(name = "start_date_time")
    private Timestamp startDateTime;

    @Column(name = "end_date_time")
    private Timestamp endDateTime;

    @Column(name = "location")
    private String location;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "employee_appointment",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> participants;
}
