package com.fibrecat.webapp.service.impl;

import java.util.List;
import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.dao.SalaryDao;
import com.fibrecat.webapp.model.Salary;
import com.fibrecat.webapp.service.SalaryService;
import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class SalaryServiceImpl extends GenericManagerImpl<Salary, Long> implements SalaryService{

public SalaryServiceImpl() {}

private SalaryDao salaryDao;

@Autowired
public void setSalaryDao(SalaryDao salaryDao) {
    this.salaryDao = salaryDao;
}

@Autowired
public SalaryServiceImpl(SalaryDao salaryDao) {
    super(salaryDao);
    this.salaryDao = salaryDao;
}

public List<Salary> listSalaries() throws AFException {
    return salaryDao.listSalaries();
}

public Salary getSalaryBySQL(Long id) throws AFException {
    return salaryDao.getSalaryBySQL(id);
}

public void deleteSalary(Long id) throws AFException{
    salaryDao.deleteSalary(id);
}

public void createSalary(Salary salary) throws AFException{
    salaryDao.createSalary(salary);
}

public void updateSalary(Salary salary) throws AFException{
    salaryDao.updateSalary(salary);
}

public List<Salary> getSalaries() throws AFException {
    return salaryDao.getAll();
}

public Salary getSalary(Long id) throws AFException {
    return salaryDao.getSalary(id);
}

public void removeSalary(Long id) throws AFException{
    salaryDao.removeSalary(id);
}

public void saveSalary(Salary salary) throws AFException{
    salaryDao.saveSalary(salary);
}

}
