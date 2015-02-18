package com.fibrecat.webapp.controller;

import java.sql.Blob;
import java.util.Locale;
import javax.sql.rowset.serial.SerialBlob;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.fibrecat.webapp.model.Salary;
import com.fibrecat.webapp.service.SalaryService;
import com.fibrecat.webapp.controller.BaseFormController;

@Controller
@RequestMapping("/salaryform*")
public class SalaryFormController extends BaseFormController {
    private SalaryService salaryService = null;

    @Autowired
    public void setSalaryService(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    public SalaryService getSalaryService() {
        return this.salaryService;
    }

    public SalaryFormController() {
        setCancelView("redirect:salarylist");
        setSuccessView("redirect:salarylist");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Salary showForm(HttpServletRequest request) throws Exception {
    	String strId = request.getParameter("salcode");
        if (!StringUtils.isBlank(strId)) {
            long id = Long.parseLong(strId);
            /**
             * Get salary data from Salary table by Simple SQL query.
             */
            return salaryService.getSalaryBySQL(id);
            /**
             * Get salary data from Salary table by Hibernate query.
             */
            //return salaryService.get(id);
        }
        return new Salary();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Salary salary, BindingResult errors,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
        /*if (validator != null) { // validator is null during testing
            validator.validate(salary, errors);
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "salaryform";
            }
        }*/
        log.debug("entering 'onSubmit' method...");
        boolean isNew = false;
        if(salary.getRegcode().trim().equalsIgnoreCase(""))
            isNew = true;
        String success = getSuccessView();
        Locale locale = request.getLocale();
        if (request.getParameter("delete") != null) {
            /**
             * Delete salary data from Salary table by Simple SQL query.
             */
            salaryService.deleteSalary(salary.getSalcode());
            /**
             * Delete salary data from Salary table by Hibernate query.
             */
            //salaryService.removeSalary(salary.getId());
            saveMessage(request, getText("salary.deleted", salary.getRegcode(), locale));
        } else {
            /**
             * Create / Update salary data in Salary table by Simple SQL query.
             */
            if(isNew) {
                salaryService.createSalary(salary);
            } else {
                salaryService.updateSalary(salary);
            }
        	//salaryService.createSalary(salary);
            /**
             * Create / Update salary data in Salary table by Hibernate query.
             */
            //salaryService.saveSalary(salary);
            String key = (isNew == Boolean.TRUE) ? "salary.added" : "salary.updated";
            saveMessage(request, getText(key, salary.getRegcode(), locale));
            //success = "redirect:salaryform?id=" + salary.getId();
            success = "redirect:salarylist";
        }
        return success;
    }
}
