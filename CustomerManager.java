import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

    private Map<Integer, Customer> customers;
    private Integer nextCustomerID;

    public CustomerManager() {
        customers = new HashMap<>();
        nextCustomerID = 1;
    }


    public void addCustomer(Customer customer) {
        customer.setCustomerID(nextCustomerID);
        customers.put(nextCustomerID, customer);
        nextCustomerID++;
    }

    public void updateCustomer(Customer customer) {
        int customerID = customer.getCustomerID();
        if (customers.containsKey(customerID)) {
            customers.put(customerID, customer);
        } else {
            System.out.println("Customer with ID " + customerID + " not found");
        }
    }

    public void deleteCustomer(int customerID) {
        customers.remove(customerID);
    }

    public Customer getCustomer(int customerID) {
        return customers.get(customerID);
    }

    public void printAllCustomers() {
        System.out.print("All Customers: ");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }

}
