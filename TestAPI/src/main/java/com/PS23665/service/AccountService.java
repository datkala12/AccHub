package com.PS23665.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PS23665.entity.Account;

@Service
public interface AccountService {
	Account findById(String username);

//	List<Account> getAdministrators();

	List<Account> findAll();

	Account create(Account account);

	Account update(Account account);

	Account delete(Account account);

	Long getTotalAccount();

	Account login(String username, String password);

    Account register(Account account);

    void logout(String username);
}
