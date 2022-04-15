package com.ssd.delivery.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuctionLineItemDTO implements Serializable{
	private int ACLineId;
	private String username;
	private String joinDate;
	private int joinPrice;
	private int auctionId;

	public AuctionLineItemDTO() {
		super();
	}
	
	public AuctionLineItemDTO(int aCLineId, String username, String joinDate, int joinPrice, int auctionId) {
		super();
		ACLineId = aCLineId;
		this.username = username;
		this.joinDate = joinDate;
		this.joinPrice = joinPrice;
		this.auctionId = auctionId;
	}
	
	public int getACLineId() {
		return ACLineId;
	}
	public void setACLineId(int aCLineId) {
		ACLineId = aCLineId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public int getJoinPrice() {
		return joinPrice;
	}
	public void setJoinPrice(int joinPrice) {
		this.joinPrice = joinPrice;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

}
