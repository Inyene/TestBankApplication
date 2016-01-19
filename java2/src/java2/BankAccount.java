package java2;

import java.util.ArrayList;

/**
* This class models a bank account.
*/
public class BankAccount
{
//
// declare attributes here
//
private double balance;             //balance of customer
private Customer owner;              //bank account owner
public static int accnt_number_start = 40000; 
public final String account_Number; //customer's bank account number
private final double INTEREST_RATE = 0.02;    //interest rate 

public static ArrayList<String> accounts = new ArrayList(); //arraylist of all bank account numbers
public static ArrayList<String> cus_acc = new ArrayList();

//
// declare methods here
//
/**
 * Constructor method to create a bank account object
 * 
 * @param owner Customer object
 * @param starting start up balance
 */
public BankAccount(Customer owner, double starting){
    this.owner = owner;   //bank account owner          
    this.balance = starting; // starting balance
    ++accnt_number_start; // generates unique account number
    account_Number = String.valueOf(accnt_number_start); //assigns customer an account number
    accounts.add(account_Number); // store's each account number in a class level arraylist
    
    this.owner.set_account_numbers(account_Number); //binds the current account number to a customer
    }

/**
 * a getter method that returns a double value
 * 
 * @return balance of account owner
 */
public double get_balance (){
    return balance;
}

/**
 * a getter method that performs a withdrawal function
 * and has a return type of boolean
 * 
 * @param amount The withdrawal amount
 * @return returns a boolean value
 */
public boolean withdraw(double amount){
    if (amount <= balance){
        this.balance -= amount;
        return true;
    }
        
    else
        return false;
} //end method withdraw

/**
* a setter method that deposit money into an account.
*
* @param amount	The amount to deposit into the account.
*/
public void deposit(double amount)
{
balance+=amount;	//increment the account balance by the deposit amount
if (amount >= 500){
    double int_rate = INTEREST_RATE*amount;
    balance += int_rate;
    }
} //end method deposit

/**
 * a setter and getter method that performs a transfer operation
 * to a second account
 * 
 * @param to The BankAccount object reference to transfer to
 * @param amount The amount to be transfered
 * @return The return type is boolean
 */
public boolean transfer(BankAccount to, double amount){
    if (amount <= this.balance){
        this.withdraw(amount);
        to.deposit(amount);
        return true;
    }
    else 
        return false;
}

/**
 * a getter method that returns the customer object reference 
 * 
 * @return The return is an object
 */
public Customer get_owner(){
    return this.owner;
}

/**
 * a getter method that returns the bank account number
 * 
 * @return 
 */
public String get_AccNum(){
    
    return account_Number;
}
/**
* Return all details of a bank account as a String.
*
* @return The details of a bank account.
*/
@Override
public String toString()
{
return("Owner: "+this.owner.toString()+
		"\nBalance: "+this.balance + ""
        + "\nAccount Number: " + this.get_AccNum());
} //end method toString
} //end class BankAccount
