/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankmachinetester;

import java.util.Scanner;

/**
 *
 * @author etwat3497
 */
public class BankMachineTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean done = false;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of your bank?");
        String bankName = sc.nextLine();
        System.out.println("What is your initial balance?");
        double initialBalance = Double.parseDouble(sc.nextLine());
        
        BankMachine user1 = new BankMachine(bankName, initialBalance);
        
        String userChoice = "";
        

        
       
        while(!done){
        System.out.println("Please input 'Deposit' to put money into your account, 'Withdrawl' to withdraw money from the account, "
        + "'Display' to display the current balance, or 'Interest' to calculate interest over a certain interval of time, and 'Done' to close the program");
        
        userChoice = sc.nextLine();
        
        if(userChoice.equalsIgnoreCase("Deposit")){
            System.out.println("Please input the deposit amount");
            double depositValue = Double.parseDouble(sc.nextLine());
            user1.deposit(depositValue);
            System.out.println("Deposit recorded successfully!");
        }
        
        else if(userChoice.equalsIgnoreCase("Withdrawl")){
            System.out.println("Please input the withdrawl amount");
            double withdrawlValue = Double.parseDouble(sc.nextLine());          
            user1.withdrawl(withdrawlValue);
            System.out.println("Withdrawl recorded successfully!");
        }
        
        else if(userChoice.equalsIgnoreCase("Display")){
            user1.displayBalance();
            System.out.println("Balance displayed successfully!");
        }
        
        else if(userChoice.equalsIgnoreCase("Interest")){
            //Adjust the values; was showing that the interest was infinity - likely an error in use of pow
            System.out.println("Please input the annual interest amount in decimal format; i.e. 5% would be represented as 0.05");
            double annualInterestValue = Double.parseDouble(sc.nextLine());   
            System.out.println("Please input the number of days to calculate interest on");
            int numOfDays = Integer.parseInt(sc.nextLine());
            user1.interest(annualInterestValue, numOfDays);
            System.out.println("Interest calculated successfully!");
        }
        
        else if(userChoice.equalsIgnoreCase("Done")){
            System.out.println("Thank you for banking with "+bankName);
            done = true;
        }
        
        }
    }
}
