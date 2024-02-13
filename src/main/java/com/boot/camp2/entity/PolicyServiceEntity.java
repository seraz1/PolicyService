package com.boot.camp2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "policys")
public class PolicyServiceEntity {

	private String Policyname;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Policyno;
	private String premimumamount;
	public String getPolicyname() {
		return Policyname;
	}
	public void setPolicyname(String policyname) {
		Policyname = policyname;
	}
	public int getPolicyno() {
		return Policyno;
	}
	public void setPolicyno(int policyno) {
		Policyno = policyno;
	}
	public String getPremimumamount() {
		return premimumamount;
	}
	public void setPremimumamount(String premimumamount) {
		this.premimumamount = premimumamount;
	}
	public PolicyServiceEntity(String policyname, int policyno, String premimumamount) {
		super();
		Policyname = policyname;
		Policyno = policyno;
		this.premimumamount = premimumamount;
	}
	public PolicyServiceEntity() {
		super();
	}



}
