package ie.paullarkin.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ie.paullarkin.springboot.model.Customer;
import ie.paullarkin.springboot.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	// displays a list of customers
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		return "index";
	}
	
	@GetMapping("/showNewCustomerForm")
	public String showNewcustomerform(Model model) {
		Customer customer = new Customer();
		model.addAttribute("Customer", customer);
		return "new_customer";
	}
	
	@PostMapping("/saveCustomer")
	public String savecustomer(@ModelAttribute("Customer") Customer customer) {
		// Save customer to database
		customerService.saveCustomer(customer);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		// get customer from the service
		Customer customer = customerService.getCustomerById(id);
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("Customer", customer);
		return "update_customer";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deletecustomer(@PathVariable (value = "id") long id) {
		// call deletecustomer Method
		this.customerService.deleteCustomerById(id);
		return "redirect:/";
	}
}
