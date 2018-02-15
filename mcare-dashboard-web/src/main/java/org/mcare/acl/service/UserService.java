package org.mcare.acl.service;

import org.mcare.acl.dao.AccountDao;
import org.mcare.acl.entity.Account;
import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private DatabaseRepositoryImpl repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AccountDao accountDao;

	@Transactional
	public void registerNewUserAccount(Account account) {
		if (emailExist(account.getEmail())) {
			System.out.println("Account already exist");
		} else {
			account.setUsername(account.getUsername());
			account.setFirstName(account.getFirstName());
			account.setLastName(account.getLastName());
			account.setEmail(account.getEmail());
			account.setEnabled(true);
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			repository.save(account);
		}
	}

	private boolean emailExist(String email) {
		Account account = repository.findByKey(email,"email", Account.class);
		if (account != null) {
			return true;
		}
		return false;
	}
}
