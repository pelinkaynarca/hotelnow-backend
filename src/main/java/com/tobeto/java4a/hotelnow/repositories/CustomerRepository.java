package com.tobeto.java4a.hotelnow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tobeto.java4a.hotelnow.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select c from Customer c where c.country.id = :nationalityId")
	List<Customer> findByNationalityId(@Param("nationalityId") int nationalityId);

}
