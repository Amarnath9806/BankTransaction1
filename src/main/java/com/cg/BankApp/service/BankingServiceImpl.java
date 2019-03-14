package com.cg.BankApp.service;

import com.cg.BankApp.dao.BankingDAOImpl;
import com.cg.BankApp.dao.IBankingDAO;
import com.cg.BankApp.dto.CustomerDetails;

public class BankingServiceImpl implements  IBankingService{

	IBankingDAO d= new BankingDAOImpl();
	public CustomerDetails register(CustomerDetails customer) {
		// TODO Auto-generated method stub
		return d.register(customer);
	}
	public CustomerDetails login(long accNo, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
