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

import com.fibrecat.webapp.model.SalcodeMst;
import com.fibrecat.webapp.service.SalaryService;
import com.fibrecat.webapp.service.SalcodeMstService;
import com.fibrecat.webapp.controller.BaseFormController;

@Controller
@RequestMapping("/salcodeMstForm*")
public class SalcodeMstFormController extends BaseFormController {
	private SalcodeMstService salcodeMstService = null;

    @Autowired
    public void setSalaryService(SalcodeMstService salcodeMstService) {
        this.salcodeMstService = salcodeMstService;
    }

    public SalcodeMstService getSalaryService() {
        return this.salcodeMstService;
    }

    public SalcodeMstFormController() {
        setCancelView("redirect:salcodeMstList");
        setSuccessView("redirect:salcodeMstList");
    }
    
    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected SalcodeMst showForm(HttpServletRequest request) throws Exception {
        if (!StringUtils.isBlank(request.getParameter("PA_SLCM_SALCODE"))) {
            int id = Integer.parseInt(request.getParameter("PA_SLCM_SALCODE"));
            /**
             * Get salcodeMst data from pa_salcode_mst table by Simple SQL query.
             */
            return salcodeMstService.getSalcodeMstBySQL(id);
        }
        return new SalcodeMst();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(SalcodeMst salcodeMst, BindingResult errors,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }
        log.debug("entering 'onSubmit' method...");
        String success = getSuccessView();
        Locale locale = request.getLocale();
        if (request.getParameter("delete") != null) {
            /**
             * Delete salcodeMst data from pa_salcode_mst table by Simple SQL query.
             */
        	salcodeMstService.deleteSalcodeMst(salcodeMst.getPA_SLCM_SALCODE());
            saveMessage(request, getText("salcodeMst.deleted", salcodeMst.getPA_SLCM_SALDESC(), locale));
        } else {
            String isNew = request.getParameter("isNew");
            System.out.println("isNew::"+isNew);
            /**
             * Create / Update salcodeMst data in pa_salcode_mst table by Simple SQL query.
             */
            if(isNew.equalsIgnoreCase("true")) {
            	salcodeMstService.createSalcodeMst(salcodeMst);
            } else {
            	salcodeMstService.updateSalcodeMst(salcodeMst);
            }
            String key = (isNew.equalsIgnoreCase("true")) ? "salcodeMst.added" : "salcodeMst.updated";
            saveMessage(request, getText(key, salcodeMst.getPA_SLCM_SALDESC(), locale));
            success = "redirect:salcodeMstList";
        }
        return success;
    }
}
