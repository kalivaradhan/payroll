package com.fibrecat.webapp.controller;

import com.fibrecat.webapp.model.Employee;
import com.fibrecat.webapp.controller.BaseFormController;
import com.fibrecat.webapp.service.EmployeeService;
import java.sql.Blob;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/employeeform*")
public class EmployeeFormController extends BaseFormController {
    private EmployeeService employeeService = null;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeService getEmployeeService() {
        return this.employeeService;
    }

    public EmployeeFormController() {
        setCancelView("redirect:employees");
        setSuccessView("redirect:employees");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Employee showForm(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if (!StringUtils.isBlank(id)) {
            /**
             * Get employee data from Employee table by Simple SQL query.
             */
            return employeeService.getEmployeeBySQL(id);
            /**
             * Get employee data from Employee table by Hibernate query.
             */
            //return employeeService.get(id);
        }
        return new Employee();
    }

    @RequestMapping(method = RequestMethod.POST, headers={"content-type=multipart/form-data"})
    public String onSubmit(Employee employee, BindingResult errors,
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam("profilePhoto") CommonsMultipartFile file) throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
        String fileName="";
        if(file != null){
            fileName = file.getOriginalFilename();
            byte[] fileContents = file.getBytes();
            Blob blob = new SerialBlob(fileContents);
            employee.setProfilePhoto(blob);
        }
        /*if (validator != null) { // validator is null during testing
            validator.validate(employee, errors);
            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "employeeform";
            }
        }*/
        log.debug("entering 'onSubmit' method...");
        boolean isNew = false;
        if(employee.getId().trim().equalsIgnoreCase(""))
            isNew = Boolean.TRUE;
        String success = getSuccessView();
        Locale locale = request.getLocale();
        if (request.getParameter("delete") != null) {
            /**
             * Delete employee data from Employee table by Simple SQL query.
             */
            employeeService.deleteEmployee(employee.getId());
            /**
             * Delete employee data from Employee table by Hibernate query.
             */
            //employeeService.removeEmployee(employee.getId());
            saveMessage(request, getText("employee.deleted", employee.getName(), locale));
        } else {
            /**
             * Create / Update employee data in Employee table by Simple SQL query.
             */
            if(isNew == Boolean.TRUE) {
                employeeService.createEmployee(employee);
            } else {
                employeeService.updateEmployee(employee);
            }
            /**
             * Create / Update employee data in Employee table by Hibernate query.
             */
            //employeeService.saveEmployee(employee);
            String key = (isNew == Boolean.TRUE) ? "employee.added" : "employee.updated";
            saveMessage(request, getText(key, employee.getName(), locale));
            //success = "redirect:employeeform?id=" + employee.getId();
            success = "redirect:employees";
        }
        return success;
    }
}
