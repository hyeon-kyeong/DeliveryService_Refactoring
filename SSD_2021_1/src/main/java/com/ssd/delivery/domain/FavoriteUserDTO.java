package com.ssd.delivery.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FavoriteUserDTO implements Serializable {
	
	String username;
	String favoriteUsername;
	int tradeCount;
	
	public FavoriteUserDTO() {}	
	
	public FavoriteUserDTO(String username) {
		super();
		this.username = username;
	}
	
	public FavoriteUserDTO(String username, String favoriteUsername, int tradeCount) {
		super();
		this.username= username;
		this.favoriteUsername = favoriteUsername;
		this.tradeCount = tradeCount;
	}

	public FavoriteUserDTO(String username, String favoriteUsername) {
		super();
		this.username = username;
		this.favoriteUsername = favoriteUsername;
	}

	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getFavoriteUsername() {
		return favoriteUsername;
	}

	public void setFavoriteUsername(String favoriteUsername) {
		this.favoriteUsername = favoriteUsername;
	}

	public int getTradeCount() {
		return tradeCount;
	}

	public void setTradeCount(int tradeCount) {
		this.tradeCount = tradeCount;
	}
	
}
