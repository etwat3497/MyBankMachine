/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankmachinetester;

//Add imports
import java.text.DecimalFormat;

/**
 *
 * @author etwat3497
 */
public class BankMachine {
    //Declare global variables
    private String bankName;
    private double balance;
    DecimalFormat x = new DecimalFormat("##.##");
    
    
  /**
   * pre: none
   * post: none
   * Default constructor to assign base values to variables
   */
    public BankMachine(){
        bankName = "Unknown bank";
        balance = 0;
    }
    
  /**
   * pre: bank name and initial value
   * post: none
   * Constructor to look for 2 variable values in bank machine tester and assign values
   */
    public BankMachine(String bank, double initial){
        bankName = bank;
        balance = initial;
    }
    
    
  /**
   * pre: the amount being deposited
   * post: void
   * Method to calculate how much is deposited into the account
   */
    public void deposit(double depositAmount){
        if(depositAmount<0){
            //Catch bad user input
            System.out.println("\nInsufficient funds to deposit");
        }
        else{
            //Set the new balance
            balance += depositAmount;
            System.out.println("\nDeposit recorded successfully");
        }
    }
    
    
  /**
   * pre: the amount being withdrawn
   * post: void
   * Method to calculate how much is withdrawn from the account
   */
    public void withdrawl(double withdrawlAmount){
        if(withdrawlAmount<0){
            //Catch bad user input
            System.out.println("\nPlease choose a positive value to withdraw");
        }
        else if(withdrawlAmount>balance){
            //Catch if the user is withdrawing more than what is in the balance
            System.out.println("\nInsufficient funds to withdraw");
        }
        else{
            //Set the new balance
            balance -= withdrawlAmount;
            System.out.println("\nWithdrawl recorded successfully");
        }
    }
    
    
  /**
   * pre: void
   * post: void
   * Method to display the current balance
   */
    public void displayBalance(){
        System.out.println("The current balance is $"+x.format(balance)+".");
    }
    
    
  /**
   * pre: the amount of annual interest and number of days
   * post: void
   * Method to calculate how much interest accumulates on the balance over a set number of days
   */
    public void interest(double annualInterest, int days){
        if(days<0 || annualInterest<0){
            //Catch bad user input
            System.out.println("Please input a positive number of days and a positive interest rate");
        }
        else{
            //Get the daily interest rate
            double dailyInterestRate = annualInterest/365;
            //Calculate interest and set the new balance
            double newBalance = balance*(Math.pow(1+dailyInterestRate, days));
            double interest = newBalance - balance;
            System.out.println("You gained $"+x.format(interest)+" in interest.");
            balance += interest;
        }
        
        
    }
    
}
    
    

