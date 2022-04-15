package com.ssd.delivery.controller.account;

import java.io.Serializable;

import com.ssd.delivery.domain.AccountDTO;

@SuppressWarnings("serial")
public class AccountForm implements Serializable {
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String languagePreference;
	private int status;
	private String favoriteMall;
	private String carInfo;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLanguagePreference() {
		return languagePreference;
	}
	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFavoriteMall() {
		return favoriteMall;
	}
	public void setFavoriteMall(String favoriteMall) {
		this.favoriteMall = favoriteMall;
	}
	public String getCarInfo() {
		return carInfo;
	}
	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
	
	private AccountDTO account;

	public AccountDTO getAccount() {
		return account;
	}

}
