 package com.ssd.delivery.domain;

import java.io.Serializable;
@SuppressWarnings("serial")
public class AccountDTO implements Serializable{
	private String username;
	private String password;
	private String password2;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private int status;
	private String carInfo;
	private String postcode;
	private String address2;
	private String detailAddress;
	private String extraAddress;
	private String salt;

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	
	//기본생성자
	public AccountDTO() {
		super();
	}
	
	//Register 생성자
	public AccountDTO(String username, String password, String email, String firstName, String lastName,
			String address, String phone, int status, String carInfo, String salt) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.carInfo = carInfo;
		this.salt = salt;
	}
	
	
	public AccountDTO(String username, String password, String email, String firstName, String lastName, String address,
			String phone, int status, String carInfo, String postcode,
			String address2, String detailAddress, String extraAddress, String salt) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.carInfo = carInfo;
		this.postcode = postcode;
		this.address2 = address2;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
	}

	//비밀번호 확인 메소드
	public boolean matchPassword(String password) {
		System.out.println(password);
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}

	//사용자 관리자 구분 메소드
	public boolean isManager() {
		if (this.status < 2) {
			return false;
		}
		return true;
	}
	
	//사용자 중복 확인
	public boolean isSameUser(String userid) {
		return this.username.equals(userid);
	}

	//setter & getter
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) { 
		this.detailAddress = detailAddress;
	}

	public String getExtraAddress() {
		return extraAddress;
	}
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCarInfo() {
		return carInfo;
	}
	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
