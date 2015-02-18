package com.fibrecat.webapp.dao.impl;

import com.fibrecat.webapp.common.AFException;
import com.fibrecat.webapp.dao.EmployeeDao;
import com.fibrecat.webapp.model.Employee;
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

@Repository("employeeDao")
public class EmployeeDaoImpl extends GenericDaoHibernate<Employee, String> implements EmployeeDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    public void createEmployee(Employee employee) {
        String SQL = "insert into EMPLOYEE (NAME, OFFICE, INTERESTS, fullTimeEmployee," +
            "CERTIFICATIONS, ID) values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        UUID id = UUID.randomUUID();
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getOffice());
            ps.setString(3, employee.getInterests());
            ps.setBoolean(4, employee.isFullTimeEmployee());
            ps.setString(5, employee.getCertifications());
            ps.setString(6, id.toString());
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

    public Employee getEmployeeBySQL(String id) {
       String SQL = "select * from EMPLOYEE where id = ?";
       Employee employee = null;
       Connection conn = null;
       try {
           conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(SQL);
           ps.setString(1, id);
           ResultSet rs = ps.executeQuery();
           if (rs.next()) {
               employee = new Employee();
               employee.setCertifications(rs.getString("CERTIFICATIONS"));
               employee.setFullTimeEmployee(rs.getBoolean("fullTimeEmployee"));
               employee.setId(rs.getString("ID"));
               employee.setInterests(rs.getString("INTERESTS"));
               employee.setName(rs.getString("NAME"));
               employee.setOffice(rs.getString("OFFICE"));
               employee.setProfilePhoto(rs.getBlob("PROFILE_PHOTO"));
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
       return employee;
    }

    public List<Employee> listEmployees() {
       String SQL = "select * from Employee";
       List<Employee> employees = new ArrayList<Employee>();
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           rs = ps.executeQuery();
           while(rs.next()){
               Employee employee = new Employee();
               employee.setCertifications(rs.getString("CERTIFICATIONS"));
               employee.setFullTimeEmployee(rs.getBoolean("fullTimeEmployee"));
               employee.setId(rs.getString("ID"));
               employee.setInterests(rs.getString("INTERESTS"));
               employee.setName(rs.getString("NAME"));
               employee.setOffice(rs.getString("OFFICE"));
               employee.setProfilePhoto(rs.getBlob("PROFILE_PHOTO"));
               employees.add(employee);
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
       return employees;
    }

    public void deleteEmployee(String id){
       String SQL = "delete from EMPLOYEE where id = ?";
       Connection con = null;
       PreparedStatement ps = null;
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           ps.setString(1, id);
           int out = ps.executeUpdate();
           if(out !=0){
               System.out.println("Employee deleted with id="+id);
           }else System.out.println("No Employee found with id="+id);
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

    public void updateEmployee(Employee employee){
       String SQL = "update EMPLOYEE set NAME = ?, OFFICE = ?, INTERESTS = ?," +
           "fullTimeEmployee = ?, CERTIFICATIONS = ? where ID = ?";
       Connection con = null;
       PreparedStatement ps = null;
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           ps.setString(1, employee.getName());
           ps.setString(2, employee.getOffice());
           ps.setString(3, employee.getInterests());
           ps.setBoolean(4, employee.isFullTimeEmployee());
           ps.setString(5, employee.getCertifications());
           ps.setString(6, employee.getId());
           int out = ps.executeUpdate();
           if(out !=0){
               System.out.println("Employee updated with id="+employee.getId());
           }else System.out.println("No Employee found with id="+employee.getId());
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

    public void saveEmployee(Employee employee) throws AFException {
        getSession().saveOrUpdate(employee);
        getSession().flush();
    }

    public Employee getEmployee(String id) throws AFException {
        List<Employee> employee = getSession().createQuery(
                "select employee from Employee as employee where employee.id = :id")
        .setParameter("id", id).list();
        if (employee.isEmpty()) {
            return null;
        } else {
            return employee.get(0);
        }
    }

    public void removeEmployee(String id) throws AFException {
        Employee employee = getEmployee(id);
        if(null != employee) {
            getSession().delete(employee);
            getSession().flush();
        }
    }

    public List<Employee> getEmployees() throws AFException {
        List<Employee> employees = getSession().createQuery(
                "select employee from Employee").list();
        return employees;
    }
}
