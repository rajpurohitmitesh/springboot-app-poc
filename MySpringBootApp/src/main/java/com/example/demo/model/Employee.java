package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int eid;
	public String ename;
	public String erole;
	public String eadd;
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getErole() {
		return erole;
	}
	public void setErole(String erole) {
		this.erole = erole;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", erole=" + erole + ", eadd=" + eadd + "]";
	}
	
	
	
	
	
}
