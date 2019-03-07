package nl.pratik.thymeleaf.jpa.data.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.pratik.thymeleaf.jpa.data.spring.model.Customer;

public interface CustomerJPARepository extends JpaRepository<Customer, Integer> {

	//Just by creating this method Spring Data JPA will create the query for same.
	public List<Customer> findAllByOrderByFirstNameAsc();
}
