package org.example.util;

import org.example.domain.Account;
import org.example.service.StatementPrinterService;

public class AccountUtil {
    private final StatementPrinterService statementPrinterService;
    public AccountUtil (StatementPrinterService statementPrinterService) {
        this.statementPrinterService = statementPrinterService;
    }

    /**
     * Prints the account statement showing all transactions.
     *
     * @param account The account whose statement should be printed
     */
    public void printStatement(Account account) {
        statementPrinterService.print(account.getTransactions());
    }
}
