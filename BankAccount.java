public class BankAccount {

    private Integer accountNumber;
    private Double balance;
    private String accountType;

    public BankAccount(Integer accountNumber, Double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
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

    @Override
    public String toString() {
        return STR."BankAccount{accountNumber=\{accountNumber}, balance=\{balance}, accountType='\{accountType}\{'\''}\{'}'}";
    }
}
