import java.util.HashMap;
import java.util.Map;

public class Authentication {

    private Map<String, Customer> authenticatedUsers;
    private Map<String, Customer> registeredUsers;


    public Authentication() {
        this.authenticatedUsers = new HashMap<>();
        this.registeredUsers = new HashMap<>();
    }

    public void registerCustomer(String username, String password, Customer customer){
        registeredUsers.put(username, customer);
        customer.setPassword(password);
        System.out.println("Customer registered successfully");
    }

    public void login(String username, String password) {
        Customer customer = registeredUsers.get(username);
        if (customer != null && customer.getPassword().equals(password)) {
            authenticatedUsers.put(username, customer);
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid credentials, Try Again");
        }
    }

    public void logout(String username){
        authenticatedUsers.remove(username);
        System.out.println("Logged out successfully");
    }

    public boolean isAuthenticated(String username){
        return authenticatedUsers.containsKey(username);
    }

    public Customer getAuthenticatedUser(String username){
        return authenticatedUsers.get(username);
    }

    private Customer findCustomerByUsername(String username) {
        return CustomerManager.getCustomerByUsername(username);
    }
}
