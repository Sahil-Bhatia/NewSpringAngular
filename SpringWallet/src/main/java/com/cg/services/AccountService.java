package com.cg.services;

import java.util.List;
import java.util.Map;

import com.cg.entities.Account;
import com.cg.exceptions.InsufficientFundException;

public interface AccountService {
	public void addAccount(Account ob);
	public void updateAccount(Long mobileno,String ah);
	public void deleteAccount(Long mobileno);
	public Account findAccount(Long mobileno);
	public List<Account> getAllAccounts();
	
	

	public void transferMoney(Long from, Long to, Double amount) throws InsufficientFundException;
	public void deposit(Long mobileno,Double amount);
	public void withdraw(Long mobileno,Double amount) throws InsufficientFundException;

}
