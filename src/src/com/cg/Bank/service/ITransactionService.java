package com.cg.Bank.service;

public interface ITransactionService {
	int withdraw(int accountNo,int amount,int balance);
	int deposit(int accountNo,int amount,int balance);
	int showBalance(int accountNo);
	int fundTransfer(int fromAccountNo,int toaccountNo,int amount,int balance);
}