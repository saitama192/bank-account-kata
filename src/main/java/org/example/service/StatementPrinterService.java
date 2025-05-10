package org.example.service;

import org.example.domain.Transaction;
import org.example.domain.TransactionType;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class StatementPrinterService {
    private static final String HEADER = "DATE | OPERATION | AMOUNT | BALANCE";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Prints the account statement showing all transactions.
     *
     * @param transactions The list of transactions to print
     */
    public void print(List<Transaction> transactions) {
        System.out.println(HEADER);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            System.out.println(formatTransaction(transaction));
        }
    }

    /**
     * Formats a transaction for display.
     *
     * @param transaction The transaction to format
     * @return A formatted string representing the transaction
     */

    private String formatTransaction(Transaction transaction) {
        String formattedDate = transaction.getDate().format(DATE_FORMATTER);
        TransactionType operation = transaction.getType();
        String amount = String.format("%.2f", Math.abs(transaction.getAmount()));
        String balance = String.format("%.2f", transaction.getBalanceAfterTransaction());

        return String.format("%s | %s | %s | %s", formattedDate, operation, amount, balance);
    }
}
