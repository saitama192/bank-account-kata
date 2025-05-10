package org.example.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Makes a deposit to the account.
     *
     * @param amount The amount to deposit (must be positive)
     * @throws IllegalArgumentException if amount is not positive
     */
    public void deposit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
        recordTransaction(amount, TransactionType.DEPOSIT);
    }

    /**
     * Makes a withdrawal from the account.
     *
     * @param amount The amount to withdraw (must be positive)
     * @throws IllegalArgumentException if amount is not positive
     * @throws IllegalStateException if there are insufficient funds
     */
    public void withdraw(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if(amount > this.balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        this.balance -= amount;
        recordTransaction(-amount, TransactionType.WITHDRAWAL);
    }

    /**
     * Returns the current balance of the account.
     *
     * @return The current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns a list of all transactions made on the account.
     *
     * @return An unmodifiable list of transactions
     */
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
    /**
     * Records a transaction in the account's history.
     *
     * @param amount The amount of the transaction
     */
    private void recordTransaction(double amount, TransactionType transactionType) {
        Transaction transaction = new Transaction(LocalDateTime.now(), amount, balance, transactionType);
        transactions.add(transaction);
    }
}
