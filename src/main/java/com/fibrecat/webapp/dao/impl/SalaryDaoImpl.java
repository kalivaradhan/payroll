package com.fibrecat.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;
import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.dao.SalaryDao;
import com.fibrecat.webapp.model.Salary;

@Repository("salaryDao")
public class SalaryDaoImpl extends GenericDaoHibernate<Salary, Long> implements SalaryDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SalaryDaoImpl() {
        super(Salary.class);
    }

    public void createSalary(Salary salary) {
        String SQL = "insert into SALARY (regcode, salcat, saldesc, saltype," +
            "shrtname, salcode) values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        UUID id = UUID.randomUUID();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, salary.getRegcode());
            ps.setString(2, salary.getSalcat());
            ps.setString(3, salary.getSaldesc());
            ps.setString(4, salary.getSaltype());
            ps.setString(5, salary.getShrtname());
            ps.setLong(6, salary.getSalcode());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public Salary getSalaryBySQL(long id) {
       String SQL = "select * from SALARY where salcode = ?";
       Salary salary = null;
       Connection conn = null;
       try {
           conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(SQL);
           ps.setLong(1, id);
           ResultSet rs = ps.executeQuery();
           if (rs.next()) {
               salary = new Salary();
               salary.setRegcode(rs.getString("regcode"));
               salary.setSalcat(rs.getString("salcat"));
               salary.setSalcode(rs.getLong("salcode"));
               salary.setSaldesc(rs.getString("saldesc"));
               salary.setSaltype(rs.getString("saltype"));
               salary.setShrtname(rs.getString("shrtname"));
           }
           rs.close();
           ps.close();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       } finally {
           if (conn != null) {
               try {
                   conn.close();
               } catch (SQLException e) {}
           }
       }
       return salary;
    }

    public List<Salary> listSalaries() {
       String SQL = "select * from SALARY";
       List<Salary> salarys = new ArrayList<Salary>();
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           rs = ps.executeQuery();
           while(rs.next()){
               Salary salary = new Salary();
               salary.setRegcode(rs.getString("regcode"));
               salary.setSalcat(rs.getString("salcat"));
               salary.setSalcode(rs.getLong("salcode"));
               salary.setSaldesc(rs.getString("saldesc"));
               salary.setSaltype(rs.getString("saltype"));
               salary.setShrtname(rs.getString("shrtname"));
               salarys.add(salary);
           }
       }catch(SQLException e){
           e.printStackTrace();
       }finally{
           try {
               rs.close();
               ps.close();
               con.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return salarys;
    }

    public void deleteSalary(long id){
       String SQL = "delete from SALARY where salcode = ?";
       Connection con = null;
       PreparedStatement ps = null;
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           ps.setLong(1, id);
           int out = ps.executeUpdate();
           if(out !=0){
               System.out.println("Salary deleted with id="+id);
           }else System.out.println("No Salary found with id="+id);
       }catch(SQLException e){
           e.printStackTrace();
       }finally{
           try {
               ps.close();
               con.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }

    public void updateSalary(Salary salary){
       String SQL = "update SALARY set regcode = ?, salcat = ?, saldesc = ?," +
           "saltype = ?, shrtname = ? where salcode = ?";
       Connection con = null;
       PreparedStatement ps = null;
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           ps.setString(1, salary.getRegcode());
           ps.setString(2, salary.getSalcat());
           ps.setString(3, salary.getSaldesc());
           ps.setString(4, salary.getSaltype());
           ps.setString(5, salary.getShrtname());
           ps.setLong(6, salary.getSalcode());
           int out = ps.executeUpdate();
           if(out !=0){
               System.out.println("Salary updated with id="+salary.getSalcode());
           }else System.out.println("No Salary found with id="+salary.getSalcode());
       }catch(SQLException e){
           e.printStackTrace();
       }finally{
           try {
               ps.close();
               con.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }

    public void saveSalary(Salary salary) throws AFException {
        getSession().saveOrUpdate(salary);
        getSession().flush();
    }

    public Salary getSalary(long id) throws AFException {
        List<Salary> salary = getSession().createQuery(
                "select salary from Salary as salary where salary.salcode = :id")
        .setParameter("id", id).list();
        if (salary.isEmpty()) {
            return null;
        } else {
            return salary.get(0);
        }
    }

    public void removeSalary(long id) throws AFException {
        Salary salary = getSalary(id);
        if(null != salary) {
            getSession().delete(salary);
            getSession().flush();
        }
    }

    public List<Salary> getSalaries() throws AFException {
        List<Salary> salarys = getSession().createQuery(
                "select salary from Salary").list();
        return salarys;
    }

}
