package com.example.bank;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, String> {

  boolean existsById(Long number);

  boolean existsByaccountHolderName(String name);

}
