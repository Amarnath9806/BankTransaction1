package com.cg.BankApp.dao;

import com.cg.BankApp.dto.CustomerDetails;

public interface IBankingDAO {
public CustomerDetails register(CustomerDetails customer);
public CustomerDetails login(long accNo,String password);
}
