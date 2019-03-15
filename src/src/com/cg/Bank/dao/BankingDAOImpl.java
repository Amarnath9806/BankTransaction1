package com.cg.Bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cg.Bank.dto.CustomerDetails;

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
	
			
	
	public CustomerDetails login1(long accNo, String password) {
		// TODO Auto-generated method stub
		
		CustomerDetails cd = null;
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection connection=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oraclework","oraclework");
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from customer_details");
			while(rs.next())
			{
				if(rs.getInt(1) == accNo && rs.getString(5).equals(password))
				{
					cd = new CustomerDetails();
					cd.setAccountNo(accNo);
					cd.setFirstName(rs.getString(2));
					cd.setLastName(rs.getString(3));
					cd.setEmailId(rs.getString(4));
					cd.setPancardNo(rs.getString(6));
					cd.setAadharNo(rs.getLong(7));
					cd.setAddress(rs.getString(8));
					cd.setMobileNo(rs.getLong(9));
					cd.setBalance(rs.getInt(10));
				}
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cd;
	}




	

}