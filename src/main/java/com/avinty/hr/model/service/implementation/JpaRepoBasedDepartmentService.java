package com.avinty.hr.model.service.implementation;

import com.avinty.hr.model.dto.DepartmentDto;
import com.avinty.hr.model.dto.EmployeeDto;
import com.avinty.hr.model.mapping.DepartmentDtoPersistenceMapper;
import com.avinty.hr.model.mapping.EmployeeDtoPersistenceMapper;
import com.avinty.hr.model.persistence.department.Department;
import com.avinty.hr.model.persistence.department.DepartmentRepository;
import com.avinty.hr.model.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaRepoBasedDepartmentService implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentDtoPersistenceMapper departmentMapper;

    private final EmployeeDtoPersistenceMapper employeeMapper;

    public JpaRepoBasedDepartmentService(DepartmentRepository departmentRepository, DepartmentDtoPersistenceMapper departmentMapper, EmployeeDtoPersistenceMapper employeeMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public void saveDepartment(DepartmentDto departmentDto) {
        Department department = departmentMapper.dtoToDepartment(departmentDto);
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(DepartmentDto departmentDto) {
        Department department = departmentMapper.dtoToDepartment(departmentDto);
        departmentRepository.delete(department);
    }

    @Override
    public DepartmentDto findDepartmentById(String departmentId) {
        Department department = departmentRepository.findByDepartmentId(departmentId);
        return departmentMapper.departmentToDto(department);
    }

    @Override
    public List<EmployeeDto> findAllEmployeesInDepartment(DepartmentDto departmentDto) {
        Department department = departmentMapper.dtoToDepartment(departmentDto);
        return departmentRepository
                .findAllEmployeesInDepartment(department)
                .stream()
                .map(employeeMapper::employeeToDto)
                .toList();
    }
}
