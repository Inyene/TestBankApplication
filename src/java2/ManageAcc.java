/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2;

import java.util.ArrayList;

/**
 *
 * @author 1412183
 */
public class ManageAcc {
    
    private Customer cus;
    private BankAccount accnt;
    //public static ArrayList<String> detail = new ArrayList(new BankAccount(Customer owner, starting));

    
    public ManageAcc(){
        cus = null;
        accnt = null;
        
    }
    
    public ManageAcc(Customer c, BankAccount a){
        this.accnt = a;
        this.cus = c;
        
    }
    public ManageAcc(BankAccount a){
        this.accnt = a;
    }
    
}
