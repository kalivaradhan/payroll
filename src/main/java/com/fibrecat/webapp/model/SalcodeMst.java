package com.fibrecat.webapp.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "PA_SALCODE_MST")
public class SalcodeMst {
	private	int PA_SLCM_SALCODE;
	private String PA_SLCM_SALDESC;
	private String PA_SLCM_SHRTNAME;
	private String PA_SLCM_SALTYPE;
	private String PA_SLCM_SALCAT;
	private String PA_SLCM_PRORATA;
	private String PA_SLCM_ITTAXBL;
	private String PA_SLCM_ITPJTN;
	private String PA_SLCM_CCEMPJVTAG;
	private String PA_SLCM_PERIOD;
	private String PA_SLCM_REGCODE;
	private String PA_SLCM_PREPBY;
	private Date PA_SLCM_PREPDT;
	private String PA_SLCM_STATUS;
	private int PA_SLCM_REGSLOT; 
	private String PA_SLCM_REGSLOT_TITL; 

	@Id
	@Column(name = "PA_SLCM_SALCODE", unique = true)
	public int getPA_SLCM_SALCODE() {
		return PA_SLCM_SALCODE;
	}
	public void setPA_SLCM_SALCODE(int pA_SLCM_SALCODE) {
		PA_SLCM_SALCODE = pA_SLCM_SALCODE;
	}
	@Column(name = "PA_SLCM_SALDESC")
	public String getPA_SLCM_SALDESC() {
		return PA_SLCM_SALDESC;
	}
	public void setPA_SLCM_SALDESC(String pA_SLCM_SALDESC) {
		PA_SLCM_SALDESC = pA_SLCM_SALDESC;
	}
	@Column(name = "PA_SLCM_SHRTNAME")
	public String getPA_SLCM_SHRTNAME() {
		return PA_SLCM_SHRTNAME;
	}
	public void setPA_SLCM_SHRTNAME(String pA_SLCM_SHRTNAME) {
		PA_SLCM_SHRTNAME = pA_SLCM_SHRTNAME;
	}
	@Column(name = "PA_SLCM_SALTYPE")
	public String getPA_SLCM_SALTYPE() {
		return PA_SLCM_SALTYPE;
	}
	public void setPA_SLCM_SALTYPE(String pA_SLCM_SALTYPE) {
		PA_SLCM_SALTYPE = pA_SLCM_SALTYPE;
	}
	@Column(name = "PA_SLCM_SALCAT")
	public String getPA_SLCM_SALCAT() {
		return PA_SLCM_SALCAT;
	}
	public void setPA_SLCM_SALCAT(String pA_SLCM_SALCAT) {
		PA_SLCM_SALCAT = pA_SLCM_SALCAT;
	}
	@Column(name = "PA_SLCM_PRORATA")
	public String getPA_SLCM_PRORATA() {
		return PA_SLCM_PRORATA;
	}
	public void setPA_SLCM_PRORATA(String pA_SLCM_PRORATA) {
		PA_SLCM_PRORATA = pA_SLCM_PRORATA;
	}
	@Column(name = "PA_SLCM_ITTAXBL")
	public String getPA_SLCM_ITTAXBL() {
		return PA_SLCM_ITTAXBL;
	}
	public void setPA_SLCM_ITTAXBL(String pA_SLCM_ITTAXBL) {
		PA_SLCM_ITTAXBL = pA_SLCM_ITTAXBL;
	}
	@Column(name = "PA_SLCM_ITPJTN")
	public String getPA_SLCM_ITPJTN() {
		return PA_SLCM_ITPJTN;
	}
	public void setPA_SLCM_ITPJTN(String pA_SLCM_ITPJTN) {
		PA_SLCM_ITPJTN = pA_SLCM_ITPJTN;
	}
	@Column(name = "PA_SLCM_CCEMPJVTAG")
	public String getPA_SLCM_CCEMPJVTAG() {
		return PA_SLCM_CCEMPJVTAG;
	}
	public void setPA_SLCM_CCEMPJVTAG(String pA_SLCM_CCEMPJVTAG) {
		PA_SLCM_CCEMPJVTAG = pA_SLCM_CCEMPJVTAG;
	}
	@Column(name = "PA_SLCM_PERIOD")
	public String getPA_SLCM_PERIOD() {
		return PA_SLCM_PERIOD;
	}
	public void setPA_SLCM_PERIOD(String pA_SLCM_PERIOD) {
		PA_SLCM_PERIOD = pA_SLCM_PERIOD;
	}
	@Column(name = "PA_SLCM_REGCODE")
	public String getPA_SLCM_REGCODE() {
		return PA_SLCM_REGCODE;
	}
	public void setPA_SLCM_REGCODE(String pA_SLCM_REGCODE) {
		PA_SLCM_REGCODE = pA_SLCM_REGCODE;
	}
	@Column(name = "PA_SLCM_PREPBY")
	public String getPA_SLCM_PREPBY() {
		return PA_SLCM_PREPBY;
	}
	public void setPA_SLCM_PREPBY(String pA_SLCM_PREPBY) {
		PA_SLCM_PREPBY = pA_SLCM_PREPBY;
	}
	@Column(name = "PA_SLCM_PREPDT")
	public Date getPA_SLCM_PREPDT() {
		return PA_SLCM_PREPDT;
	}
	public void setPA_SLCM_PREPDT(Date pA_SLCM_PREPDT) {
		PA_SLCM_PREPDT = pA_SLCM_PREPDT;
	}
	@Column(name = "PA_SLCM_STATUS")
	public String getPA_SLCM_STATUS() {
		return PA_SLCM_STATUS;
	}
	public void setPA_SLCM_STATUS(String pA_SLCM_STATUS) {
		PA_SLCM_STATUS = pA_SLCM_STATUS;
	}
	
	@Column(name = "PA_SLCM_REGSLOT")
	public int getPA_SLCM_REGSLOT() {
		return PA_SLCM_REGSLOT;
	}
	public void setPA_SLCM_REGSLOT(int pA_SLCM_REGSLOT) {
		PA_SLCM_REGSLOT = pA_SLCM_REGSLOT;
	}

	@Column(name = "PA_SLCM_REGSLOT_TITL")
	public String getPA_SLCM_REGSLOT_TITL() {
		return PA_SLCM_REGSLOT_TITL;
	}
	public void setPA_SLCM_REGSLOT_TITL(String pA_SLCM_REGSLOT_TITL) {
		PA_SLCM_REGSLOT_TITL = pA_SLCM_REGSLOT_TITL;
	}
}
