package org.example.domain;

import java.time.LocalDateTime;

public class Transaction {
    private final LocalDateTime date;
    private final double amount;
    private final double balanceAfterTransaction;

    private final TransactionType transactionType;

    public Transaction(LocalDateTime date, double amount, double balanceAfterTransaction, TransactionType transactionType) {
        this.date = date;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.transactionType = transactionType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    /**
     * Returns the type of transaction (DEPOSIT or WITHDRAWAL).
     *
     * @return The type of transaction
     */
    public TransactionType getType() {
        return transactionType;
    }
}
