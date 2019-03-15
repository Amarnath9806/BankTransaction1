package com.cg.Bank.dao;

public interface ITransactionDAO {
	int withdraw(int accountNo,int amount,int balance);
	int deposit(int accountNo,int amount,int balance);
	int showBalance(int accountNo);
	int fundTransfer(int fromAccountNo,int toaccountNo,int amount,int balance);
}