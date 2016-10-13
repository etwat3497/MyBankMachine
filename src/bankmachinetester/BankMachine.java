/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankmachinetester;

import java.text.DecimalFormat;

/**
 *
 * @author etwat3497
 */
public class BankMachine {
    private String bankName;
    private double balance;
    DecimalFormat x = new DecimalFormat("##.##");
    
    
    public BankMachine(){
        bankName = "Unknown bank";
        balance = 0;
    }
    
    public BankMachine(String bank, double initial){
        bankName = bank;
        balance = initial;
    }
    
    public double deposit(double depositAmount){
        if(depositAmount<0){
            System.out.println("\nInsufficient funds to deposit");
        }
        else{
            balance += depositAmount;
            System.out.println("\nDeposit recorded successfully");
        }
        return balance;
    }
    
    public double withdrawl(double withdrawlAmount){
        if(withdrawlAmount<0){
            System.out.println("\nPlease choose a positive value to withdraw");
        }
        else if(withdrawlAmount>balance){
            System.out.println("\nInsufficient funds to withdraw");
        }
        else{
            balance -= withdrawlAmount;
            System.out.println("\nWithdrawl recorded successfully");
        }
        return balance;
    }
    
    public void displayBalance(){
        System.out.println("The current balance is $"+x.format(balance)+".");
    }
    
    public void interest(double annualInterest, int days){
        if(days<0 || annualInterest<0){
            System.out.println("Please input a positive number of days and a positive interest rate");
        }
        else{
            double dailyInterestRate = annualInterest/365;
            double newBalance = balance*(Math.pow(1+dailyInterestRate, days));
            double interest = newBalance - balance;
            System.out.println("You gained $"+x.format(interest)+" in interest.");
            balance += interest;
        }
        
        
    }
    
}
    
    

