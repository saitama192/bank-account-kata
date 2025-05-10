package org.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(); // Initialize a new account before each test
    }

    @Test
    void shouldStartWithZeroBalanceAndNoTransactions() {
        // Given: A new account

        // Then
        assertEquals(0.0, account.getBalance(), 0.001, "Balance should be 0.0");
        assertTrue(account.getTransactions().isEmpty(), "Transaction list should be empty");
    }

    @Test
    public void shouldIncreaseBalanceWhenDepositIsMade() {
        // Given
        double depositAmount = 100.0;

        // When
        account.deposit(depositAmount);

        // Then
        assertEquals(100.0, account.getBalance(), 0.001, "Balance should be updated after deposit");
        assertEquals(1, account.getTransactions().size(), "Should have one transaction");
        Transaction tx = account.getTransactions().get(0);
        assertEquals(TransactionType.DEPOSIT, tx.getType(), "Transaction type should be DEPOSIT");
        assertEquals(100.0, tx.getAmount(), 0.001, "Transaction amount should match deposit");

    }

    @Test
    public void shouldDecreaseBalanceWhenWithdrawalIsMade() {
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.001, "Balance should be reduced after withdrawal");
    }

    @Test
    public void shouldNotAllowNegativeDeposits() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0),
                "Deposit amount must be positive");
    }

    @Test
    public void shouldNotAllowNegativeWithdrawals() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0),
                "Withdrawal amount must be positive");
    }

    @Test
    public void shouldNotAllowWithdrawalMoreThanBalance() {
        // Given
        //When Account balance is 100.0
        account.deposit(100.0);
        // Then
        assertThrows(IllegalStateException.class, () -> account.withdraw(150.0),"Insufficient funds");
    }

    @Test
    public void shouldRecordTransactionHistoryOnDeposit() {
        account.deposit(150.0);
        assertEquals(1, account.getTransactions().size());
        assertEquals(150.0, account.getTransactions().get(0).getAmount(),
                "Transaction amount should match deposit");
    }
    @Test
    public void shouldRecordTransactionHistoryOnWithdrawal() {
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(2, account.getTransactions().size(),"Should have two transactions");
        assertEquals(-50.0, account.getTransactions().get(1).getAmount(),"Transaction amount should match withdrawal");
    }
}