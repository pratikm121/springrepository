package nl.pratik.boot.spring.service;

import java.util.List;

import nl.pratik.boot.spring.model.Customer;

public interface CustomerService {
		
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
