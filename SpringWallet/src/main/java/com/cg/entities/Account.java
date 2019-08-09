package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
@Entity
@Table(name="account_master")
public class Account {
	@Id
	@Column(name = "id", length = 20)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer accountId;
	
	@Column(name = "mobile", length = 10)
	private Long accountMobile;
	@Column(name="accountholder",length=20)
	private String accountHolder;
	@Column(name="balance")
	private Double accountBalance;
	public Account() {
	
	}
	public Account( Long accountMobile, String accountHolder, Double accountBalance) {

		//this.accountId=0;
		this.accountMobile = accountMobile;
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Long getAccountMobile() {
		return accountMobile;
	}
	public void setAccountMobile(Long accountMobile) {
		this.accountMobile = accountMobile;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountMobile=" + accountMobile + ", accountHolder="
				+ accountHolder + ", accountBalance=" + accountBalance + "]";
	}
	
	
}
