package fr.ubordeaux.ao;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Account {
    private double balance;
    private int id = 0;
    private String name;
    private Set<Transaction> transactions;

    public Account(String name) {
        this.name = name;
        this.id = getid();
        this.balance = 0;
        transactions = new HashSet<Transaction>();
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        //TODO_3
        this.balance += transaction.getAmount();

        
    }
    
    public Set<Transaction> getTransactionSince(String date) {
        Set<Transaction> subset = new HashSet<>();
        boolean isFind = false;
        Iterator<Transaction> it = this.transactions.iterator(); 
        while(it.hasNext()){
            Transaction current = it.next();
            if(isFind){
               subset.add(current); 
            } else if(current.getDate() == date){
                isFind = true;
                subset.add(current);
            }
        }
        
        if(subset.isEmpty()){
            return null;
        }else{
            return subset;
        }
    }

    public void removeTransaction(String date, int amount, String title ){
        Iterator<Transaction> it = this.transactions.iterator();
        while (it.hasNext()) {
            Transaction current = it.next();
            if (current.getDate() == date 
                && current.getTitle() == title 
                && current.getAmount() == amount) {
                    transactions.remove(current);
            }
        }
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof Account) {
            Account otherAccount = (Account) other;
            return this.id != otherAccount.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Account "+this.name+" (id="+this.id+"), balance = "+this.balance;
    }

    private int getid(){
        this.id++;
        return this.id;
    }
}