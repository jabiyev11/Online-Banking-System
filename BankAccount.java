import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class BankAccount {

    private Long accountNumber;
    private Double balance;
    private String accountType;
    private List<Transaction> transactionHistory;
    private Customer customer;

    public BankAccount(Long accountNumber, Double balance, String accountType, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.customer = customer;
        this.transactionHistory = new ArrayList<>();
    }

    public void addTransactionToHistory(Double amount, String description, LocalDate date){
        Transaction transaction = new Transaction(amount, description, date);
        transactionHistory.add(transaction);
    }

    public List<Transaction> getTransactionsForMonth(Integer year, Integer month){
        List<Transaction> transactionsForMonth = new ArrayList<>();
        for(Transaction transaction : transactionHistory){
            if(transaction.getDate().getYear() == year && transaction.getDate().getMonthValue() == month){
                transactionsForMonth.add(transaction);
            }
        }

        return transactionsForMonth;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
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

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(balance, that.balance) && Objects.equals(accountType, that.accountType) && Objects.equals(transactionHistory, that.transactionHistory) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance, accountType, transactionHistory, customer);
    }

    @Override
    public String toString() {
        return STR."BankAccount{accountNumber=\{accountNumber}, balance=\{balance}, accountType='\{accountType}\{'\''}\{'}'}";
    }

    //Inner Class Transaction

    public class Transaction{
        private Double amount;
        private String description;
        private LocalDate date;

        public Transaction(Double amount, String description, LocalDate date) {
            this.amount = amount;
            this.description = description;
            this.date = date;
        }

        public Double getAmount() {
            return amount;
        }

        public String getDescription() {
            return description;
        }

        public LocalDate getDate() {
            return date;
        }
    }
}
