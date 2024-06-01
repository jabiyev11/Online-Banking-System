import java.util.*;

public class BankAccountManager {

    private Map<Integer, BankAccount> accounts;
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

    public void addBankAccount(BankAccount account) {
        String accountNumber = generateAccountNumber();
        account.setAccountNumber(Integer.parseInt(accountNumber));
        accounts.put(Integer.parseInt(accountNumber), account);
    }

    public void updateBankAccount(BankAccount account) {
        int accountNumber = account.getAccountNumber();
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, account);
        } else {
            System.out.println("Account with number " + accountNumber + " not found");
        }
    }

    public void deleteBankAccount(Integer accountNumber) {
        accounts.remove(accountNumber);
    }

    public BankAccount getBankAccount(Integer accountNumber) {
        return accounts.get(accountNumber);

    }

    public void printAllAccounts() {
        System.out.print("All Bank Accounts: ");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }

    public void deposit(Integer accountNumber, Double amount) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            Double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            account.addTransactionToHistory("Deposited $" + amount);
            System.out.println("Deposit $" + amount + " added into balance of " + accountNumber + "successfully");
        } else {
            System.out.println("Account with number " + accountNumber + " is not found");
        }
    }

    public void withdraw(Integer accountNumber, Double amount) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            Double currentBalance = account.getBalance();
            if (account.getBalance() >= amount) {
                Double newBalance = currentBalance - amount;
                account.setBalance(newBalance);
                account.addTransactionToHistory("Withdrawn $" + amount);
                System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient funds in the balance");
            }
        } else {
            System.out.println("Account with number " + accountNumber + " not found");
        }
    }

    public void transfer(Integer accountNumberOfSender, Integer accountNumberOfReceiver, Double amount) {
        if (accounts.containsKey(accountNumberOfSender) && accounts.containsKey(accountNumberOfReceiver)) {
            BankAccount accountOfSender = accounts.get(accountNumberOfSender);
            BankAccount accountOfReceiver = accounts.get(accountNumberOfReceiver);
            Double currentBalanceOfSender = accountOfSender.getBalance();
            Double currentBalanceOfReceiver = accountOfSender.getBalance();

            if (currentBalanceOfSender >= amount) {
                Double newBalanceOfSender = currentBalanceOfSender - amount;
                accountOfSender.setBalance(newBalanceOfSender);
                accountOfSender.addTransactionToHistory("Transferred $" + amount + " to account " + accountNumberOfReceiver);
                Double newBalanceOfReceiver = currentBalanceOfReceiver + amount;
                accountOfReceiver.setBalance(newBalanceOfReceiver);
                accountOfReceiver.addTransactionToHistory("Received $" + amount + " from account " + accountNumberOfSender);
                System.out.println("$" + amount + " has been transferred to " + accountNumberOfReceiver + " account");
            } else {
                System.out.println("Insufficient funds in the balance");
            }

        } else {
            System.out.println("Account with number " + accountNumberOfSender + "and/or " + accountNumberOfReceiver + " is/are not found");
        }

    }

    public void displayAccount(Integer accountNumber) {
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

    public void displayTransactionHistory(Integer accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            List<String> transactions = account.getTransactionHistory();
            System.out.println("Transaction history for account " + accountNumber + ": ");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account with number " + accountNumber + " not found");
        }
    }


    public BankAccount searchByAccountNumber(Integer accountNumber){
        return accounts.get(accountNumber);
    }


    public List<BankAccount> searchByCustomerID(Customer customer){
        List<BankAccount> matchingAccounts = new ArrayList<>();
        for(BankAccount account : accounts.values()){
            if(account.getCustomer().getCustomerID().equals(customer.getCustomerID())){
                matchingAccounts.add(account);
            }
        }

        return matchingAccounts;
    }

}
