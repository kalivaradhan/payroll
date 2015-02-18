package com.fibrecat.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.ui.ExtendedModelMap;

import com.fibrecat.webapp.service.SalaryService;
import com.fibrecat.webapp.model.Salary;


import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/testSalary*")
public class TestSalaryController {

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
    	//Model model = new ExtendedModelMap();
    	//List<Salary> salaryList = new ArrayList<Salary>();
    	//salaryList = salaryService.listSalaries();
    	//model.addAttribute("testList",salaryList);
    	//List<Salary> salaryList11 = salaryService.listSalaries();
    	//System.out.println("================="+salaryList);
        //return new ModelAndView("testSalary",model.asMap());
    	return new ModelAndView().addObject(salaryService.listSalaries());
        /**
         * List all data in Salary table by Hibernate query.
         */
        //return new ModelAndView().addObject(salaryService.getAll());
    }
}
