package com.cg.entities;

import java.util.List;

public class ResponseMessage {
	
	String message;
	Integer statusCode;
	List<Account> accountList;
	Account accountObject;
	public ResponseMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseMessage(String message, Integer statusCode, List<Account> accountList, Account accountObject) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.accountList = accountList;
		this.accountObject = accountObject;
	}
	
	public List<Account> getAccountList() { 
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public Account getAccountObject() {
		return accountObject;
	}

	public void setAccountObject(Account accountObject) {
		this.accountObject = accountObject;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", statusCode=" + statusCode + ", accountList=" + accountList
				+ ", accountObject=" + accountObject + "]";
	}

	
}
