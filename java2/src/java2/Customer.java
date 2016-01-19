package java2;

import java.util.ArrayList;

/**
* This class models a customer in a bank.
*/
public class Customer
{
    
/**
 * Customer object instance variable
 */
private String surname;     //attribute modelling the surname of the customer
private String other_name;  //attribute modelling the first and middle name of the customer
private String address;     //attribute modelling the address of a customer
private String id;  //user id
private ArrayList<String> account_numbers = new  ArrayList<>(); //arraylist of all current customers account numbers
/**
 * 
 */
public static ArrayList<String> cusId = new  ArrayList<>(); //arraylist of all created customer object id's

/**
 * The constructor method that creates a new customers object
 * 
 * @param surname a string type variable representing the customers surname 
 * @param other_name a string type variable representing the customers other name
 * @param address a string type variable representing the customers address
 * @param id a string type representing the customers user id
 */
public Customer(String surname,String other_name,String address, String id)
{
this.surname=surname;           //assign values of input parameters to corresponding attributes
this.other_name=other_name; //assign values of input parameters to corresponding attributes
this.address=address;   //assign values of input parameters to corresponding attributes
this.id = id; //assign values of input parameters to corresponding attributes
cusId.add(this.id); //stores the id of  each customers object created in a class level variable of type arraylist

} //end method

/**
 * a setter method that stores customer account number
 * 
 * @param s a string type representing The account number passed in  
 */
public void set_account_numbers(String s){
    
    account_numbers.add(s);
}

/**
 * a getter method that returns the array list of customers account numbers
 * 
 * @return the account numbers of customers object
 */
public ArrayList<String> getAccountNumbers(){
    return account_numbers;
}

/**
 * a setter method that sets the surname variable
 * 
 * @param new_surname a string type representing customer surname
 */
public void set_surname(String new_surname){
    this.surname = new_surname;     //assign the value of new_surname to surname
}

/**
 * a getter method that returns the surname of the customer
 * 
 * @return the customers surname
 */

public String get_surname(){
    return surname;                 //returns the surname of the customer
}

/**Creates a new other_name
 * 
 * @param new_otherName the new value of other_name
 */
public void set_other_name(String new_otherName){
    this.other_name = new_otherName;        //assigns the input parameter to corresponding attribute
}

/**
 * a getter method that returns a string with the customers other_name
 * 
 * @return the customers other_name
 */
public String get_other_name(){
    return other_name;              //returns a String with the customer's other_name
}

/**
 * a setter method that takes one string input parameter new_address
 * 
 * @param new_address the new value of address
 */
public void set_address(String new_address){
    this.address = new_address;         //assigns values of input param to corresponding attribute
}

/**
 * a getter method that returns the customers address
 * 
 * @return the customer address
 */
public String get_address(){
    return address;
}

/**
 * a getter method that returns the customer id
 * 
 * @return a String representing the customers id
 */
public String get_id(){
    return id;
}


/**
* Return the details of the customer object as a String.
* A convenient method for printing out all details.
*
* @return The customer object details as a string.
*/
@Override
public String toString()
{
return( this.other_name+" "+        //compose and return a String with the customer's other-name
        this.surname+","+           //followed by a space and the surname
        this.address+" "+
        this.id);              //followed by a commas and the address
} //end method toString
} //end class Customer
