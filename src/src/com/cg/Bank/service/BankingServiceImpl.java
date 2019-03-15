package com.cg.Bank.service;

import com.cg.Bank.dao.BankingDAOImpl;
import com.cg.Bank.dao.IBankingDAO;
import com.cg.Bank.dto.CustomerDetails;

public class BankingServiceImpl implements  IBankingService{

	IBankingDAO d= new BankingDAOImpl();
	public CustomerDetails register(CustomerDetails customer) {
		// TODO Auto-generated method stub
		return d.register(customer);
	}
	
	public CustomerDetails login1(long accNo, String password) {
		// TODO Auto-generated method stub
		return d.login(accNo, password);
	}


	
}