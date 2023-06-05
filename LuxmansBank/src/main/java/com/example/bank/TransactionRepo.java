package com.example.bank;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
  List<Transaction> findByAccountNumberOrderByTimestampDesc(String accountNumber);
}

