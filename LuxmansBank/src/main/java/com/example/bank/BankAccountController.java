package com.example.bank;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountController {

  @Autowired
  private BankAccountRepo repo;

  @Autowired
  private BankAccountService bankAccountService;


  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<BankAccount> getBankAccounts() {
    return repo.findAll();

  }

  @RequestMapping(value = "/newaccount", method = RequestMethod.POST)
  public ResponseEntity<BankAccount> newaccount(@RequestBody BankAccount bankaccount) {
    BankAccount newbankaccount = bankAccountService.createAccount(bankaccount);
    return ResponseEntity.status(HttpStatus.CREATED).body(newbankaccount);
  }

}

