package com.fibrecat.webapp.dao;

import java.util.List;
import javax.sql.DataSource;
import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.model.Salary;
import com.fibrecat.webapp.model.SalcodeMst;
import org.appfuse.dao.GenericDao;

public interface SalcodeMstDao extends GenericDao<SalcodeMst, Integer> {

    /** 
     * This is the method to be used to initialize database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /** 
     * This is the method to be used to create a record in the Employee table.
     */
    public void createSalcodeMst(SalcodeMst SalcodeMst);
    /** 
     * This is the method to be used to list down a record from the SalcodeMst table corresponding
     * to a passed SalcodeMst id.
     */
    public SalcodeMst getSalcodeMstBySQL(int id);
    /** 
     * This is the method to be used to list down all the records from the SalcodeMst table.
     */
    public List<SalcodeMst> listSalcodeMsts();
    /** 
     * This is the method to be used to delete a record from the SalcodeMst table corresponding
     * to a passed SalcodeMst id.
     */
    public void deleteSalcodeMst(int id);
    /** 
     * This is the method to be used to update a record into the SalcodeMst table.
     */
    public void updateSalcodeMst(SalcodeMst SalcodeMst);
    
}
