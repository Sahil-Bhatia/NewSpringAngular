package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entities.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {
	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN 'true' ELSE 'false' END FROM Account a WHERE a.accountMobile = ?1")
	public  boolean existsByMobile(Long mobileno);
	
	
	@Modifying
	@Transactional
	@Query("DELETE  FROM Account a WHERE a.accountMobile = ?1")
	public void deleteByMobile(Long mobileno);
	
	@Modifying
	@Transactional
	@Query("UPDATE Account a set a.accountBalance=?2  WHERE a.accountMobile = ?1")
	public void updateBal(Long mobileno,Double new_bal);
	
}
