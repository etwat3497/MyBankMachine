/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankmachinetester;

/**
 *
 * @author etwat3497
 */
public class BankMachine {
    private String bankName;
    private int initialBalance;
    
    
    public BankMachine(){
        bankName = "Unknown bank";
        initialBalance = 0;
    }
    
    public BankMachine(String bank, int initial){
        bankName = bank;
        initialBalance = initial;
    }
    
}
    
    

