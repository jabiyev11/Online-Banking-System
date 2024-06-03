import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class BankAccountManager {

    private Map<Long, BankAccount> accounts;
    private final Integer nextAccountNumber;

    public BankAccountManager() {
        accounts = new HashMap<>();
        nextAccountNumber = 194;
    }

    public static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            int digit = random.nextInt(10);
            stringBuilder.append(digit);
        }

        int firstDigit = random.nextInt(9) + 1;
        stringBuilder.insert(0, firstDigit);

        return stringBuilder.toString();
    }

    public void addBankAccount(BankAccount account, String generatedAccountNumber) {
        account.setAccountNumber(Long.parseLong(generatedAccountNumber));
        accounts.put(Long.parseLong(generatedAccountNumber), account);
    }

    public void updateBankAccount(BankAccount account) {
        long accountNumber = account.getAccountNumber();
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, account);
        } else {
            System.out.println("Account with number " + accountNumber + " not found");
        }
    }

    public void deleteBankAccount(Long accountNumber) {
        accounts.remove(accountNumber);
    }

    public BankAccount getBankAccount(Long accountNumber) {
        return accounts.get(accountNumber);

    }

    public void printAllAccounts() {
        System.out.print("All Bank Accounts: ");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }

    public void deposit(Long accountNumber, Double amount) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            Double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            LocalDate date = LocalDate.now();
            account.addTransactionToHistory(amount, "Deposited $" + amount, date);
            System.out.println("Deposit $" + amount + " added into balance of " + accountNumber + " successfully");
        } else {
            System.out.println("Account with number " + accountNumber + " is not found");
        }
    }

    public void withdraw(Long accountNumber, Double amount) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            Double currentBalance = account.getBalance();
            if (account.getBalance() >= amount) {
                Double newBalance = currentBalance - amount;
                account.setBalance(newBalance);
                LocalDate date = LocalDate.now();
                account.addTransactionToHistory(amount, "Withdrawn $" + amount, date);
                System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient funds in the balance");
            }
        } else {
            System.out.println("Account with number " + accountNumber + " not found");
        }
    }

    public void transfer(Long accountNumberOfSender, Long accountNumberOfReceiver, Double amount) {
        if (accounts.containsKey(accountNumberOfSender) && accounts.containsKey(accountNumberOfReceiver)) {
            BankAccount accountOfSender = accounts.get(accountNumberOfSender);
            BankAccount accountOfReceiver = accounts.get(accountNumberOfReceiver);
            Double currentBalanceOfSender = accountOfSender.getBalance();
            Double currentBalanceOfReceiver = accountOfReceiver.getBalance();

            if (currentBalanceOfSender >= amount) {
                Double newBalanceOfSender = currentBalanceOfSender - amount;
                accountOfSender.setBalance(newBalanceOfSender);
                LocalDate date = LocalDate.now();
                accountOfSender.addTransactionToHistory(amount, "Transferred $" + amount + " to account " + accountNumberOfReceiver, date);
                Double newBalanceOfReceiver = currentBalanceOfReceiver + amount;
                accountOfReceiver.setBalance(newBalanceOfReceiver);
                accountOfReceiver.addTransactionToHistory(amount, "Received $" + amount + " from account " + accountNumberOfSender, date);
                System.out.println("$" + amount + " has been transferred to " + accountNumberOfReceiver + " account");
            } else {
                System.out.println("Insufficient funds in the balance");
            }

        } else {
            System.out.println("Account with number " + accountNumberOfSender + "and/or " + accountNumberOfReceiver + " is/are not found");
        }

    }

    public void displayAccount(Long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            System.out.println("Account Details:");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Account Type: " + account.getAccountType());
        } else {
            System.out.println("Account with number " + accountNumber + " not found");
        }
    }

    public void displayTransactionHistory(Long accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            List<BankAccount.Transaction> transactions = account.getTransactionHistory();
            System.out.println("Transaction history for account " + accountNumber + ": ");
            for (BankAccount.Transaction transaction : transactions) {
                System.out.println(transaction.getDate() + " - " + transaction.getDescription() + " - Balance: $" + account.getBalance());
            }
        } else {
            System.out.println("Account with number " + accountNumber + " not found");
        }
    }

    public void generateAndPrintMonthlyStatement(Long accountNumber, Integer year, Integer month) {
        BankAccount account = accounts.get(accountNumber);
        if(account != null){
            YearMonth targetMonth = YearMonth.of(year, month);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            System.out.println("Monthly Statement for Account Number: " + accountNumber);
            System.out.println("Month: " + targetMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy")));


            List<BankAccount.Transaction> transactions = account.getTransactionHistory();
            boolean foundTransactions = false;

            for(BankAccount.Transaction transaction : transactions){
                LocalDate transactionDate = transaction.getDate().atStartOfDay().toLocalDate();
                if(transactionDate.getYear() == year && transactionDate.getMonthValue() == month){
                    if(!foundTransactions){
                        System.out.println("--------------------------------------------------");
                        System.out.printf("%-15s %-30s %10s%n", "Date", "Description", "Amount");
                        System.out.println("--------------------------------------------------");
                        foundTransactions = true;
                    }

                    System.out.printf("%-15s %-30s $%10.2f%n", transactionDate.format(formatter), transaction.getDescription(), transaction.getAmount());
                }
            }

            if(!foundTransactions){
                System.out.println("No transaction found for " + targetMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy")));
            }else{
                System.out.println("-------------------------------------------------");
            }
        }

        else{
            System.out.println("Account with number " + accountNumber + " not found");
        }
    }


    public BankAccount searchByAccountNumber(Long accountNumber) {
        return accounts.get(accountNumber);
    }


    public List<BankAccount> searchByCustomerID(Customer customer) {
        List<BankAccount> matchingAccounts = new ArrayList<>();
        for (BankAccount account : accounts.values()) {
            if (account.getCustomer().getCustomerID().equals(customer.getCustomerID())) {
                matchingAccounts.add(account);
            }
        }

        return matchingAccounts;
    }




}




