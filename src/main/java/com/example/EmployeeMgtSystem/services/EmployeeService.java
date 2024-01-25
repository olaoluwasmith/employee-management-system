package com.example.EmployeeMgtSystem.services;

import com.example.EmployeeMgtSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void createEmployee(
            String name,
            Integer age,
            String emailAddress,
            String homeAddress,
            String phoneNumber,
            String department,
            double salary);

    public List<Employee> getAllEmployee();
    Employee getEmployee(long id);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(long id);
}
