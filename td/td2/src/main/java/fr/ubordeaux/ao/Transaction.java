package fr.ubordeaux.ao;

import java.util.Date;

public class Transaction {
    private Date date;
    private String title;
    private final IntPos amount;

    public Transaction(String title, int amount) {
        //Affecter la date à aujourd'hui
        this.title = title;
        this.amount = new IntPos(amount);
        this.date = new Date(System.currentTimeMillis());
    }

    public String getDate() {
        //TODO_2
        return this.date.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public int getAmount() {
        return this.amount.value();
    }
}