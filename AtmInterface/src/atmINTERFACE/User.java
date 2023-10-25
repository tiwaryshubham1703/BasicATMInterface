package atmINTERFACE;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    public User(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String userId, String pin2) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: +" + amount);
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true; // Withdrawal successful
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
            return false; // Withdrawal failed
        }
    }

    public void transfer(User recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            transactionHistory.add("Transfer to " + recipient.getUserId() + ": -" + amount);
            System.out.println("Transfer successful. New balance: " + balance);
        } else {
            System.out.println("Transfer failed.");
        }
    }

    public String getUserId() {
        return userId;
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for " + userId + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Additional methods for further functionality can be added here
}
