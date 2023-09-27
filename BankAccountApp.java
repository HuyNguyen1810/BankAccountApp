import java.util.Scanner;

class BankAccount{
    private String AccNumber;
    private String AccHolderName;
    private double balance;

    public BankAccount(String AccNumber, String AccHolderName, double initialBalance){
        this.AccNumber = AccNumber;
        this.AccHolderName = AccHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println(balance);
        }else{
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

public class BankAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Simple Bank Account Program");

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        double initialBalance;
        while (true) {
            System.out.print("Enter initial balance: ");
            try {
                initialBalance = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric balance.");
            }
        }

        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);

        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    double depositAmount;
                    while (true) {
                        System.out.print("Enter the amount to deposit: ");
                        try {
                            depositAmount = Double.parseDouble(scanner.nextLine());
                            account.deposit(depositAmount);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid numeric amount.");
                        }
                    }
                    break;
                case 2:
                    double withdrawAmount;
                    while (true) {
                        System.out.print("Enter the amount to withdraw: ");
                        try {
                            withdrawAmount = Double.parseDouble(scanner.nextLine());
                            account.withdraw(withdrawAmount);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid numeric amount.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Current balance: $" + account.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the Simple Bank Account Program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-4).");
            }
        } while (choice != 4);

        scanner.close();
    }
}