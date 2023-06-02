package com.example.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
	
@Autowired
private BankAccountRepo Bankrepo;

public BankAccount createAccount(BankAccount bankaccount) {
	
	Long number = bankaccount.getId();
	String name = bankaccount.getAccountHolderName();
	boolean logic1 = Bankrepo.existsByaccountHolderName(name);
	boolean logic2 = Bankrepo.existsById(number);
	
	if (!logic1 && !logic2) {	
	Bankrepo.save(bankaccount);
	return bankaccount;}	
	
	return null;
}
}
