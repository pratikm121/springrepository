package nl.pratik.boot.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.pratik.boot.spring.model.Customer;
import nl.pratik.boot.spring.service.CustomerService;

//import nl.pratik.rest.spring.exception.DataNotFoundException;
//import nl.pratik.rest.spring.ser	vice.CustomerService;

//http://localhost:9090/sba/cs/
@RestController
@RequestMapping("/cs")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	//http://localhost:9090/sba/cs/customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getStudent(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) {
			//throw new DataNotFoundException("Customer Id not found -" + customerId);
			System.out.println("Customer Id not found -" + customerId);
		}else {
			System.out.println("Id="+ customer.getId() + ",email="+customer.getEmail());
		}
		
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0); 				// deliberately settting the primary key 0 so that hibernate creates an insert
		customerService.saveCustomer(customer);
		return customer;		
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;		
	}
	
	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer !=null) {
			customerService.deleteCustomer(customer.getId());
		}else {
		//	throw new DataNotFoundException("Customer Id not found :-" + customerId);
			System.out.println("Customer Id not found -" + customerId);
		}		
		
		return customer;		
	}
	 

}
