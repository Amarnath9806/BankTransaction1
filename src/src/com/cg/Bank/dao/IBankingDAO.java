package com.cg.Bank.dao;

import com.cg.Bank.dto.CustomerDetails;

public interface IBankingDAO {
public CustomerDetails register(CustomerDetails customer);
public CustomerDetails login1(long accNo, String password);
}