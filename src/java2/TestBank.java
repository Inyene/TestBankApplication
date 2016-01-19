package java2;

/**
* A testing program that creates some customer and bank account objects.
*/
public class TestBank
{
/**
* The main method for execution.
     * @param args
*/
public static void main(String[] args)
{
//
// local variables of bank account and customer objects
//
BankAccount a1,a2;
Customer c1,c2;

//
// create some customer objects
//
c1=new Customer("Peter","Parker","123 Spidey Lane, New York", "1253");
c2=new Customer("Watson","Mary Jane","456 Broadway Avenue","1345");

//
// create some bank account objects
//
a1=new BankAccount(c1,100.0);		//create a new bank account for Peter Parker
a2=new BankAccount(c2,50.0);

//
// print the original status of the account
//
System.out.println("Initial account details:");
System.out.println(a1.toString());
System.out.println(a2.toString());

//
// do some transactions
//
a1.deposit(50.0);	//deposit 50 GBP into Peter Parker's account
a1.withdraw(20.0);	//withdraw 20 GBP from Peter Park's account
a2.deposit(100.0);      //deposit 100 GBP into Mary's account

//
//print out Mary's balance after the deposit
//
System.out.println("\nAfter the deposit: \n" + a2.toString());

a2.transfer(a1, 50);     //transfer 50 GBP from Mary's account to Peter's account

//
// print the account status after the transactions
//

System.out.println("\nAfter some transactions:");
System.out.println(a2.toString());
System.out.println(a1.toString());

} //end method main
} //end class TestBank
