package com.satansk.summer.site.service;

import java.util.List;

import com.satansk.summer.site.bean.Account;

public interface AccountService {
	public List<Account> getAllAccounts();
	public Account getAccount(long id);
	public Account saveAccount(Account account);
	public void deleteAccount(long id);
}
