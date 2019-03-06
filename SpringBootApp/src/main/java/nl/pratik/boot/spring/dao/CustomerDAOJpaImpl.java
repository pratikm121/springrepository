package nl.pratik.boot.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import nl.pratik.boot.spring.model.Customer;

@Repository
@Primary			//Use this annotation for confirming which ORM implementation to use. 
public class CustomerDAOJpaImpl implements CustomerDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Customer> getCustomers() {
		
		// create a query  ... sort by last name
		TypedQuery<Customer> theQuery = 
				entityManager.createQuery("from Customer order by lastName",
											Customer.class);
		System.out.println("Insoide JPA");
		// execute query and return the result list
		return theQuery.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		System.out.println("Insoide JPA saved");
		Customer customerdb = entityManager.merge(theCustomer);
		theCustomer.setId(customerdb.getId());
	}

	@Override
	public Customer getCustomer(int theId) {
		// now retrieve/read from database using the primary key and return the result
		return entityManager.find(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		// delete object with primary key
		Query theQuery = 
				entityManager.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);		
		theQuery.executeUpdate();		
	}

}