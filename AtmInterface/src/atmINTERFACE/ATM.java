package atmINTERFACE;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ATM {
    public static void main(String[] args) {
        // Create user and transaction objects
        User user = new User("user123", "1234", 1000.0);
        TransactionHistory transactionHistory = new TransactionHistory();

        try (// Display login prompt
		Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter User ID: ");
			String userId = scanner.nextLine();
			System.out.print("Enter User PIN: ");
			String pin = scanner.nextLine();

			// Authenticate the user
			if (user.authenticate(userId, pin)) {
			    boolean quit = false;

			    while (!quit) {
			        System.out.println("\nATM Interface:");
			        System.out.println("1. Withdraw");
			        System.out.println("2. Deposit");
			        System.out.println("3. Transfer");
			        System.out.println("4. Transaction History");
			        System.out.println("5. Quit");

			        System.out.print("Enter your choice: ");
			        int choice = scanner.nextInt();
			        scanner.nextLine(); // Consume the newline character

			        switch (choice) {
			            case 1:
			                // Handle Withdraw
			                System.out.print("Enter the amount to withdraw: ");
			                double withdrawAmount = scanner.nextDouble();
			                scanner.nextLine(); // Consume the newline character
			                if (user.withdraw(withdrawAmount)) {
			                    transactionHistory.addTransaction("Withdrawal: -" + withdrawAmount);
			                }
			                break;
			            case 2:
			                // Handle Deposit
			                System.out.print("Enter the amount to deposit: ");
			                double depositAmount = scanner.nextDouble();
			                scanner.nextLine(); // Consume the newline character
			                user.deposit(depositAmount);
			                transactionHistory.addTransaction("Deposit: +" + depositAmount);
			                break;
			            case 3:
			                // Handle Transfer
			                System.out.print("Enter the recipient's User ID: ");
			                String recipientId = scanner.nextLine();
			                User recipient = findUserById(recipientId); // Add this line
			                if (recipient != null) {
			                    System.out.print("Enter the amount to transfer: ");
			                    double transferAmount = scanner.nextDouble();
			                    scanner.nextLine(); // Consume the newline character
			                    user.transfer(recipient, transferAmount);
			                    transactionHistory.addTransaction("Transfer to " + recipientId + ": -" + transferAmount);
			                } else {
			                    System.out.println("Recipient not found.");
			                }
			                break;
			            case 4:
			                // Display Transaction History
			                transactionHistory.displayHistory();
			                break;
			            case 5:
			                quit = true;
			                System.out.println("Thank you for using the ATM.");
			                break;
			            default:
			                System.out.println("Invalid choice. Please try again.");
			        }
			    }
			} else {
			    System.out.println("Invalid User ID or PIN. Please try again.");
			}
		}
    }

    // Add the findUserById method here
    private static User findUserById(String userId) {
        // In a real system, you would search your user database or user list
        // to find the user with the specified ID. For this example, we assume
        // a hardcoded list of users for simplicity.

        // Create a list of users (you can replace this with your actual user data structure)
        List<User> users = new ArrayList<>();
        users.add(new User("user123", "1234", 1000.0));
        users.add(new User("user456", "5678", 1500.0));
        users.add(new User("user789", "9876", 2000.0));

        // Search for the user by ID
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                return u; // Return the found user
            }
        }

        // If the user is not found, return null
        return null;
    }
}
