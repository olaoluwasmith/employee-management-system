package com.example.EmployeeMgtSystem.services;

import com.example.EmployeeMgtSystem.entity.Employee;
import com.example.EmployeeMgtSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
            String phoneNumber,
            String department,
            Double salary,
            String gender,
            Double tax,
            Double bonus) {

        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setEmailAddress(emailAddress);
        employee.setHomeAddress(homeAddress);
        employee.setPhoneNumber(phoneNumber);
        employee.setDepartment(department);
        employee.setSalary(salary);
        employee.setGender(gender);
        employee.setTax(tax);
        employee.setBonus(bonus);

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployee(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        return optionalEmployee.orElse(null);
    }

    @Override
    public void updateEmployee(Employee employee) {
        // Check if the employee exists before updating
        if (employeeRepository.existsById(employee.getId())) {
            employeeRepository.save(employee);
        } else {
            throw new IllegalArgumentException("Employee not found");
        }
    }

    @Override
    public void deleteEmployee(long id) {
        // Check if the employee exists before deleting
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Employee not found");
        }
    }
}



