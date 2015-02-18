package com.fibrecat.webapp.service.impl;

import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.dao.EmployeeDao;
import com.fibrecat.webapp.model.Employee;
import com.fibrecat.webapp.service.EmployeeService;
import java.util.List;
import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServicempl extends GenericManagerImpl<Employee, String>
        implements EmployeeService {

    public EmployeeServicempl() {}

    private EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    public EmployeeServicempl(EmployeeDao employeeDao) {
        super(employeeDao);
        this.employeeDao = employeeDao;
    }

    public List<Employee> listEmployees() throws AFException {
        return employeeDao.listEmployees();
    }

    public Employee getEmployeeBySQL(String id) throws AFException {
        return employeeDao.getEmployeeBySQL(id);
    }

    public void deleteEmployee(String id) throws AFException{
        employeeDao.deleteEmployee(id);
    }

    public void createEmployee(Employee employee) throws AFException{
        employeeDao.createEmployee(employee);
    }

    public void updateEmployee(Employee employee) throws AFException{
        employeeDao.updateEmployee(employee);
    }

    public List<Employee> getEmployees() throws AFException {
        return employeeDao.getAll();
    }

    public Employee getEmployee(String id) throws AFException {
        return employeeDao.getEmployee(id);
    }

    public void removeEmployee(String id) throws AFException{
        employeeDao.removeEmployee(id);
    }

    public void saveEmployee(Employee employee) throws AFException{
        employeeDao.saveEmployee(employee);
    }

}
