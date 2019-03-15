package com.cg.BankApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cg.BankApp.dto.CustomerDetails;

public class BankingDAOImpl implements IBankingDAO {
Scanner sc = new Scanner(System.in);
	public CustomerDetails register(CustomerDetails customer) {
		int i;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oraclework","oraclework");
			
			PreparedStatement preparedStatement= connection.prepareStatement("insert into customer_details values(account_no.nextval,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setLong(1, customer.getAadharNo());
			preparedStatement.setString(2,customer.getFirstName());
			preparedStatement.setString(3,customer.getLastName());
			preparedStatement.setString(4,customer.getEmailId());
			preparedStatement.setString(5, customer.getPassword());
			preparedStatement.setString(6,customer.getPancardNo());
			preparedStatement.setString(7,customer.getAddress());
			preparedStatement.setLong(8,customer.getMobileNo());
			preparedStatement.setDouble(9,customer.getBalance());
			
			
			i=	preparedStatement.executeUpdate();
		 
			if (i==1) {
		
				try {
					preparedStatement = connection.prepareStatement("select account_no from customer_details where aadhaar_no = ?");
					preparedStatement.setLong(1,customer.getAadharNo());
					ResultSet	resultSet = preparedStatement.executeQuery();
					resultSet.next();
				//	long accNo = resultSet.getLong(1);
					customer.setAccountNo(resultSet.getLong(1));
				} catch (SQLException e) {
				}
				
			}	
				
				
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

		return customer;
	}
	public CustomerDetails login(long accNo, String password) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oraclework","oraclework");
                Statement statement=connection.createStatement();
			
			ResultSet resultSet= statement.executeQuery("select * from customer_details");
			while(resultSet.next()) {
			  long accNo1=    resultSet.getLong(1);
				String pass1=	resultSet.getString(6);
				if(accNo1==accNo&&pass1==password) {
					
				}
			
			}
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return null;
	}


}
