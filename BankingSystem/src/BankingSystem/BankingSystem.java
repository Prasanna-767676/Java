package BankingSystem;
//Base class for bank accounts
class BankAccount {
 private String accountHolder;
 private double balance;

 // Constructor
 public BankAccount(String accountHolder) {
     this.accountHolder = accountHolder;
     this.balance = 0.0;
 }

 // Method to deposit money
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount + ", New Balance: " + balance);
     } else {
         System.out.println("Deposit amount must be positive.");
     }
 }

 // Method to withdraw money
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount + ", Remaining Balance: " + balance);
     } else {
         System.out.println("Invalid withdrawal amount.");
     }
 }

 // Method to get balance
 public double getBalance() {
     return balance;
 }

 // Method to display account holder details
 public void displayAccountInfo() {
     System.out.println("Account Holder: " + accountHolder + ", Balance: " + balance);
 }
}

//Class for savings accounts that extends BankAccount
class SavingsAccount extends BankAccount {
 private double interestRate;

 // Constructor
 public SavingsAccount(String accountHolder, double interestRate) {
     super(accountHolder); // Call the constructor of BankAccount
     this.interestRate = interestRate;
 }

 // Method to apply interest
 public void applyInterest() {
     double interest = getBalance() * interestRate / 100;
     deposit(interest);
     System.out.println("Interest applied: " + interest + ", New Balance: " + getBalance());
 }
}

//Main class to demonstrate OOP concepts

public class BankingSystem {

	public static void main(String[] args) {
		 // Creating a savings account object
        SavingsAccount savingsAccount = new SavingsAccount("Alice", 5.0);

        // Display initial account information
        savingsAccount.displayAccountInfo();

        // Deposit money
        savingsAccount.deposit(1000);

        // Withdraw money
        savingsAccount.withdraw(200);

        // Apply interest
        savingsAccount.applyInterest();

        // Display final account information
        savingsAccount.displayAccountInfo();

	}

}
