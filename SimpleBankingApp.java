import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom exception for account not found
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

public class SimpleBankingApp {
    private HashMap<Integer, Double> accounts;

    public SimpleBankingApp() {
        accounts = new HashMap<>();
    }

    // Add new account with initial balance
    public void addAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Deposit money into an account
    public void deposit(int accountNumber, double amount) throws AccountNotFoundException {
        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException("Account " + accountNumber + " not found.");
        }
        double newBalance = accounts.get(accountNumber) + amount;
        accounts.put(accountNumber, newBalance);
        System.out.println("Deposited " + amount + " to account " + accountNumber);
    }

    // Withdraw money from an account
    public void withdraw(int accountNumber, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException("Account " + accountNumber + " not found.");
        }
        double currentBalance = accounts.get(accountNumber);
        if (amount > currentBalance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
        accounts.put(accountNumber, currentBalance - amount);
        System.out.println("Withdrew " + amount + " from account " + accountNumber);
    }

    // Display all accounts with balances
    public void displayAccounts() {
        System.out.println("\nAccount Details:");
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account Number: " + entry.getKey() + " | Balance: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        SimpleBankingApp bank = new SimpleBankingApp();
        Scanner scanner = new Scanner(System.in);

        // Adding some sample accounts
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 3000);
        bank.addAccount(1003, 7000);

        try {
            // Sample operations
            bank.deposit(1001, 1500);
            bank.withdraw(1002, 3500); // This will throw InsufficientBalanceException
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            bank.withdraw(9999, 100); // This will throw AccountNotFoundException
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        bank.displayAccounts();

        scanner.close();
    }
}
