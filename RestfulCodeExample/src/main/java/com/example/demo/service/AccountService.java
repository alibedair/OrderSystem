package com.example.demo.service;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.example.demo.model.Account;

/**
 *
 * @author 
 */
public interface AccountService {

	public Boolean addAccount(Account p);
	
	public Boolean deleteAccount(String username);
	
	public Account getAccount(String username);
	public void updateAcccount(Account account);

}
