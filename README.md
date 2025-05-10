# Bank Account Kata

A Java implementation of the Bank Account Kata that simulates basic banking operations.

## Requirements
- Java 11 or higher
- JUnit 5 (for testing)
- Mockito (for testing)

## User Stories

**US 1:** In order to save money as a bank client, I want to make a deposit in my account

**US 2:** In order to retrieve some or all of my savings as a bank client, I want to make a withdrawal from my account

**US 3:** In order to check my operations as a bank client, I want to see the history (operation, date, amount, balance) of my operations

## Project Structure

```plaintext
com.bankkata
├── domain      // Core domain objects
│   ├── Account.java
│   ├── Transaction.java
│   └── TransactionType.java
├── service     // Business services
│   └── StatementPrinter.java
├── util        // Utility classes
│   └── AccountUtil.java
└── Main.java   // Application entry point
```
## How to Run

Compile and run the Main class to see a demonstration of the bank account operations.

## Tests

The project includes comprehensive tests for all components.