package com.fibrecat.webapp.service;

import java.util.List;
import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.model.Employee;
import org.appfuse.service.GenericManager;

public interface EmployeeService extends GenericManager<Employee, String> {

    /**
     * {@inheritDoc}
     */
    List<Employee> listEmployees() throws AFException;

    /**
     * {@inheritDoc}
     */
    Employee getEmployeeBySQL(String id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void deleteEmployee(String id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void createEmployee(Employee employee) throws AFException;

    /**
     * {@inheritDoc}
     */
    void updateEmployee(Employee employee) throws AFException;

    /**
     * {@inheritDoc}
     */
    Employee getEmployee(String id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void removeEmployee(String id) throws AFException;

    /**
     * {@inheritDoc}
     */
    void saveEmployee(Employee employee) throws AFException;

    /**
     * {@inheritDoc}
     */
    List<Employee> getEmployees() throws AFException;

}
