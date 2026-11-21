class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) { super(message); }
}
class BankAccount {
    private final String accountNumber;
    private double balance;
    BankAccount(String accountNumber, double openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Negative opening balance");
        this.accountNumber = accountNumber; this.balance = openingBalance;
    }
    public synchronized void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }
    public synchronized void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) throw new InsufficientFundsException("Insufficient balance in " + accountNumber);
        balance -= amount;
    }
    public synchronized double getBalance() { return balance; }
}
public class BankWithCustomExceptions {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("AC1001", 5000);
        try {
            account.deposit(1500);
            account.withdraw(2000);
            System.out.println("Balance: " + account.getBalance());
            account.withdraw(10000);
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } finally {
            System.out.println("Transaction session closed.");
        }
    }
}
