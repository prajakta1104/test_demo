package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Atm_Pojo;

import com.example.demo.dao.I_ATM;


@RestController
public class Atm_Controller 
{

	@Autowired
	private I_ATM iatm;

	//This method is used to withdraw money from account
	@PostMapping (value ="/Atmw/{acno}/{amt}")
	Optional<Atm_Pojo> withdraw (@PathVariable ("acno") int acno,@PathVariable("amt") int amt)
	{
		Optional<Atm_Pojo> atm = iatm.withdraw(acno,amt);
		return atm;
	}

	//This method is used to Deposit Money from account
	@PostMapping (value ="/Atmd/{acno}/{amt}")
	Optional<Atm_Pojo> deposit (@PathVariable ("acno") int acno,@PathVariable("amt") int amt)
	{
		Optional<Atm_Pojo> atm = iatm.deposit(acno,amt);
		return atm;
	}

    //This method is used to create account
	@PostMapping(value="Atm")
	Atm_Pojo createAccount(@RequestBody Atm_Pojo a)
	{
		Atm_Pojo atm=iatm.createAccount(a);
		return atm;
	}
	
	
	//This method is used to Update account
	@PostMapping(value="/Atm/{acno}")
	Atm_Pojo updateDetails(@RequestBody Atm_Pojo a)
	{
		Atm_Pojo atm=iatm.updateDetails(a);
		return atm;

	}

	//This method is used to check account details
	@GetMapping(value="Atm/{acno}")
	public Atm_Pojo checkDetails(@PathVariable("acno") int acno)
	{
		Optional<Atm_Pojo> atm=iatm.checkDetails(acno);
		return atm.isPresent()?atm.get():new Atm_Pojo();
	}

	//This method is used to Check balance of account
	@GetMapping(value = "Atmb/{acno}")
	Atm_Pojo checkBalance(@PathVariable ("acno") int acno)
	{
		Optional<Atm_Pojo> atm = iatm.checkBalance(acno);
		return atm.isPresent()?atm.get():new Atm_Pojo();  

	}
	
	//This method is used to delete account
	@DeleteMapping(value="Atm/{acno}")
	String delete(@PathVariable ("acno") int acno)
	{
		return iatm.deleteAccount(acno);
	}

}
