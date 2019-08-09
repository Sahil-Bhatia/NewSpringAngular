package com.cg.exceptions;

public class InsufficientFundException extends RuntimeException {

	private double balance;

	public InsufficientFundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	public InsufficientFundException(String msg, double balance) {
		// TODO Auto-generated constructor stub
		super(msg);
		this.balance=balance;
		
	}
	@Override
	public String toString() {
		return "InsufficientFundException [balance="+balance+"] "+super.getMessage();
	}
}
