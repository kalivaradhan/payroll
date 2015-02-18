package com.fibrecat.webapp.dao;

import java.util.List;
import javax.sql.DataSource;
import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.model.Salary;
import org.appfuse.dao.GenericDao;

public interface SalaryDao extends GenericDao<Salary, Long> {

    /** 
     * This is the method to be used to initialize database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /** 
     * This is the method to be used to create a record in the Employee table.
     */
    public void createSalary(Salary salary);
    /** 
     * This is the method to be used to list down a record from the Salary table corresponding
     * to a passed student id.
     */
    public Salary getSalaryBySQL(long id);
    /** 
     * This is the method to be used to list down all the records from the Salary table.
     */
    public List<Salary> listSalaries();
    /** 
     * This is the method to be used to delete a record from the Salary table corresponding
     * to a passed salary id.
     */
    public void deleteSalary(long id);
    /** 
     * This is the method to be used to update a record into the Salary table.
     */
    public void updateSalary(Salary salary);

    /** 
     * This is the method to be used to create a record in the Salary table.
     */
    void saveSalary(Salary salary) throws AFException;

    /** 
     * This is the method to be used to list down a record from the Salary table corresponding
     * to a passed salary id.
     */
    Salary getSalary(long id) throws AFException;

    /** 
     * This is the method to be used to delete a record from the Salary table corresponding
     * to a passed salary id.
     */
    void removeSalary(long id) throws AFException;

    /** 
     * This is the method to be used to list down all the records from the Salary table.
     */
    List<Salary> getSalaries() throws AFException;

}
