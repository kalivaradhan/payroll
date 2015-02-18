package com.fibrecat.webapp.dao;

import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.model.Employee;
import java.util.List;
import javax.sql.DataSource;
import org.appfuse.dao.GenericDao;

public interface EmployeeDao extends GenericDao<Employee, String> {

    /** 
     * This is the method to be used to initialize database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /** 
     * This is the method to be used to create a record in the Employee table.
     */
    public void createEmployee(Employee employee);
    /** 
     * This is the method to be used to list down a record from the Employee table corresponding
     * to a passed student id.
     */
    public Employee getEmployeeBySQL(String id);
    /** 
     * This is the method to be used to list down all the records from the Employee table.
     */
    public List<Employee> listEmployees();
    /** 
     * This is the method to be used to delete a record from the Employee table corresponding
     * to a passed employee id.
     */
    public void deleteEmployee(String id);
    /** 
     * This is the method to be used to update a record into the Employee table.
     */
    public void updateEmployee(Employee employee);

    /** 
     * This is the method to be used to create a record in the Employee table.
     */
    void saveEmployee(Employee employee) throws AFException;

    /** 
     * This is the method to be used to list down a record from the Employee table corresponding
     * to a passed employee id.
     */
    Employee getEmployee(String id) throws AFException;

    /** 
     * This is the method to be used to delete a record from the Employee table corresponding
     * to a passed employee id.
     */
    void removeEmployee(String id) throws AFException;

    /** 
     * This is the method to be used to list down all the records from the Employee table.
     */
    List<Employee> getEmployees() throws AFException;

}
