package com.cg.exceptions;

public class AccountException extends RuntimeException {



	public AccountException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	@Override
	public String toString() {
		return "AccountException "+super.getMessage();
	}
}
