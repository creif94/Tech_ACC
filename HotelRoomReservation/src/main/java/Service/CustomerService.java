package Service;

import model.Customer;

public class CustomerService {

    public void addCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer(firstName, lastName, email);
    }
    public Customer getCustomer(String email){
        Customer customer;
        return Customer.getName();

    }


}
