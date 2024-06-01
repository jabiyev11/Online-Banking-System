import java.util.Scanner;

public class Main {

    private static final CustomerManager customerManager = new CustomerManager();
    private static final BankAccountManager bankAccountManager = new BankAccountManager();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to Online Banking System");

        while (true) {
            printMenu();

            Integer choice = getUserChoice();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addBankAccount();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performWithdrawal();
                    break;
                case 5:
                    performTransfer();
                    break;
                case 6:
                    displayAccountDetails();
                    break;
                case 7:
                    displayTransactionHistory();
                    break;
                case 8:
                    printAllCustomers();
                    break;
                case 9:
                    printAllBankAccounts();
                    break;
                case 10:
                    System.out.println("Exiting Program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice, Please enter a valid number from 1 to 10");

            }
        }
    }


    private static void printMenu() {
        System.out.println("\nPlease select an Option:");
        System.out.println("1. Add Customer");
        System.out.println("2. Add Bank Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. Display Account Details");
        System.out.println("7. Display Transaction History");
        System.out.println("8. Print All Customers");
        System.out.println("9. Print All Bank Accounts");
        System.out.println("10. Exit");
    }

    private static Integer getUserChoice() {
        System.out.print("Enter your choice: ");
        Integer choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void addCustomer() {
        System.out.println("Enter Customer Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(null, name, address, phoneNumber, email);
        customerManager.addCustomer(customer);
        System.out.println("Customer added successfully with ID: " + customer.getCustomerID());
    }

    private static void addBankAccount() {
        System.out.println("Enter Bank Account Details:");
        System.out.print("Customer ID: ");
        Integer customerID = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerManager.getCustomer(customerID);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with ID: " + customerID);
        }

        System.out.print("Account Type: ");
        String accountType = scanner.nextLine();

        String generatedAccountNumber = BankAccountManager.generateAccountNumber();

        BankAccount account = new BankAccount(Long.parseLong(generatedAccountNumber), 0.0, accountType, customer);
        bankAccountManager.addBankAccount(account, generatedAccountNumber);
        System.out.println("Bank account added succesfully with Account Number " + account.getAccountNumber());
    }

    private static void performDeposit() {
        System.out.print("Enter Account Number: ");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Deposit Amount: ");
        Double amount = scanner.nextDouble();

        bankAccountManager.deposit(accountNumber, amount);
    }

    private static void performWithdrawal() {
        System.out.print("Enter Account Number: ");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Withdrawal Amount: ");
        Double amount = scanner.nextDouble();

        bankAccountManager.withdraw(accountNumber, amount);
    }

    private static void performTransfer() {
        System.out.print("Enter Sender's Account Number: ");
        Long senderAccountNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Receiver's Account Number: ");
        Long receiverAccountNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Transfer Amount: ");
        Double amount = scanner.nextDouble();

        bankAccountManager.transfer(senderAccountNumber, receiverAccountNumber, amount);
    }

    private static void displayAccountDetails() {
        System.out.print("Enter Account Number: ");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine();


        bankAccountManager.displayAccount(accountNumber);

    }

    private static void displayTransactionHistory() {
        System.out.print("Enter Account Number: ");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine();

        bankAccountManager.displayTransactionHistory(accountNumber);
    }

    private static void printAllCustomers() {
        customerManager.printAllCustomers();
    }

    private static void printAllBankAccounts() {
        bankAccountManager.printAllAccounts();
    }


}
