package com.example.EmployeeMgtSystem.services;

import com.example.EmployeeMgtSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(
            String name,
            Integer age,
            String emailAddress,
            String homeAddress,
            String phoneNumber,
            String department,
            Double salary,
            String gender,
            Double tax,
            Double bonus);

    List<Employee> getAllEmployees();

    Employee getEmployee(long id);

    void updateEmployee(Employee employee);

    void deleteEmployee(long id);
}
