package org.example;

import org.example.domain.Account;
import org.example.service.StatementPrinterService;
import org.example.util.AccountUtil;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello and welcome!");
        Account account = new Account();
        StatementPrinterService statementPrinterService = new StatementPrinterService();
        AccountUtil accountUtil = new AccountUtil(statementPrinterService);
        account.deposit(1000);
        Thread.sleep(1000);
        System.out.println("Current Balance is "+account.getBalance());
        account.withdraw(50);
        Thread.sleep(1000);
        System.out.println("Current Balance after withdrawal is "+account.getBalance());
        account.deposit(1000);
        Thread.sleep(1000);
        System.out.println("Current Balance after deposit is "+account.getBalance());
        System.out.println("Printing Statement");
        accountUtil.printStatement(account);

    }
}