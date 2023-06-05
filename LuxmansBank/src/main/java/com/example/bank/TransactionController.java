package com.example.bank;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/transaction/")
public class TransactionController {


  @Autowired
  private TransactionRepo Transrepo;

  @Autowired
  private final TransactionService transactionService = new TransactionService();

  @RequestMapping(value = "/deposit/{amount}", method = RequestMethod.POST)
  public ResponseEntity<Transaction> deposit(@RequestBody BankAccount bankaccount,
      @PathVariable("amount") float amount) {

    String accountNumber = bankaccount.getAccountNumber();
    if (amount > 0) {
      Transaction transaction = transactionService.deposit(accountNumber, amount);
      return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    } else {
      return null;
    }

  }


  @RequestMapping(value = "/withdraw/{amount}", method = RequestMethod.POST)
  public ResponseEntity<Transaction> withdraw(@RequestBody BankAccount bankaccount,
      @PathVariable("amount") float amount) {

    String accountNumber = bankaccount.getAccountNumber();
    if (amount > 0) {
      Transaction transaction = transactionService.withdraw(accountNumber, amount);
      return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    } else {
      return null;
    }

  }

  @RequestMapping(value = "/{accountNumber}/balance", method = RequestMethod.POST)
  public ResponseEntity<Float> balance(@PathVariable String accountNumber) {
    float balance = transactionService.balance(accountNumber);
    return ResponseEntity.ok(balance);
  }


  @RequestMapping(value = "/{accountNumber}/history", method = RequestMethod.POST)
  public ResponseEntity<List<Transaction>> getTransactionHistory(
      @PathVariable String accountNumber) {
    List<Transaction> history = transactionService.getTransactionHistory(accountNumber);
    return ResponseEntity.ok(history);
  }

}
