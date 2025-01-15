package com.avinty.hr.model.persistence.position;

import com.avinty.hr.model.persistence.department.Department;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "position_id")
    private String positionId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Department department;
}
