package fr.ubordeaux.ao;

import java.util.Date;

class Main{

    public static void main(String[] args){
        Transaction t1 = new Transaction("transaction1", 1000);
        Transaction t2 = new Transaction("transaction2", 2000);
        Transaction t3 = new Transaction("transaction1", 3000);
    
        Account mAccount = new Account("Alex");

        mAccount.addTransaction(t1);
        mAccount.addTransaction(t2);
        mAccount.addTransaction(t3);

        System.out.print(mAccount.getTransactionSince(new Date(System.currentTimeMillis()).toString()));

    }
}