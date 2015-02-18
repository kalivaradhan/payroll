package com.fibrecat.webapp.controller;

import com.fibrecat.webapp.model.Employee;
import com.fibrecat.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees*")
public class EmployeeController {

    private EmployeeService employeeService = null;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeService getEmployeeService() {
        return this.employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception {
        /**
         * List all data in Employee table by Simple SQL query.
         */
        return new ModelAndView().addObject(employeeService.listEmployees());
        
        /**
         * List all data in Employee table by Hibernate query.
         */
        //return new ModelAndView().addObject(employeeService.getAll());
    }
}