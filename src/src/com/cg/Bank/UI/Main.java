package com.cg.Bank.UI;

import java.util.Scanner;

import com.cg.Bank.dto.CustomerDetails;
import com.cg.Bank.service.BankingServiceImpl;
import com.cg.Bank.service.IBankingService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBankingService s = new BankingServiceImpl();
		CustomerDetails customer = new CustomerDetails();
Scanner sc = new Scanner(System.in);
System.out.println("Menu");
System.out.println("1)Register");
System.out.println("2)Login");
System.out.println("3)Exit");
int n=sc.nextInt();
switch(n) {
case 1: 
	
	System.out.println("Enter first name:");
	String fname=sc.next();
	customer.setFirstName(fname);
	System.out.println("Enter last name");
	String lname =sc.next();
	
	customer.setLastName(lname);
	System.out.println("Enter email Id");
	String email=sc.next();
	customer.setEmailId(email);
	System.out.println("Enter password");
	String pass = sc.next();
	customer.setPassword(pass);
	System.out.println("Enter pan card");
	String pan = sc.next();
	customer.setPancardNo(pan);
	System.out.println("Enter aadhar number");
	long adhar=sc.nextLong();
	customer.setAadharNo(adhar);
	System.out.println("Enter address");
	String address= sc.next();
	customer.setAddress(address);
	System.out.println("Enter mobile number");
	long mobile= sc.nextLong();
	customer.setMobileNo(mobile);
	long balance=0;
	customer.setBalance(balance);
customer=	s.register(customer);
System.out.println("your account number is "+customer.getAccountNo());
	break;
	
case 2: System.out.println("Enter account no");
long accNo= sc.nextLong();
System.out.println("enter pass word");
String password = sc.next();
s.login1(accNo, password);
	
	
}
	}

}