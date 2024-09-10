public class Account {
    // Member variable to hold the current balance
    private double balance;

    // Default constructor that initializes balance to 0.0
    public Account() {
        this.balance = 0.0;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    // Method to withdraw an amount from the account
    public double withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return amount;
        } else {
            return 0.0;
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return this.balance;
    }
}
