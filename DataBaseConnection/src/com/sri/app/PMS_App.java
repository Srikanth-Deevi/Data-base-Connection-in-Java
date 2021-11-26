package com.sri.app;

import com.sri.dbconnect.DataBaseConnection;
import com.sri.services.*;
public class PMS_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBaseConnection dbc=new DataBaseConnection();
//		dbc.getConnection();
//		dbc.createTable();
		productServices service=new productServices();
		service.menu();
		
		
	}

}
