package com.PS23665.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PS23665.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
//	@Query("SELECT DISTINCT ar.accounts FROM authority ar WHERE ar.roles.role_id IN('Admin','User','Manager')")
//	List<Account> getAdministrators();

	public Account findByEmail(String email);

	Account findByUsernameAndPassword(String username, String password);
}
