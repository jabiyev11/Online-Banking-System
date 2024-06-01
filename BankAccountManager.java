import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BankAccountManager {

    private Map<Integer, BankAccount> accounts;
    private Integer nextAccountNumber;

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
            System.out.println("Deposit " + amount + " AZN added into balance of " + accountNumber + "successfully");
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
                System.out.println("Withdrawn " + amount + "AZN from account " + accountNumber);
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
                Double newBalanceOfReceiver = currentBalanceOfReceiver + amount;
                accountOfReceiver.setBalance(newBalanceOfReceiver);
                System.out.println(amount + "AZN has been transferred to " + accountNumberOfReceiver + " account");
            } else {
                System.out.println("Insufficient funds in the balance");
            }

        } else {
            System.out.println("Account with number " + accountNumberOfSender + "and/or " + accountNumberOfReceiver + " is/are not found");
        }

    }

}
