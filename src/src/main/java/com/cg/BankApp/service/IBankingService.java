package com.cg.BankApp.service;

import com.cg.BankApp.dto.CustomerDetails;

public interface IBankingService {
	public CustomerDetails register(CustomerDetails customer);
	public CustomerDetails login(long accNo,String password);
}
