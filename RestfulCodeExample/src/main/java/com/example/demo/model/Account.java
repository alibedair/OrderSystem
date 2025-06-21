package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private String username;
	private String password;
	private double balance;
	private String email;
	private String phone_Number;
	List<Notification> inbox;

	public String getusername() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public String getpassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString(){
		return username + "::" +balance + "::" + password + "::" + email + "::" + phone_Number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public Account() {
		inbox = new ArrayList<>();
	}

	public List<Notification> getInbox() {
		return inbox;
	}

	public void setInbox(List<Notification> inbox) {
		this.inbox = inbox;
	}
	public void deductBalance(double amount) {
		if (balance >= amount) {
			balance -= amount;
		} else {
			// Handle insufficient funds
			System.out.println("Insufficient funds in the account.");
		}
	}
}
