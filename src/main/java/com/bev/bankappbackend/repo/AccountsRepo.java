package com.bev.bankappbackend.repo;

import com.bev.bankappbackend.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts, Long> {

    Accounts findByCustomerId(int customerId);

}
