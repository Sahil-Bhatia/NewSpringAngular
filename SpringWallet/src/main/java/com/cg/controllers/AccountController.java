package com.cg.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Account;
import com.cg.entities.ResponseMessage;
import com.cg.services.AccountService;

@RestController
@RequestMapping("/wallet")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

	@Autowired
	AccountService service;

	ResponseMessage resMsg;

	@GetMapping(value = "/")
	public ResponseMessage getAllAccounts() {
		/*
		 * ResponseEntity to return SUCCESS when records found Else, return an error
		 */
		List<Account> accounts = service.getAllAccounts();
		if (accounts == null || accounts.isEmpty()) {
			resMsg = new ResponseMessage("Accounts Not Found", 404, null, null);
			return resMsg;
		} else {
			resMsg = new ResponseMessage("Accounts Found", 200, accounts, null);
			return resMsg;
		}
	}

	@GetMapping(value = "/find/{mobileno}")
	public ResponseMessage findById(@PathVariable Long mobileno) {
		/*
		 * ResponseEntity to return SUCCESS when record is found Else, return an error
		 */
		Account ob;
		try {
			ob = service.findAccount(mobileno);
		} catch (RuntimeException e) {

			resMsg = new ResponseMessage("Account Not Found", 404, null, null);
			return resMsg;

			// return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		resMsg = new ResponseMessage("Account Found", 200, null, ob);
		return resMsg;
		// return new ResponseEntity<Account>(ob, HttpStatus.FOUND);
	}

	@PostMapping(value = "/new", consumes = { "application/json" })
	public ResponseMessage save(@RequestBody Account account) {
		/*
		 * ResponseEntity to return SUCCESS when records added Else, record already
		 * exists return an error
		 */
		try {
			service.addAccount(account);
		} catch (RuntimeException ex) {
			// return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

			resMsg = new ResponseMessage("Account Already Exists", 409, null, account);
			return resMsg;
		}
		// return new ResponseEntity<String>("Record created", HttpStatus.OK);

		resMsg = new ResponseMessage("Account Created", 200, null, account);
		return resMsg;
	}

	@PutMapping(value = "/update", consumes = { "application/json" })
	public ResponseMessage update(@RequestBody Account account) {
		/*
		 * ResponseEntity to return SUCCESS when record is updated Else, return an error
		 */
		try {
			service.updateAccount(account.getAccountMobile(), account.getAccountHolder());
		} catch (RuntimeException e) {
			// return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			resMsg = new ResponseMessage("Account Not Found", 404, null, null);
			return resMsg;
		}
		// return new ResponseEntity<String>("Account updated", HttpStatus.OK);
		resMsg = new ResponseMessage("Account Updated", 200, null, service.findAccount(account.getAccountMobile()));
		return resMsg;
	}

	@DeleteMapping(value = "/delete/{mobileno}")
	public ResponseMessage delete(@PathVariable Long mobileno) {
		/*
		 * ResponseEntity to return SUCCESS when record is deleted Else, return an error
		 */
		try {
			service.deleteAccount(mobileno);
		} catch (RuntimeException e) {
			// return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			resMsg = new ResponseMessage(e.getMessage(), 404, null, null);
			return resMsg;
		}
		// return new ResponseEntity<String>("Account deleted", HttpStatus.OK);
		resMsg = new ResponseMessage("Account Deleted", 200, null, null);
		return resMsg;
	}

	@PutMapping(value = "/deposit", consumes = { "application/json" })
	public ResponseMessage deposit(@RequestBody Account account) {
		/*
		 * ResponseEntity to return SUCCESS when record is updated Else, return an error
		 */
		try {
			service.deposit(account.getAccountMobile(), account.getAccountBalance());
		} catch (RuntimeException e) {
			// return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

			resMsg = new ResponseMessage(e.getMessage(), 404, null, null);
			return resMsg;
		}
		
		// return new ResponseEntity<String>("Amount Deposited", HttpStatus.OK);
		resMsg = new ResponseMessage("Amount Deposited Transaction Successful", 200, null,
				service.findAccount(account.getAccountMobile()));
		return resMsg;
	}

	@PutMapping(value = "/withdraw", consumes = { "application/json" })
	public ResponseMessage withdraw(@RequestBody Account account) {
		/*
		 * ResponseEntity to return SUCCESS when record is updated Else, return an error
		 */
		try {
			service.withdraw(account.getAccountMobile(), account.getAccountBalance());
		} catch (RuntimeException e) {
			// return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

			resMsg = new ResponseMessage(e.getMessage(), 404, null, null);
			return resMsg;
		}
		// return new ResponseEntity<String>("Transaction Successful", HttpStatus.OK);
		resMsg = new ResponseMessage("Transaction Successful", 200, null,
				service.findAccount(account.getAccountMobile()));
		return resMsg;
	}

	@PutMapping(value = "/transfer", consumes = { "application/json" })
	public ResponseMessage transfer(@RequestBody Account data[]) {

		try {
			// service.transferMoney(1234567891L,1234567892L,1500.0);
			service.transferMoney(data[0].getAccountMobile(), data[1].getAccountMobile(), data[0].getAccountBalance());
		} catch (RuntimeException e) {
			// return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

			resMsg = new ResponseMessage(e.getMessage(), 404, null, null);
			return resMsg;
		}
		// return new ResponseEntity<String>("Transaction Successful", HttpStatus.OK);
		List<Account> updatedAccountList = new ArrayList<Account>();
		updatedAccountList.add(service.findAccount(data[0].getAccountMobile()));

		updatedAccountList.add(service.findAccount(data[1].getAccountMobile()));
		resMsg = new ResponseMessage("Transaction Successful", 200, updatedAccountList, null);
		return resMsg;
	}

}
