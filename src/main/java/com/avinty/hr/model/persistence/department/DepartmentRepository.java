package com.avinty.hr.model.persistence.department;

import com.avinty.hr.model.persistence.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query("SELECT e FROM Department d JOIN Employee e JOIN Position p WHERE d = :department")
    List<Employee> findAllEmployeesInDepartment(Department department);

    Department findByDepartmentId(String departmentId);
}
