package com.avinty.hr.model.persistence.department;

import com.avinty.hr.model.persistence.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Department {

    @Column(name = "department_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String departmentId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Employee manager;
}
