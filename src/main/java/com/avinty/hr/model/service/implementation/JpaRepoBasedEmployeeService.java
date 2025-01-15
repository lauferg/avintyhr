package com.avinty.hr.model.service.implementation;

import com.avinty.hr.model.dto.EmployeeDto;
import com.avinty.hr.model.mapping.EmployeeDtoPersistenceMapper;
import com.avinty.hr.model.persistence.employee.Employee;
import com.avinty.hr.model.persistence.employee.EmployeeRepository;
import com.avinty.hr.model.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaRepoBasedEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoPersistenceMapper persistenceMapper;

    public JpaRepoBasedEmployeeService(EmployeeRepository employeeRepository, EmployeeDtoPersistenceMapper persistenceMapper) {
        this.employeeRepository = employeeRepository;
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = persistenceMapper.dtoToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> findEmployeeByNameOrEmail(String keywords) {
        return employeeRepository
                .findAllByEmailOrName(keywords)
                .stream()
                .map(persistenceMapper::employeeToDto)
                .toList();
    }

    @Override
    public EmployeeDto findByEmployeeId(String employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        return persistenceMapper.employeeToDto(employee);
    }

    @Override
    public void deleteEmployee(EmployeeDto employeeDto) {
        Employee employee = persistenceMapper.dtoToEmployee(employeeDto);
        employeeRepository.delete(employee);
    }
}
