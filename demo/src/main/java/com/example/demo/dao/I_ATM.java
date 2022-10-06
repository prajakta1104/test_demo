package com.example.demo.dao;

import java.util.Optional;

import com.example.demo.entity.Atm_Pojo;

public interface I_ATM
{
	
	Optional<Atm_Pojo> withdraw(int acno,int atm);//update
	
	Optional<Atm_Pojo> deposit(int acno,int atm);//update
	
	Optional<Atm_Pojo> checkBalance(int accno);//get
	
	Optional<Atm_Pojo> checkDetails(int accno);//get
	
	Atm_Pojo updateDetails(Atm_Pojo a);//update
	
	Atm_Pojo createAccount(Atm_Pojo a);//post
	
	String deleteAccount(int acno);//delete
	
}