package com.chainsys.BankApp;

interface MyAccount
{
    double getBalance();

    void deposit(double amount);

    void withdraw(double amount);
}


class HDFCAccount implements MyAccount
{
    double deposits;
    double withdrawals;


    public double getBalance()
    {
        return deposits - withdrawals;
    }

    public void deposit(double amount)
    {
        deposits += amount;
    }

    public void withdraw(double amount)
    {
        withdrawals += amount;
    }
}

class KvbAccount implements MyAccount
{
    double balance;

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }
}
    
public class BankDetails {
	
    public static void main(String args[])
    {  	
        MyAccount account = new HDFCAccount();
    
        System.out.println("Transacting using HDFC Account");
        transactOnAccount(account);
        System.out.println();
    
        account = new KvbAccount();
    
        System.out.println("Transacting using State Bank Account");
        transactOnAccount(account);
    }
    


    public static void transactOnAccount(MyAccount account)
    {
        System.out.println("------------------------------");
        account.deposit(10000.0);
        printBalance("depositing 60,000.0", account);
        account.withdraw(2500.0);
        printBalance("withdrawing 6,400.0", account);
        account.withdraw(4100.0);
        printBalance("withdrawing 9,800.0", account);
        account.deposit(5000.0);
        printBalance("depositing 1,000.0", account);
        System.out.println("------------------------------");
    }
    
    public static void printBalance(String message, MyAccount account)
    {
        System.out.println("The balance after " + message + " is " + account.getBalance() +".");
    }
    
}