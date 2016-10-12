/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankmachinetester;

import static java.lang.Math.pow;

/**
 *
 * @author etwat3497
 */
public class BankMachine {
    private String bankName;
    private double balance;
    
    
    public BankMachine(){
        bankName = "Unknown bank";
        balance = 0;
    }
    
    public BankMachine(String bank, double initial){
        bankName = bank;
        balance = initial;
    }
    
    public double deposit(double depositAmount){
        balance += depositAmount;
        return balance;
    }
    
    public double withdrawl(double withdrawlAmount){
        balance -= withdrawlAmount;
        return balance;
    }
    
    public void displayBalance(){
        System.out.println("The current balance is $"+balance+".");
    }
    
    public void interest(double annualInterest, int days){
        double dailyInterestRate = annualInterest/365;
        double interest = pow(balance*(1+dailyInterestRate), days);
        System.out.println("In "+days+" days, you recieved $"+interest+" in interest");
        balance += interest;
    }
    
}
    
    

