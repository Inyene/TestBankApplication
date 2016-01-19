/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 1412183
 */
public class Transactions {
    public static void main (String [] args){
        
        /**
         * Declaration of an array list of Customer object
         */
        ArrayList<Customer> c = new ArrayList();
        /**
         * Creating Customer object's
         */
        c.add(0, new Customer("Graham", "Peter", "Aberdeen", "1234"));
        c.add(1, new Customer("Graham", "Sarah", "Dundee", "1235"));
        c.add(2, new Customer("Mary", "Jones", "New Castle","1236"));
        c.add(3, new Customer("Richard", "Gale", "New Castle","1237"));
        
        /**
         * Declaration and initialisation of BankAccount object's
         * 
         * For every new BankAccount object created for a 
         * Customer object, an accompanying unique account
         * number is generated for the new BankAccount object.
         * Subsequently, the account number(s) is binded to the
         * Customer object.
         */
        BankAccount a1,a2, a3, a4, a5, a6, a7, a8;//, a9, a10;
        a1 = new BankAccount(c.get(0), 500);
        a2 = new BankAccount(c.get(1), 1000);
        a3 = new BankAccount(c.get(0), 1500);
        a4 = new BankAccount(c.get(0), 1200);
        a5 = new BankAccount(c.get(2), 2500000);
        a6 = new BankAccount(c.get(2), 3460);
        a7 = new BankAccount(c.get(3), 10000);
        a8 = new BankAccount(c.get(3), 200);
        
        
        
        /**
         * Declaration of an array list of BankAccount object
         * and populating of array list
         */
        ArrayList<BankAccount> a = new ArrayList();
        a.add(0, a1);
        a.add(1, a2);
        a.add(2, a3);
        a.add(3, a4);
        a.add(4, a5);
        a.add(5, a6);
        a.add(6, a7);
        a.add(7, a8);
    
        for (Customer c1 : c) { // prints customer id and all account numbers
            // prints customer id and all account numbers in the console
            System.out.println("id:" + c1.get_id() + " " + c1.getAccountNumbers() + "\n");
        }
        /**
         * Declaration of BankAccount and Customer object
         */
        Customer currentcustomer = null;    // a Customer object initialised to null
        BankAccount selectedbankaccount = null, selectedbankaccount1 = null;   // a BankAccount object initialized to null
        /**
         * boolean sentinel variable 
         */
        boolean done = true; 
        boolean thru = true;
        boolean ext = true;
        /**
         * Declaration and Initialisation of a string variable
         * representing chosen account number
         */
        String selected_account=""; //declaration and initialisation of an empty string to hold customer account number
      do{ //outer do-while loop
          
          do{   //start of first inner do-while loop
            String cus_id = JOptionPane.showInputDialog("Your id: ");               // displays input dialog requesting for customer id
        
            if (Customer.cusId.contains(cus_id)){                                   // checks if entered cus_id exist
                int i = Customer.cusId.indexOf(cus_id);                             // assigns the index value of cus_id to variable i
                currentcustomer = c.get(i);                                         // assigns the chosen Customer object to currentuser
            
                if(currentcustomer.getAccountNumbers().size()>=1){                  // checks if customer has an account
                    String accounts="";                                             // declaration of an empty string
                    int size=0;
                    for(int j=0;j<currentcustomer.getAccountNumbers().size();j++){  
                        accounts+=(j+1)+". "+currentcustomer.getAccountNumbers().get(j)+"\n"; // assigns and formats customer available account numbers to the String accounts
                        size++;
                    }
                    boolean test=true;
                    do{//starts
                        int k = Integer.parseInt(JOptionPane.showInputDialog(null, "Select Account "+"\n"+accounts));   //displays customer account number list and accepts integer input representing selected account number
                        if(k<=size){    //ensures value is within range of arraylist
                            selected_account = currentcustomer.getAccountNumbers().get(k-1); //assigns chosen customer account number to the String selected_account
                            int i_a = BankAccount.accounts.indexOf(selected_account); // assigns the index value of selected_account to variable i_a
                            selectedbankaccount = a.get(i_a); // assigns the chosen BankAccount object to selectedbankaccount
                
                            JOptionPane.showMessageDialog(null, "Welcome " + currentcustomer.get_other_name() + "\n"
                            + "\n" + selectedbankaccount.toString()); //display a welcome message
        
                            done = false; // set done to false
                            test = false; // sets test to false
                        }   
                        else{
                            JOptionPane.showMessageDialog(null,"choice out of range");  //display an out of range message
                        }
                    }while(test);//ends
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry! No existing Bank Account"); // displays a notice   
            }
        
            }
            else{
                   JOptionPane.showMessageDialog(null, "Wrong entry!" , cus_id ,JOptionPane.ERROR_MESSAGE); // displays an error notice 
            } 
       
            }while(done);//end of first inner do-while loop
      
        do{ //  start of second inner do-while loop
            String message2 = JOptionPane.showInputDialog(currentcustomer.get_other_name() + ",\nChoose an option: \n"
                    + "1. Check Balance \n2. Deposit \n3. Withdraw \n4. Transfer"
                    + "\n0. Exit"); //displays user options and accepts user selections 
            int msg = Integer.parseInt(message2); //assigns integer value to msg
            
            switch(msg){ // allows user to perform operations
              
                case 1: //check balance option
                    JOptionPane.showMessageDialog(null,"**"+selectedbankaccount.get_AccNum()+"**\n\n"+selectedbankaccount.get_balance()); // display customer bank account balance
                    break;
                    
                case 2: //deposit option
                    String amnt = JOptionPane.showInputDialog("**"+selectedbankaccount.get_AccNum()+"**\n\n"+"How much do you want to deposit?"); // accepts an amount to deposit
                    int amt = Integer.parseInt(amnt); // assignment: converts string value to an integer value and assigns to amt
                    if (amt > 0){ // validation: checks if deposit ammount(amt) is greater than zero
                        selectedbankaccount.deposit(amt);   // invokes the deposit method of the BankAccount class
                        JOptionPane.showMessageDialog(null, "**"+selectedbankaccount.get_AccNum()+"**\n\n"+"Your balance: " + selectedbankaccount.get_balance() ); // displays the customer bank account balance immediately after invoking the deposit method
                    }
                    else JOptionPane.showMessageDialog(null, "Incorrect amount!!", amnt, JOptionPane.ERROR_MESSAGE); // displays a notice   
                    break;
                
                case 3: // withdraw option
                    String amnt1 = JOptionPane.showInputDialog("**"+selectedbankaccount.get_AccNum()+"**\n\n"+"How much do you want to withdraw?"); // display: accepts an amount to withdraw
                    int amt1 = Integer.parseInt(amnt1); // assigment: converts the entered string value to an integer value and assigns to amt1
                    if (amt1 <= selectedbankaccount.get_balance()){ // validation: checks if withdrawal amount is less than or equal to zero
                        selectedbankaccount.withdraw(amt1); // invokes the withdraw method from the BankAccount class
                        JOptionPane.showMessageDialog(null, "**"+selectedbankaccount.get_AccNum()+"**\n\n"+"Your balance: " + selectedbankaccount.get_balance() ); // displays the customer bank account balance immediately after invoking the withdraw method
                    }
                    else JOptionPane.showMessageDialog(null, "**"+selectedbankaccount.get_AccNum()+"**\n\n"+"Insufficient balance to carry out transaction!!", amnt1, JOptionPane.ERROR_MESSAGE); // displays an error notice
                    break;
                  
                case 4: //transfer option 
                    int amt3 = Integer.parseInt(JOptionPane.showInputDialog("**"+selectedbankaccount.get_AccNum()+"**\n\n"+"How much do you want to transfer?")); // display: accepts an amount to transfer
                    String accn = JOptionPane.showInputDialog("To which account?"); // display: requests account number to transfer to
                    
                    if (BankAccount.accounts.contains(accn)){ // validation: checks if bank account number exist
                        int id = BankAccount.accounts.indexOf(accn); //assignment: gets the the index value of the entered account number to transfer to
                        selectedbankaccount1 = a.get(id); //assignment: gets the chosen account number and assigns to selectedbankaccount1
                        
                        if (!accn.equalsIgnoreCase(selected_account)){  //validation: checks to makes sure transfer is not to itself
                         //
                            selectedbankaccount.transfer(selectedbankaccount1, amt3); //invokes the transfer method from the BankAccount class
                            JOptionPane.showMessageDialog(null, "**"+selectedbankaccount.get_AccNum()+"**\n\n"+"Transfering to "+"**"+selectedbankaccount1.get_AccNum()+"**"+"\n\nClick ok to complete");
                            JOptionPane.showMessageDialog(null, "**"+selectedbankaccount.get_AccNum()+"**\n\n"+"Your balance: " + selectedbankaccount.get_balance() ); //displays the bank account balance immediately after invoking the transfer method
                        } 
                        else {
                            JOptionPane.showMessageDialog(null, "Specify an account", accn, JOptionPane.ERROR_MESSAGE); // displays an error notice
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Specify an account", accn, JOptionPane.ERROR_MESSAGE); // displays an error notice
                        }       
                    break;
                
                case 0: //exit option
                    
                    int ch = JOptionPane.showConfirmDialog(null,"Do you want to perform another transaction!!!","Do you want to perform another transaction!!!",JOptionPane.YES_NO_OPTION); //  displays a yes or no notice: to perform another transaction or not 
                    if(ch==1){ext=false; 
                        JOptionPane.showMessageDialog(null,"**"+selectedbankaccount.get_AccNum()+"**\n\n"+ "Thank you " + currentcustomer.get_other_name());   // displays a good bye message
                    }
                    thru = false; // sets thru to false
            }                 
        }while(thru);  //end of second inner do-while loop
         
        }while(ext);    //end of outer do-while loop
      System.exit(0);
    }
}



