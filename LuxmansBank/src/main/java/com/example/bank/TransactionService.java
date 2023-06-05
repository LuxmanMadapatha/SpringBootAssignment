package com.example.bank;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  @Autowired
  private TransactionRepo Transrepo;

  @Autowired
  private BankAccountRepo Bankrepo;

  public TransactionService() {
    // TODO Auto-generated constructor stub
  }

  public Transaction deposit(String accountNumber, float amount) {
    try {
      BankAccount bankaccount = Bankrepo.getReferenceById(accountNumber);
      float newBalance = bankaccount.getAccountBalance() + amount;
      bankaccount.setAccountBalance(newBalance);
      Bankrepo.save(bankaccount);
      return saveTransaction(accountNumber, amount);

    } catch (Exception e) {
      e.printStackTrace();

    }
    return null;
  }

  public Transaction withdraw(String accountNumber, float amount) {
    try {
      BankAccount bankaccount = Bankrepo.getReferenceById(accountNumber);
      if (bankaccount.getAccountBalance() >= amount) {
        float newBalance = bankaccount.getAccountBalance() - amount;
        bankaccount.setAccountBalance(newBalance);
        Bankrepo.save(bankaccount);
        return saveTransaction(accountNumber, amount);
      }

    } catch (Exception e) {
      e.printStackTrace();

    }
    return null;
  }


  public List<Transaction> getTransactionHistory(String accountNumber) {
    return Transrepo.findByAccountNumberOrderByTimestampDesc(accountNumber);
  }

  public float balance(String accountNumber) {
    try {
      BankAccount bankaccount = Bankrepo.getReferenceById(accountNumber);
      return bankaccount.getAccountBalance();
    }

    catch (Exception e) {
      e.printStackTrace();

    }
    return 0;

  }

  public Transaction saveTransaction(String accountNumber, float amount) {
    Transaction transaction = new Transaction();
    transaction.setAccountNumber(accountNumber);
    transaction.setAmount(amount);
    transaction.setTimestamp(LocalDateTime.now());
    return Transrepo.save(transaction);


  }
}
