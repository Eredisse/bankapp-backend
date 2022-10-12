package com.bev.bankappbackend.repo;

import com.bev.bankappbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
}
