import java.util.Scanner;

public class Main {

    private static final CustomerManager customerManager = new CustomerManager();
    private static final BankAccountManager bankAccountManager = new BankAccountManager();
    private static final Authentication authentication = new Authentication();
    private static final Scanner scanner = new Scanner(System.in);
    private static Customer loggedInCustomer = null;


    public static void main(String[] args) {
        System.out.println("Welcome to Online Banking System");

        while (true) {

            if (loggedInCustomer == null) {
                printLoginRegisterMenu();
                int loginChoice = getUserChoice();

                switch (loginChoice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        registerCustomer();
                        break;
                    case 3:
                        System.out.println("Exiting Program...");
                        scanner.close();
                        System.exit(0);
                    case 4:
                        backToMainMenu();
                        break;
                    default:
                        System.out.println("Invalid choice, Please enter a valid number from 1 to 3");
                }
            } else {
                printMainMenu();
                int mainChoice = getUserChoice();

                switch (mainChoice) {
                    case 1:
                        manageCustomer();
                        break;
                    case 2:
                        manageBankAccount();
                        break;
                    case 3:
                        performTransactions();
                        break;
                    case 4:
                        manageStatistics();
                        break;
                    case 5:
                        logout();
                }

            }

        }


    }

    private static void printLoginRegisterMenu() {
        System.out.println("\nPlease select an Option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.println("4. Back to Main Menu");

    }


    private static void printMainMenu() {
        System.out.println("\nPlease select an Option:");
        System.out.println("1. Customer Management");
        System.out.println("2. Bank Account Management");
        System.out.println("3. Transactions");
        System.out.println("4. Monthly Statistics and Display Information");
        System.out.println("5. Logout");


    }


    private static Integer getUserChoice() {
        System.out.print("Enter your choice: ");
        Integer choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }


    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        authentication.login(username, password);

        if(authentication.isAuthenticated(username)){
            loggedInCustomer = authentication.getAuthenticatedUser(username);

            System.out.println("Welcome, " + loggedInCustomer.getName());
        }else{
            System.out.println("Invalid credentials, Try Again");
        }

    }

    private static void registerCustomer() {
        System.out.println("Enter Customer Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Customer customer = new Customer(null, name, address, phoneNumber, email, username, password);
        authentication.registerCustomer(username, password, customer);
    }

    private static void manageCustomer() {
        printCustomerManagementMenu();
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                addCustomer();
                break;
            case 2:
                updateCustomer();
                break;
            case 3:
                deleteCustomer();
                break;
            case 4:
                printAllCustomers();
                break;
            case 5:
                backToMainMenu();
                break;
            default:
                System.out.println("Invalid Choice, Please enter a valid number from 1 to 4");
        }
    }

    private static void printCustomerManagementMenu() {
        System.out.println("\nCustomer Management Menu:");
        System.out.println("1. Add Customer");
        System.out.println("2. Update Customer");
        System.out.println("3. Delete Customer");
        System.out.println("4. Print All Customers");
        System.out.println("5. Back to Main Menu");

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
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Customer customer = new Customer(null, name, address, phoneNumber, email, username, password);
        customerManager.addCustomer(customer);
        System.out.println("Customer added successfully with ID: " + customer.getCustomerID());
    }

    private static void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        int customerID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Customer customer = customerManager.getCustomer(customerID);
        if (customer != null) {
            System.out.println("Enter updated details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            customer.setName(name);
            customer.setAddress(address);
            customer.setPhoneNumber(phoneNumber);
            customer.setEmail(email);
            customer.setUsername(username);
            customer.setPassword(password);

            customerManager.updateCustomer(customer);
            System.out.println("Customer updated successfully");
        } else {
            System.out.println("Customer with ID " + customerID + " not found");
        }
    }

    private static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        int customerID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Customer customer = customerManager.getCustomer(customerID);
        if (customer != null) {
            customerManager.deleteCustomer(customerID);
            System.out.println("Customer with ID " + customerID + " deleted successfully");
        } else {
            System.out.println("Customer with ID " + customerID + " not found");
        }
    }

    private static void printAllCustomers() {
        customerManager.printAllCustomers();
    }

    private static void manageBankAccount() {
        printBankAccountManagementMenu();
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                addBankAccount();
                break;
            case 2:
                updateBankAccount();
                break;
            case 3:
                deleteBankAccount();
                break;
            case 4:
                printAllBankAccounts();
                break;
            case 5:
                backToMainMenu();
                break;
            default:
                System.out.println("Invalid Choice, Please enter a valid number from 1 to 4");
        }
    }

    private static void printBankAccountManagementMenu() {
        System.out.println("\nBank Account Management Menu:");
        System.out.println("1. Add Bank Account");
        System.out.println("2. Update Bank Account");
        System.out.println("3. Delete Bank Account");
        System.out.println("4. Print All Bank Accounts");
        System.out.println("5. Back to Main Menu");

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

    private static void updateBankAccount() {
        System.out.print("Enter Account Number to update: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline character

        BankAccount account = bankAccountManager.getBankAccount(accountNumber);
        if (account != null) {
            System.out.println("Enter updated details:");
            System.out.print("Account Type: ");
            String accountType = scanner.nextLine();

            account.setAccountType(accountType);
            bankAccountManager.updateBankAccount(account);
            System.out.println("Bank account updated successfully");
        } else {
            System.out.println("Bank account with number " + accountNumber + " not found");
        }
    }

    private static void deleteBankAccount() {
        System.out.print("Enter Account Number to delete: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline character

        BankAccount account = bankAccountManager.getBankAccount(accountNumber);
        if (account != null) {
            bankAccountManager.deleteBankAccount(accountNumber);
            System.out.println("Bank account with number " + accountNumber + " deleted successfully");
        } else {
            System.out.println("Bank account with number " + accountNumber + " not found");
        }
    }

    private static void printAllBankAccounts() {
        bankAccountManager.printAllAccounts();
    }

    private static void performTransactions() {
        printTransactionMenu();
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                performDeposit();
                break;
            case 2:
                performWithdrawal();
                break;
            case 3:
                performTransfer();
                break;
            case 4:
                backToMainMenu();
                break;
            default:
                System.out.println("Invalid Choice, Please enter a valid number from 1 to 3");
        }
    }

    private static void printTransactionMenu() {
        System.out.println("\nTransaction Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Back to Main Menu");

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

    private static void manageStatistics() {
        printStatisticsAndDisplayMenu();
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                displayAccountDetails();
                break;
            case 2:
                displayTransactionHistory();
                break;
            case 3:
                generateMonthlyStatement();
                break;
            case 4:
                backToMainMenu();
                break;
            default:
                System.out.println("Invalid Choice, Please enter a valid number from 1 to 3");
        }
    }

    private static void printStatisticsAndDisplayMenu() {
        System.out.println("\nDisplay Management Menu:");
        System.out.println("1. Account Details: ");
        System.out.println("2. Transaction History");
        System.out.println("3. Monthly Statistics");
        System.out.println("4. Back to Main Menu");

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


    private static void generateMonthlyStatement() {
        System.out.print("Enter Account Number: ");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Year (YYYY): ");
        Integer year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Month (MM): ");
        Integer month = scanner.nextInt();
        scanner.nextLine();

        bankAccountManager.generateAndPrintMonthlyStatement(accountNumber, year, month);
    }

    private static void logout() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        authentication.logout(username);
        printLoginRegisterMenu();

    }


    private static void backToMainMenu() {
        printMainMenu();
    }


}
