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
import com.fibrecat.webapp.dao.SalcodeMstDao;
import com.fibrecat.webapp.model.Salary;
import com.fibrecat.webapp.model.SalcodeMst;
import com.sun.crypto.provider.RSACipher;

@Repository("SalcodeMstDao")
public class SalcodeMstDaoImpl extends GenericDaoHibernate<SalcodeMst, Integer> implements SalcodeMstDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SalcodeMstDaoImpl() {
        super(SalcodeMst.class);
    }

    public void createSalcodeMst(SalcodeMst SalcodeMst) {
    	 String SQL =" INSERT INTO PA_SALCODE_MST ( PA_SLCM_SALCODE, PA_SLCM_SALDESC, PA_SLCM_SHRTNAME, "+
    			     " PA_SLCM_SALTYPE, PA_SLCM_SALCAT, PA_SLCM_PRORATA, PA_SLCM_ITTAXBL, PA_SLCM_ITPJTN, PA_SLCM_CCEMPJVTAG, "+ 
    			     " PA_SLCM_PERIOD, PA_SLCM_REGCODE, PA_SLCM_PREPBY, PA_SLCM_PREPDT, PA_SLCM_STATUS)"+ 
    			     " VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? )";
    	
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, SalcodeMst.getPA_SLCM_SALCODE());
            ps.setString(2, SalcodeMst.getPA_SLCM_SALDESC());
            ps.setString(3, SalcodeMst.getPA_SLCM_SHRTNAME());
            ps.setString(4, SalcodeMst.getPA_SLCM_SALTYPE());
            ps.setString(5, SalcodeMst.getPA_SLCM_SALCAT());
            ps.setString(6, SalcodeMst.getPA_SLCM_PRORATA());
            ps.setString(7, SalcodeMst.getPA_SLCM_ITTAXBL());
            ps.setString(8, SalcodeMst.getPA_SLCM_ITPJTN());
            ps.setString(9, SalcodeMst.getPA_SLCM_CCEMPJVTAG());
            ps.setString(10, SalcodeMst.getPA_SLCM_PERIOD());
            ps.setString(11, SalcodeMst.getPA_SLCM_REGCODE());
            ps.setString(12, SalcodeMst.getPA_SLCM_PREPBY());
            ps.setDate(13, SalcodeMst.getPA_SLCM_PREPDT());
            ps.setString(14, SalcodeMst.getPA_SLCM_STATUS());
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

    public SalcodeMst getSalcodeMstBySQL(int id) {
       String SQL = "select * from PA_SALCODE_MST where PA_SLCM_SALCODE = ?";
       SalcodeMst SalcodeMst = null;
       Connection conn = null;
       System.out.println("Salcode 2");
       try {
           conn = dataSource.getConnection();
           PreparedStatement ps = conn.prepareStatement(SQL);
           ps.setLong(1, id);
           ResultSet rs = ps.executeQuery();
           if (rs.next()) {
               SalcodeMst = new SalcodeMst();
               SalcodeMst.setPA_SLCM_SALCODE(rs.getInt("PA_SLCM_SALCODE"));
               SalcodeMst.setPA_SLCM_SALDESC(rs.getString("PA_SLCM_SALDESC"));
               SalcodeMst.setPA_SLCM_SHRTNAME(rs.getString("PA_SLCM_SHRTNAME"));
               SalcodeMst.setPA_SLCM_SALTYPE(rs.getString("PA_SLCM_SALTYPE"));
               SalcodeMst.setPA_SLCM_SALCAT(rs.getString("PA_SLCM_SALCAT"));
               SalcodeMst.setPA_SLCM_PRORATA(rs.getString("PA_SLCM_PRORATA"));
               SalcodeMst.setPA_SLCM_ITTAXBL(rs.getString("PA_SLCM_ITTAXBL"));
               SalcodeMst.setPA_SLCM_ITPJTN(rs.getString("PA_SLCM_ITPJTN"));
               SalcodeMst.setPA_SLCM_CCEMPJVTAG(rs.getString("PA_SLCM_CCEMPJVTAG"));
               SalcodeMst.setPA_SLCM_PERIOD(rs.getString("PA_SLCM_PERIOD"));
               SalcodeMst.setPA_SLCM_REGCODE(rs.getString("PA_SLCM_REGCODE"));
               SalcodeMst.setPA_SLCM_PREPBY(rs.getString("PA_SLCM_PREPBY"));
               SalcodeMst.setPA_SLCM_PREPDT(rs.getDate("PA_SLCM_PREPDT"));
               SalcodeMst.setPA_SLCM_STATUS(rs.getString("PA_SLCM_STATUS"));
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
       return SalcodeMst;
    }

    public List<SalcodeMst> listSalcodeMsts(){
       String SQL = "select * from pa_salcode_mst";
       List<SalcodeMst> SalcodeMsts = new ArrayList<SalcodeMst>();
       Connection con = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       System.out.println("Salcode 1");
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           rs = ps.executeQuery();
           while(rs.next()){
        	   System.out.println("Salcode 3"+rs.getString("PA_SLCM_SALDESC"));
               SalcodeMst SalcodeMst = new SalcodeMst();
               SalcodeMst.setPA_SLCM_SALCODE(rs.getInt("PA_SLCM_SALCODE"));
               SalcodeMst.setPA_SLCM_SALDESC(rs.getString("PA_SLCM_SALDESC"));
               SalcodeMst.setPA_SLCM_SHRTNAME(rs.getString("PA_SLCM_SHRTNAME"));
               SalcodeMst.setPA_SLCM_SALTYPE(rs.getString("PA_SLCM_SALTYPE"));
               SalcodeMst.setPA_SLCM_SALCAT(rs.getString("PA_SLCM_SALCAT"));
               SalcodeMst.setPA_SLCM_PRORATA(rs.getString("PA_SLCM_PRORATA"));
               SalcodeMst.setPA_SLCM_ITTAXBL(rs.getString("PA_SLCM_ITTAXBL"));
               SalcodeMst.setPA_SLCM_ITPJTN(rs.getString("PA_SLCM_ITPJTN"));
               SalcodeMst.setPA_SLCM_CCEMPJVTAG(rs.getString("PA_SLCM_CCEMPJVTAG"));
               SalcodeMst.setPA_SLCM_PERIOD(rs.getString("PA_SLCM_PERIOD"));
               SalcodeMst.setPA_SLCM_REGCODE(rs.getString("PA_SLCM_REGCODE"));
               SalcodeMst.setPA_SLCM_PREPBY(rs.getString("PA_SLCM_PREPBY"));
               SalcodeMst.setPA_SLCM_PREPDT(rs.getDate("PA_SLCM_PREPDT"));
               SalcodeMst.setPA_SLCM_STATUS(rs.getString("PA_SLCM_STATUS"));
               SalcodeMsts.add(SalcodeMst);
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
       return SalcodeMsts;
    }

    public void deleteSalcodeMst(int id){
       String SQL = "delete from PA_SALCODE_MST where PA_SLCM_SALCODE = ?";
       Connection con = null;
       PreparedStatement ps = null;
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           ps.setLong(1, id);
           int out = ps.executeUpdate();
           if(out !=0){
               System.out.println("SalcodeMst deleted with id="+id);
           }else System.out.println("No SalcodeMst found with id="+id);
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

    public void updateSalcodeMst(SalcodeMst SalcodeMst){
       String SQL = "update PA_SALCODE_MST  set PA_SLCM_SALCODE = ?, PA_SLCM_SALDESC = ?, PA_SLCM_SHRTNAME = ?," +
           "PA_SLCM_SALTYPE = ?, PA_SLCM_SALCAT = ?,PA_SLCM_PRORATA = ?,PA_SLCM_ITTAXBL= ?, PA_SLCM_ITPJTN = ?," +
           "PA_SLCM_CCEMPJVTAG = ?,PA_SLCM_PERIOD = ?,PA_SLCM_REGCODE= ?, PA_SLCM_PREPBY = ?,PA_SLCM_PREPDT = ?," +
           "PA_SLCM_STATUS = ? where PA_SLCM_SALCODE = ?";
       Connection con = null;
       PreparedStatement ps = null;
       try{
           con = dataSource.getConnection();
           ps = con.prepareStatement(SQL);
           ps.setInt(1, SalcodeMst.getPA_SLCM_SALCODE());
           ps.setString(2, SalcodeMst.getPA_SLCM_SALDESC());
           ps.setString(3, SalcodeMst.getPA_SLCM_SHRTNAME());
           ps.setString(4, SalcodeMst.getPA_SLCM_SALTYPE());
           ps.setString(5, SalcodeMst.getPA_SLCM_SALCAT());
           ps.setString(6, SalcodeMst.getPA_SLCM_PRORATA());
           ps.setString(7, SalcodeMst.getPA_SLCM_ITTAXBL());
           ps.setString(8, SalcodeMst.getPA_SLCM_ITPJTN());
           ps.setString(9, SalcodeMst.getPA_SLCM_CCEMPJVTAG());
           ps.setString(10, SalcodeMst.getPA_SLCM_PERIOD());
           ps.setString(11, SalcodeMst.getPA_SLCM_REGCODE());
           ps.setString(12, SalcodeMst.getPA_SLCM_PREPBY());
           ps.setDate(13, SalcodeMst.getPA_SLCM_PREPDT());
           ps.setString(14, SalcodeMst.getPA_SLCM_STATUS());
           ps.setInt(15, SalcodeMst.getPA_SLCM_SALCODE());
           int out = ps.executeUpdate();
           if(out !=0){
               System.out.println("SalcodeMst updated with id="+SalcodeMst.getPA_SLCM_SALCODE());
           }else System.out.println("No SalcodeMst found with id="+SalcodeMst.getPA_SLCM_SALCODE());
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

}
