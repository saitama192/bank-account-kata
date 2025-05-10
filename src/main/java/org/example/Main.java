package org.example;

import org.example.domain.Account;
import org.example.service.StatementPrinterService;
import org.example.util.AccountUtil;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        System.out.println("Bank Account Kata Demonstration");
        System.out.println("-------------------------------");

        // Initialize components
        Account account = new Account();
        StatementPrinterService statementPrinterService = new StatementPrinterService();
        AccountUtil accountUtil = new AccountUtil(statementPrinterService);

        try {
            // US 1: Make a deposit
            System.out.println("Making initial deposit of 1000...");
            account.deposit(1000);
            Thread.sleep(1000); // Wait to create different timestamps
            System.out.println("Current Balance: " + account.getBalance());

            // US 2: Make a withdrawal
            System.out.println("\nMaking withdrawal of 50...");
            account.withdraw(50);
            Thread.sleep(1000);
            System.out.println("Current Balance: " + account.getBalance());

            // Additional deposit to show multiple transactions
            System.out.println("\nMaking another deposit of 1000...");
            account.deposit(1000);
            Thread.sleep(1000);
            System.out.println("Current Balance: " + account.getBalance());

            // US 3: Print account statement
            System.out.println("\n--- Account Statement ---");
            accountUtil.printStatement(account);

        } catch (InterruptedException e) {
            System.out.println("Demonstration was interrupted: " + e.getMessage());
        }
    }
}