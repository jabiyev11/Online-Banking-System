import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

    private static Map<Integer, Customer> customers;

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

    /**
     * Research about Map. putIfAbsent method
     */
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

    public static Customer getCustomerByUsername(String username){
        for(Customer customer: customers.values()){
            if(customer.getUsername().equals(username)){
                return customer;
            }

        }
        return null; // TODO instead of returning null, in case of no user found, you can throw a new exception like "UserNotFoundException"
    }

    public void printAllCustomers() {
        System.out.print("All Customers: ");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }

}
