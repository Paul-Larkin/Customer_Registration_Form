package ie.paullarkin.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.paullarkin.springboot.model.Customer;
import ie.paullarkin.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		this.customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer Customer = null;
		if(optional.isPresent()) {
			Customer = optional.get();
		} else {
			throw new RuntimeException("Customer not fouond for id: " + id);
		}
		return Customer;
	}

	@Override
	public void deleteCustomerById(long id) {
		this.customerRepository.deleteById(id);
	}
}
