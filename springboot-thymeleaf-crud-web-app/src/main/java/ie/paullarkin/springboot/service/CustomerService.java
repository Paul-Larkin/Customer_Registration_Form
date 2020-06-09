package ie.paullarkin.springboot.service;

import java.util.List;

import ie.paullarkin.springboot.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomerById(long id);
	void deleteCustomerById(long id);
}
