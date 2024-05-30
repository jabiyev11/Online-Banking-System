public class Customer {

    private String name;
    private Integer customerID;
    private String address;
    private String phoneNumber;
    private String email;



    public Customer(Integer customerID, String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.customerID = customerID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    @Override
    public String toString() {
        return STR."Customer{name='\{name}\{'\''}, customerID=\{customerID}, address='\{address}\{'\''}, phoneNumber='\{phoneNumber}\{'\''}, email='\{email}\{'\''}\{'}'}";
    }
}
