package com.fibrecat.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fibrecat.webapp.model.*;
import com.fibrecat.webapp.model.Salary;
import com.fibrecat.webapp.model.SalcodeMst;
import com.fibrecat.webapp.service.SalcodeMstService;

@Controller
@RequestMapping("/salcodeMstList*")
public class SalcodeMstController {
	
    private SalcodeMstService salcodeMstService = null;

    @Autowired
    public void setSalcodeMstService(SalcodeMstService SalcodeMstService) {
        this.salcodeMstService = SalcodeMstService;
    }

    public SalcodeMstService getSalcodeMstService() {
        return this.salcodeMstService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception {
        /**
         * List all data in SalcodeMst table by Simple SQL query.
         */
    	return new ModelAndView().addObject(salcodeMstService.listSalcodeMsts());
    }
}
