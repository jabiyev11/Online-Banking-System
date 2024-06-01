import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private Integer accountNumber;
    private Double balance;
    private String accountType;
    private List<String> transactionHistory;
    private Customer customer;

    public BankAccount(Integer accountNumber, Double balance, String accountType, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.customer = customer;
        this.transactionHistory = new ArrayList<>();
    }

    public void addTransactionToHistory(String transactionDetails){
        transactionHistory.add(transactionDetails);
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }


    @Override
    public String toString() {
        return STR."BankAccount{accountNumber=\{accountNumber}, balance=\{balance}, accountType='\{accountType}\{'\''}\{'}'}";
    }
}
