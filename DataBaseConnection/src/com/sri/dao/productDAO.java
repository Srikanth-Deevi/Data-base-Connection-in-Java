package com.sri.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.sri.dbconnect.*;
import com.sri.model.*;
public class productDAO {
	private DataBaseConnection db = new DataBaseConnection();
	private Connection con;
	public static int id=10001;
	public void addProduct(product pr) {
		try {
			con =db.getConnection();
			String query="insert into product values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2, pr.getProductName());
			ps.setString(3, pr.getProductCompany());
			ps.setString(4, pr.getProductColor());
			ps.setInt(5,pr.getProductCost());
			ps.execute();
			con.close();
			System.out.println("Product has been inserted successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void displayProducts() {
		try {
			con=db.getConnection();
			String query="select * from product";
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t");
				System.out.println(rs.getString(2)+"\t");
				System.out.println(rs.getString(3)+"\t");
				System.out.println(rs.getString(4)+"\t");
				System.out.println(rs.getString(5)+"\t");			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public product displayProducts(int id) {
		product pr=new product();
		try {
			con=db.getConnection();
			String query="select * from product where produtId=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				pr.setProductId(id);
				pr.setProductName(rs.getString("productname"));
				pr.setProductCompany(rs.getString("productcompany"));
				pr.setProductColor(rs.getString("productcolor"));
				pr.setProductCost(rs.getInt("productcost"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		return pr;
	}
	public void updateProduct(product pr) {
		// TODO Auto-generated method stub
		try {
			con=db.getConnection();
			String query="update product set productname=?, productcompany=?,productcolor=?,productcost=? where productId=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(5,pr.getProductId());
			ps.setString(1, pr.getProductName());
			ps.setString(2, pr.getProductCompany());
			ps.setString(3, pr.getProductColor());
			ps.setInt(4, pr.getProductCost());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}