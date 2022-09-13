package com.chainsys.BankApp;

import java.time.LocalDate;
import java.util.Scanner;  

interface Bank {
	void myAccount();
	void showAccount();
	void deposit();
	void withdrawal();
	
}

public class Account implements Bank{
	
	    private  String customerName;  
	    private  String accountNumber;  
	    private  String acc_type;  
	    private  long balance; 
	    
	     Scanner sc = new Scanner(System.in);  
	 
	    public  void myAccount() {  
			System.out.println("Customer Name is : Akshaya");
			System.out.println("AccountNumber is : HDFC1234567");
			System.out.print("Enter Account type: ");  
		        acc_type = sc.next();
		       balance = 50000;
	    }  
	   
	   public  void showAccount() { 
		   LocalDate date=LocalDate.now();
		   System.out.println(date);
	        System.out.println("Name of account holder: Akshaya");  
	        System.out.println("Account no.: HDFC1234567");  
	        System.out.println("Account type: " + acc_type);  
	        System.out.println("Balance:"+ balance);  
	    }  


	    public  void deposit() {  
	        long amt;  
	        System.out.println("Enter the amount you want to deposit: ");  
	        amt = sc.nextLong();  
	        balance = balance + amt;  
	    }  

 
	    public  void withdrawal() {  
	        long amt;  
	        System.out.println("Enter the amount you want to withdraw: ");  
	        amt = sc.nextLong();  
	        if (balance >= amt) {  
	            balance = balance - amt;  
	            System.out.println("Balance after withdrawal: " + balance);  
	        } else {  
	            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
	        }  
	    }  

  
	    public boolean search(String acc_no) {  
	        if (accountNumber.equals(acc_no)) {  
	            showAccount();  
	            return (true);  
	        }  
	        return (false);  
	    }  
}

class Transaction {
public static void main(String[] args) {
	Bank bank = new Account();
	bank.myAccount();
	bank.showAccount();
	bank.deposit();
	bank.withdrawal();
	}
}



