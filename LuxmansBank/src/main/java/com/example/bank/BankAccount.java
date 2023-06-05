package com.example.bank;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  String accountHolderName;
  String accountType;
  float accountBalance;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  String accountNumber;

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public float getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(float accountBalance) {
    this.accountBalance = accountBalance;
  }



  public BankAccount() {
    super();
  }



  public BankAccount(Long id, String accountNumber, String accountHolderName, String accountType,
      float accountBalance) {
    super();
    this.id = id;
    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.accountType = accountType;
    this.accountBalance = accountBalance;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountHolderName, accountNumber, accountType);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BankAccount other = (BankAccount) obj;
    return Objects.equals(accountHolderName, other.accountHolderName)
        && Objects.equals(accountNumber, other.accountNumber)
        && Objects.equals(accountType, other.accountType);
  }

}
