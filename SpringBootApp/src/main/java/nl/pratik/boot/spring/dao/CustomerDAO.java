package nl.pratik.boot.spring.dao;

import java.util.List;

import nl.pratik.boot.spring.model.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
