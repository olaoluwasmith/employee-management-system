package com.example.EmployeeMgtSystem.controllers;


import com.example.EmployeeMgtSystem.entity.Employee;
import com.example.EmployeeMgtSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView home() {
        String info = "Employee Management System";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/index");
        modelAndView.addObject("info", info);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/create");
        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();

        List<Employee> employeeList = employeeService.getAllEmployee();
        modelAndView.setViewName("employee/list");
        modelAndView.addObject("employees", employeeList);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "age") Integer age,
            @RequestParam(value = "emailAddress") String emailAddress,
            @RequestParam(value = "homeAddress") String homeAddress,
            @RequestParam(value = "phoneNumber") String phoneNumber
    ) {
        employeeService.createEmployee(name, age, emailAddress, homeAddress, phoneNumber);
        return list();
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(@RequestParam(value = "id") long id) {
        Employee employee = employeeService.getEmployee(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/view");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "id") long id) {
        Employee employee = employeeService.getEmployee(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee/edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView update(Employee employee,
                               @PathVariable(value = "id") long id) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return list();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployee(id);
        return  list();
    }
}
