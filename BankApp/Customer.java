package com.chainsys.BankApp;

import java.time.LocalDate;

class Customer {
	
		   private  String customerName;  
		   private  String accountNumber;  
		    private  String account_type;  
		    private  long balance;
		    private int age;
		    private LocalDate date; 
		    
			public LocalDate getDate() {
				return date;
			}
			public void setDate(LocalDate date) {
				this.date = date;
			}
			public String getCustomerName() {
				return customerName;
			}
			public void setCustomerName(String customerName) {
				this.customerName = customerName;
			}
			public String getAccountNumber() {
				return accountNumber;
			}
			public void setAccountNumber(String accountNumber) {
				this.accountNumber = accountNumber;
			}
			public String getAccount_type() {
				return account_type;
			}
			public void setAccount_type(String account_type) {
				this.account_type = account_type;
			}
			public long getBalance() {
				return balance;
			}
			public void setBalance(long balance) {
				this.balance = balance;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			} 
		    
	}



