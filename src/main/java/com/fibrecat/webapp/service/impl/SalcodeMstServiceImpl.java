package com.fibrecat.webapp.service.impl;

import java.util.List;
import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.dao.SalcodeMstDao;
import com.fibrecat.webapp.model.Salary;
import com.fibrecat.webapp.model.SalcodeMst;
import com.fibrecat.webapp.service.SalcodeMstService;
import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class SalcodeMstServiceImpl extends GenericManagerImpl<SalcodeMst, Integer> implements SalcodeMstService{

public SalcodeMstServiceImpl() {}

private SalcodeMstDao SalcodeMstDao;

@Autowired
public void setSalcodeMstDao(SalcodeMstDao SalcodeMstDao) 
{
    this.SalcodeMstDao = SalcodeMstDao;
}

@Autowired
public SalcodeMstServiceImpl(SalcodeMstDao SalcodeMstDao) {
    super(SalcodeMstDao);
    this.SalcodeMstDao = SalcodeMstDao;
}

public List<SalcodeMst> listSalcodeMsts() throws AFException {
    return SalcodeMstDao.listSalcodeMsts();
}

public SalcodeMst getSalcodeMstBySQL(int id) throws AFException {
    return SalcodeMstDao.getSalcodeMstBySQL(id);
}

public void deleteSalcodeMst(int id) throws AFException{
    SalcodeMstDao.deleteSalcodeMst(id);
}

public void createSalcodeMst(SalcodeMst SalcodeMst) throws AFException{
    SalcodeMstDao.createSalcodeMst(SalcodeMst);
}

public void updateSalcodeMst(SalcodeMst SalcodeMst) throws AFException{
    SalcodeMstDao.updateSalcodeMst(SalcodeMst);
}
}
