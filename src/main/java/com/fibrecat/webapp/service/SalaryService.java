package com.fibrecat.webapp.service;

import java.util.List;
import org.appfuse.service.GenericManager;
import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.model.Salary;

public interface SalaryService extends GenericManager<Salary, Long> {

    /**
     * {@inheritDoc}
     */
    List<Salary> listSalaries() throws AFException;

    /**
     * {@inheritDoc}
     */
    Salary getSalaryBySQL(Long id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void deleteSalary(Long id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void createSalary(Salary salary) throws AFException;

    /**
     * {@inheritDoc}
     */
    void updateSalary(Salary salary) throws AFException;

    /**
     * {@inheritDoc}
     */
    Salary getSalary(Long id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void removeSalary(Long id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void saveSalary(Salary salary) throws AFException;

    /**
     * {@inheritDoc}
     */
    List<Salary> getSalaries() throws AFException;


}
