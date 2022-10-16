package com.bev.bankappbackend.repo;

import com.bev.bankappbackend.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepo extends JpaRepository<Cards, Long> {

    List<Cards> findByCustomerId(int customerId);

}
