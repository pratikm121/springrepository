package nl.pratik.boot.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.pratik.boot.spring.model.Customer;

public interface CustomerJPARepository extends JpaRepository<Customer, Integer> {

}
