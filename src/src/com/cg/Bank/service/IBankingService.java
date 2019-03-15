package com.cg.Bank.service;

import com.cg.Bank.dto.CustomerDetails;

public interface IBankingService {
	public CustomerDetails register(CustomerDetails customer);
	CustomerDetails login1(long accNo, String password);
}