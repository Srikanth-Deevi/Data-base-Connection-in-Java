package com.sri.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseConnection {
	Connection con;
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Found");
			
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			String username="demo";
			String password="demo";
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Connected Successfully");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;		
	}
	public void createTable() {
		try {
			   String qyery="create table product(productId int primary key,productName varchar(30) not null,productCompany varchar(30) not null,productColor varchar(30) not null,productCost number(8,2) not null)";
			   PreparedStatement ps = con.prepareStatement(qyery);
			   ps.execute();
			   System.out.println("Table created successfully");
		}catch(Exception e) {
			System.out.println("Driver Not Found");
			System.out.println("Error Connection");  
			e.printStackTrace();
		}
	}
}
  