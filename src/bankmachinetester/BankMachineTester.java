/*
 * Created by Ethan Watt
 * On October 13, 2016
 * Created to make a fully functioning ATM with classes
 */

package bankmachinetester;

//Add imports
import java.util.Scanner;

/**
 *
 * @author etwat3497
 */
public class BankMachineTester {

    /**
     * pre: String array
     * post: void
     * Main method to have the ATM communicate with the user and run methods and constructors from the ATM class
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is the name of your bank?");
        String bankName = "";
        Boolean bankNameLoop = false;

        //Run while loop to catch bad user input
        while(!bankNameLoop){
            System.out.println("What is the name of your bank?");
            bankName = sc.nextLine();
            
            //If the bank name is only numbers catch bad user input
            if(isNumeric(bankName)){
                System.out.println("\nPlease input a valid bank name");
            }
            //If the bank name is empty
            else if (bankName.equals("")) {
                System.out.println("\nPlease input a bank name");
            }
            //End the while loop
            else{
                bankNameLoop = true;
            }
        }

        double initialBalance = 0;
        Boolean run = false;
        
        //Run in while loop to catch bad user input when getting initial balance
        while(!run){
            try{
                System.out.println("What is your initial balance?");
                initialBalance = Double.parseDouble(sc.nextLine());

                if(initialBalance<0){
                    System.out.println("\nPlease input a positive value.");
                }
                else{
                    //End while loop
                    System.out.println("Initial balance recorded successfully.");
                    run = true;
                }
            }
            catch(NumberFormatException e){
                System.out.println("\nPlease input a number value");
            }
        }
        
        //Run the constructor in the bank machine class
        BankMachine user1 = new BankMachine(bankName, initialBalance);
        
        String userChoice = "";
        boolean done = false;
        //Run in a while loop to catch bad user input and continually run this until done is typed
        while(!done){
            System.out.println("Please input 'Deposit' to put money into your account, 'Withdrawl' to withdraw money from the account, "
            + "'Display' to display the current balance, or 'Interest' to calculate interest over a certain interval of time, and 'Done' to close the program");

            userChoice = sc.nextLine();

            if(userChoice.equalsIgnoreCase("Deposit")){
                System.out.println("Please input the deposit amount");
                
                try{
                    //If good user input run deposit method in bank machine class
                    double depositValue = Double.parseDouble(sc.nextLine());
                    user1.deposit(depositValue);
                }
                catch(NumberFormatException e){
                    System.out.println("Please enter a numeric value");
                }
                
            }

            else if(userChoice.equalsIgnoreCase("Withdrawl")){
                System.out.println("Please input the withdrawl amount");

                try{
                    //If good user input run withdraw method in bank machine class
                    double withdrawlValue = Double.parseDouble(sc.nextLine()); 
                    user1.withdrawl(withdrawlValue);
                }
                catch(NumberFormatException e){
                    System.out.println("Please enter a numeric value");
                }
                
                
            }

            else if(userChoice.equalsIgnoreCase("Display")){
                user1.displayBalance();
                System.out.println("Balance displayed successfully!");
            }

            else if(userChoice.equalsIgnoreCase("Interest")){
                System.out.println("Please input the annual interest amount in decimal format; i.e. 5% would be represented as 0.05");
                
                try{
                    //If good user input run interest method in bank machine class
                    double annualInterestValue = Double.parseDouble(sc.nextLine());   
                    System.out.println("Please input the number of days to calculate interest on");
                    int numOfDays = Integer.parseInt(sc.nextLine());
                    user1.interest(annualInterestValue, numOfDays);
                }
                catch(NumberFormatException e){
                    System.out.println("\nPlease input numeric values");
                }
            }

            else if(userChoice.equalsIgnoreCase("Done")){
                //End program
                System.out.println("Thank you for banking with "+bankName);
                done = true;
            }
            else{
                System.out.println("\nUnknown command. Please type in one of the identified keywords.");
            }
        }
    }
}
