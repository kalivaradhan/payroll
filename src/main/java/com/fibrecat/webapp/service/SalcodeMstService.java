package com.fibrecat.webapp.service;

import java.util.List;
import org.appfuse.service.GenericManager;
import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.model.Salary;
import com.fibrecat.webapp.model.SalcodeMst;

public interface SalcodeMstService extends GenericManager<SalcodeMst, Integer> {

    /**
     * {@inheritDoc}
     */
    List<SalcodeMst> listSalcodeMsts() throws AFException;

    /**
     * {@inheritDoc}
     */
    SalcodeMst getSalcodeMstBySQL(int id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void deleteSalcodeMst(int id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void createSalcodeMst(SalcodeMst SalcodeMst) throws AFException;

    /**
     * {@inheritDoc}
     */
    void updateSalcodeMst(SalcodeMst SalcodeMst) throws AFException;
}
