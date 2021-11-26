package com.sri.services;

import java.util.Scanner;

import com.sri.dao.productDAO;
import com.sri.model.product;

public class productServices {
	private productDAO dao=new productDAO();
	private Scanner sc=new Scanner(System.in);
	private void addProduct() {
		System.out.println("Enter Product Name");
		String productname=sc.next();
		System.out.println("Enter Product company");
		String productcompany=sc.next();
		System.out.println("Enter Product color");
		String productcolor =sc.next();
		System.out.println("Enter product cost");
		int productcost=sc.nextInt();
		
		product pr=new product();
		pr.setProductId(dao.id);
		pr.setProductName(productname);
		pr.setProductCompany(productcompany);
		pr.setProductColor(productcolor);
		pr.setProductCost(productcost);
		
		dao.addProduct(pr);
		dao.id++;
	}
	public void menu() {
		while(true) {
			System.out.println("1. Add Product");
			System.out.println("2. Display Products");
			System.out.println("3. Update Product Details");
			System.out.println("9. Exit");
			System.out.println("Enter your choice");
			int option=sc.nextInt();
			switch(option) {
			case 1 : addProduct();break;
			case 2 : displayProducts();break;
			case 3 : updateProductDetails();break;
			case 9 : System.exit(0);
			default: System.out.println("Wrong choice");
			}
		}
	}
	private void displayProducts() {
		// TODO Auto-generated method stub
		dao.displayProducts();
	}
	private void updateProductDetails() {
		// TODO Auto-generated method stub
		System.out.println("Enter product id");
		int id=sc.nextInt();
		product pr=null;
		try {
			pr=dao.displayProducts(id);
		}catch(Exception e) {
			System.out.println("Sorry No Product found with id"+id);
		}
		System.out.println("Product Name: "+pr.getProductName());
		System.out.println("Product Company: "+pr.getProductCompany());
		System.out.println("Product Color: "+pr.getProductColor());
		System.out.println("Product Cost: "+pr.getProductCost());
		System.out.println("Enter your choice to update: ");
		String choice= sc.next();
		switch(choice) {
		case "productname" : System.out.println("Enter product name");
							 String productname=sc.next();
							 pr.setProductName(productname);break;
		case "productcompany" : System.out.println("Enter product company");
		 						String productcompany=sc.next();
		 						pr.setProductName(productcompany);break;
		case "productcolor" : System.out.println("Enter product color");
		 					  String productcolor=sc.next();
		 					  pr.setProductName(productcolor);break;
		case "productcost" : System.out.println("Enter product cost");
		 					 int productcost=sc.nextInt();
		 					 pr.setProductCost(productcost);break;
		}
		dao.updateProduct(pr);
		System.out.println("Product Updated Successfully");
	}
	
}
