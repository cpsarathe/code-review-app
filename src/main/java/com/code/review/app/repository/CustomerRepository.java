package com.code.review.app.repository;

import com.code.review.app.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Long customerId);
    void delete(Customer customer);
}
