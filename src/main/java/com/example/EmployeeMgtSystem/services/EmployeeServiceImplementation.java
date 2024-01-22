package com.example.EmployeeMgtSystem.services;

import com.example.EmployeeMgtSystem.entity.Employee;
import com.example.EmployeeMgtSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(
            String name,
            Integer age,
            String emailAddress,
            String homeAddress,
            String phoneNumber) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setEmailAddress(emailAddress);
        employee.setHomeAddress(homeAddress);
        employee.setPhoneNumber(phoneNumber);
        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList;
        employeeList = employeeRepository.findAll();
        return  employeeList;
    }

    @Override
    public Employee getEmployee(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee;
            employee = optionalEmployee.get();
            return employee;
        }
        return  null;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
