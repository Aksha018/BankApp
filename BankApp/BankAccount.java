package com.chainsys.BankApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


interface BankDetail{
	void validateUser();
	 void savingsAccount(Customer customer);
	 Customer salaryToPensionAccount(Customer customer);
}

public class BankAccount implements BankDetail{
	
	public List<Customer> customerList() {
		List<Customer> customerlist = new ArrayList<>();
		Customer customer1 = new Customer();
		customer1.setAccountNumber("HDFC1234567");
		customer1.setCustomerName("Prem");
		customer1.setAccount_type("Saving");
		customer1.setBalance(200000);
	    customer1.setAge(50);
	    DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate joinDate1=LocalDate.parse("04/06/2020", format);
	    customer1.setDate(joinDate1);
		customerlist.add(customer1);
		
		Customer customer2 = new Customer();
		customer2.setAccountNumber("HDFC8965467");
		customer2.setCustomerName("Ram");
		customer2.setAccount_type("Salary");
		customer2.setBalance(700000);
		customer2.setAge(76);
		LocalDate joinDate2=LocalDate.parse("20/07/2021", format);
	    customer2.setDate(joinDate2);
		customerlist.add(customer2);
		
		Customer customer3 = new Customer();
		customer3.setAccountNumber("HDFC4565469");
		customer3.setCustomerName("sitha");
		customer3.setAccount_type("deposit");
		customer3.setBalance(900000);
		customer3.setAge(66);
		LocalDate joinDate3=LocalDate.parse("02/05/2017", format);
	    customer3.setDate(joinDate3);
		customerlist.add(customer3);
		
		return customerlist;
	}
	
//Validation
	public void validateUser() {
		Customer customer =new Customer();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Account Number");
		String account =sc.next();
		customer.setAccountNumber(account);
		System.out.println("Enter Customer Name");
		String name=sc.next();
		customer.setCustomerName(name);
		customer=getCustomerDetail(customer);
		
		if(customer==null) {
			System.out.println("Please Enter Valid Data !!!");
		}else {
			if(customer.getAccount_type().equals("deposit")) {
				recurringDeposite(customer);
			}else
			   savingsAccount(customer);
		}
		
	}
  public Customer getCustomerDetail(Customer customer) {
		List<Customer>customerList=customerList();
		for(int i=0;i<customerList.size();i++) {
			try {
			if(customerList.get(i).getAccountNumber().equals(customer.getAccountNumber()) && customerList.get(i).getCustomerName().equals(customer.getCustomerName())) {
				 
				Thread.sleep(11000);
				return customerList.get(i);
			}
			}catch (Exception e) {
	            System.out.println(e);
	        }
			
		}
		return null;
	}
	

	
//Saving Account
   public void savingsAccount(Customer customer) {
	 LocalDate date=LocalDate.now();
	 customer=salaryToPensionAccount(customer);
	   System.out.println(date);
      System.out.println("Name of account holder: "+customer.getCustomerName());  
      System.out.println("Account no.: "+customer.getAccountNumber());  
      System.out.println("Account type: " + customer.getAccount_type());  
      System.out.println("Balance:"+ customer.getBalance());  
	  System.out.println("Age : "+customer.getAge());
	 
 }
 
//Salary To Pension Account Conversion
   public Customer salaryToPensionAccount(Customer customer) {
	  if(customer.getAge()>60 && customer.getAccount_type().equalsIgnoreCase("Salary")) {
		 customer.setAccount_type("Pension");
		 return customer;
	 }else return customer;
 }
 
//Recurring Deposit
   public void recurringDeposite(Customer customer) {
	  LocalDate date=LocalDate.now();
	 int monthDifference=0;
	 if(customer.getDate().getMonthValue()>date.getMonthValue()) {
	     monthDifference=customer.getDate().getMonthValue()-date.getMonthValue();
	 }else {
		 monthDifference=date.getMonthValue()-customer.getDate().getMonthValue();
	 }
	 int yearDifference=date.getYear()-customer.getDate().getYear();
	 
	 monthDifference+=yearDifference*12;
	 
	 float interestAmount=customer.getBalance()*monthDifference*5/100;
	 
	 System.out.println(date);
	 System.out.println("Name of account holder: "+customer.getCustomerName());  
     System.out.println("Account no.: "+customer.getAccountNumber());  
     System.out.println("Account type: " + customer.getAccount_type());  
     System.out.println("Balance:"+ customer.getBalance());  
	 System.out.println("Age : "+customer.getAge());
	 System.out.println("Interest Amount:"+ interestAmount);
	 System.out.println("Total Amount: "+(interestAmount+customer.getBalance()));
	 
	   }
	   
 
}

