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

    public BankAccount getBankAccount(int accountNumber){
        return accounts.get(accountNumber);

    }

    public void printAllAccounts(){
        System.out.print("All Bank Accounts: ");
        for(BankAccount account: accounts.values()){
            System.out.println(account);
        }
    }

}
