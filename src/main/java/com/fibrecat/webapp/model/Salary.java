package com.fibrecat.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "SALARY")
public class Salary {
	private	long salcode;
	private String saldesc;
	private String shrtname;
	private String saltype;
	private String salcat;
	private String regcode;
    @Id
    @Column(name = "salcode", unique = true)
	public long getSalcode() {
		return salcode;
	}
	public void setSalcode(long salcode) {
		this.salcode = salcode;
	}
    @Column(name = "saldesc")
	public String getSaldesc() {
		return saldesc;
	}
	public void setSaldesc(String saldesc) {
		this.saldesc = saldesc;
	}
    @Column(name = "shrtname")
	public String getShrtname() {
		return shrtname;
	}
	public void setShrtname(String shrtname) {
		this.shrtname = shrtname;
	}
    @Column(name = "saltype")
	public String getSaltype() {
		return saltype;
	}
	public void setSaltype(String saltype) {
		this.saltype = saltype;
	}
    @Column(name = "salcat")
	public String getSalcat() {
		return salcat;
	}
	public void setSalcat(String salcat) {
		this.salcat = salcat;
	}
    @Column(name = "regcode")
	public String getRegcode() {
		return regcode;
	}
	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}
}
