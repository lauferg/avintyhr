package com.avinty.hr.model.persistence.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT e FROM Employee e WHERE e.email = :keywords OR e.name = :keywords")
    List<Employee> findAllByEmailOrName(String keywords);

    Employee findByEmployeeId(String employeeId);
}
