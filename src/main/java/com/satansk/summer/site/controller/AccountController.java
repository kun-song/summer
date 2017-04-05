package com.satansk.summer.site.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.satansk.summer.config.annotation.WebController;
import com.satansk.summer.site.service.AccountService;

@WebController
public class AccountController {
	@Inject AccountService accountService;
	
	@RequestMapping(value = "account/lists", method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		model.put("accounts", this.accountService.getAllAccounts());
		return "account/list";
	}
}
