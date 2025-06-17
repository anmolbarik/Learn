package oops;

public class Encapsulation {

    public static void main(String[] args) {
        System.out.println("=== Encapsulation with Validation ===\n");


        BankAccount account = new BankAccount();


        account.setAccountNumber("12345678");
        account.setAccountHolder("John Doe");
        account.setBalance(1000.0);


        System.out.println("Account Information:");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: $" + account.getBalance());


        System.out.println("\nTrying to set invalid values:");


        System.out.print("Setting invalid account number: ");
        account.setAccountNumber("123");


        System.out.print("Setting empty account holder: ");
        account.setAccountHolder("");


        System.out.print("Setting negative balance: ");
        account.setBalance(-500.0);


        System.out.println("\nAccount Information after invalid attempts:");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: $" + account.getBalance());

        // Demonstrate deposit and withdraw with validation
        System.out.println("\nPerforming transactions:");
        System.out.println("Depositing $500...");
        boolean depositResult = account.deposit(500.0);
        System.out.println("Deposit successful: " + depositResult);
        System.out.println("New Balance: $" + account.getBalance());

        System.out.println("Withdrawing $200...");
        boolean withdrawResult = account.withdraw(200.0);
        System.out.println("Withdrawal successful: " + withdrawResult);
        System.out.println("New Balance: $" + account.getBalance());

        System.out.println("Attempting to withdraw $2000 (exceeds balance)...");
        withdrawResult = account.withdraw(2000.0);
        System.out.println("Withdrawal successful: " + withdrawResult);
        System.out.println("Balance remains: $" + account.getBalance());

        // Create a Person object to demonstrate more encapsulation
        System.out.println("\n--- Person Class Example ---");
        Person person = new Person();

        // Set valid values
        person.setName("Alice Johnson");
        person.setAge(25);
        person.setEmail("alice@example.com");

        // Display person information
        System.out.println("Person Information:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());

        // Try invalid values
        System.out.println("\nTrying invalid values:");
        System.out.print("Setting invalid age: ");
        person.setAge(-5);
        System.out.print("Setting invalid email: ");
        person.setEmail("invalid-email");

        // Verify person information remains valid
        System.out.println("\nPerson Information after invalid attempts:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
    }
}

class BankAccount {
    // Private fields - not accessible directly from outside the class
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount() {
        this.accountNumber = "";
        this.accountHolder = "";
        this.balance = 0.0;
    }

    // Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter with validation for accountNumber
    public void setAccountNumber(String accountNumber) {
        // Validate account number (must be 8 digits)
        if (accountNumber != null && accountNumber.length() == 8) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Invalid account number. Must be 8 characters.");
        }
    }

    // Getter for accountHolder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Setter with validation for accountHolder
    public void setAccountHolder(String accountHolder) {
        // Validate account holder (must not be empty)
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Invalid account holder. Cannot be empty.");
        }
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter with validation for balance
    public void setBalance(double balance) {
        // Validate balance (must be non-negative)
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance. Cannot be negative.");
        }
    }

    // Method to deposit money with validation
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            System.out.println("Invalid deposit amount. Must be positive.");
            return false;
        }
    }

    // Method to withdraw money with validation
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal. Amount must be positive and not exceed balance.");
            return false;
        }
    }
}


class Person {
    private String name;
    private int age;
    private String email;

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter with validation for age
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Must be between 0 and 120.");
        }
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter with validation for email
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email format. Must contain '@' and '.'");
        }
    }
}
