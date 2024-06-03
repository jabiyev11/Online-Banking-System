import java.util.Objects;

public class Customer {

    private String name;
    private Integer customerID;
    private String address;
    private String phoneNumber;
    private String email;
    private CustomerType customerType;
    private String username;
    private String password;


    public Customer(Integer customerID, String name, String address, String phoneNumber, String email, String username, String password) {
        this.name = name;
        this.customerID = customerID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(customerID, customer.customerID) && Objects.equals(address, customer.address) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customerID, address, phoneNumber, email);
    }

    @Override
    public String toString() {
        return STR."Customer{name='\{name}\{'\''}, customerID=\{customerID}, address='\{address}\{'\''}, phoneNumber='\{phoneNumber}\{'\''}, email='\{email}\{'\''}\{'}'}";
    }
}
