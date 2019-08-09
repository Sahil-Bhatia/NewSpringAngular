package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cg.dao.AccountDAO;
import com.cg.entities.Account;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.InsufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO dao;
	
	

	@Transactional(propagation = Propagation.REQUIRED)
	public void addAccount(Account ob) {
		// TODO Auto-generated method stub
		if (dao.existsByMobile(ob.getAccountMobile())) {
			throw new AccountException("Account Already exists!!");
		}
		Account ob1=dao.saveAndFlush(ob);
	System.out.println(ob1);
//		dao.save(ob1);
//		
		
	
	}
	

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateAccount(Long mobileno, String ah) {
		// TODO Auto-generated method stub
		if(dao.existsByMobile(mobileno)) {
			Account filter=new Account();
			filter.setAccountMobile(mobileno);
			Example<Account> example=Example.of(filter);
			Optional<Account> optional =dao.findOne(example);
			Account find=optional.get();
			find.setAccountHolder(ah);
			dao.saveAndFlush(find);
		}
		else
			throw new AccountException("Account Doesn't exists!");
		
		
	}
	

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAccount(Long mobileno) {
	if (dao.existsByMobile(mobileno))
		dao.deleteByMobile(mobileno);
	else
			throw new AccountException("Account Doesn't exists!");
	}

	
	@Transactional(readOnly = true)
	public List<Account> getAllAccounts() {

		return dao.findAll();
	}


	
	@Transactional(readOnly = true)
	public Account findAccount(Long mobileno) {
		//Optional<Account> account = dao.existsByMobile(mobileno);
		if (dao.existsByMobile(mobileno)) {
			Account filter=new Account();
			filter.setAccountMobile(mobileno);
			Example<Account> example=Example.of(filter);
			Optional<Account> optional =dao.findOne(example);
			return optional.get();
		} else
			throw new AccountException("No Account Found with Mobile No. "+mobileno);
	}

	
	

	@Transactional(propagation = Propagation.REQUIRED)
	public void transferMoney(Long from, Long to, Double amount) throws InsufficientFundException {
	
		Account ac_from=findAccount(from);
		Account ac_to=findAccount(to);
		Double ac_from_bal=0.0;
		Double ac_to_bal=0.0;
		
		if(ac_from!=null && ac_to!=null) {
			
			if(ac_from.getAccountBalance()-amount<1000.0) {
				throw new InsufficientFundException("Insufficient Balance Cannot Process transfer");
				
			}
			else {
				ac_from_bal=ac_from.getAccountBalance()-amount;
				ac_to_bal=ac_to.getAccountBalance()+amount;
				dao.updateBal(from, ac_from_bal);
				dao.updateBal(to, ac_to_bal);
			}
			
		}
		else {
			throw new AccountException("Accounts Doesn't exists");
		}
		
		
	}
	

	@Transactional(propagation = Propagation.REQUIRED)
	public void deposit(Long mobileno, Double amount) {
		Account ac_deposit=findAccount(mobileno);
		Double new_bal=0.0;
		if(ac_deposit!=null) {
			new_bal=ac_deposit.getAccountBalance()+amount;
			dao.updateBal(mobileno, new_bal);	
		}
		else {
			throw new AccountException("No Account Found with Mobile No. "+mobileno);
			
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void withdraw(Long mobileno, Double amount) throws InsufficientFundException {
		
		Account ac_withdraw=findAccount(mobileno);
		Double new_bal=0.0;
		if(ac_withdraw!=null) {
			
			if(ac_withdraw.getAccountBalance()-amount<1000.0) {
				
				throw new InsufficientFundException("Insufficient Balance Cannot Process Withdrwa1", ac_withdraw.getAccountBalance());
			}else {
				new_bal=ac_withdraw.getAccountBalance()-amount;
				dao.updateBal(mobileno, new_bal);
			}
			
		}
		else {
			throw new AccountException("No Account Found with Mobile No. "+mobileno);
			
		}
	}

}
