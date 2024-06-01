import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private Integer accountNumber;
    private Double balance;
    private String accountType;
    private List<String> transactionHistory;
    private Integer customerID;

    public BankAccount(Integer accountNumber, Double balance, String accountType, Integer customerID) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.customerID = customerID;
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

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
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
