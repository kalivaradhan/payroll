package com.fibrecat.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fibrecat.webapp.service.SalaryService;

@Controller
@RequestMapping("/salarylist*")
public class SalaryController {

    private SalaryService salaryService = null;

    @Autowired
    public void setSalaryService(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    public SalaryService getSalaryService() {
        return this.salaryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception {
        /**
         * List all data in Salary table by Simple SQL query.
         */
        return new ModelAndView().addObject(salaryService.listSalaries());
        
        /**
         * List all data in Salary table by Hibernate query.
         */
        //return new ModelAndView().addObject(salaryService.getAll());
    }
}
