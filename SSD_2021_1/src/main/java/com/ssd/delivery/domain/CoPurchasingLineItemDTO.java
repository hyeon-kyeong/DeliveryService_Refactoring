package com.ssd.delivery.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CoPurchasingLineItemDTO implements Serializable {
	
	private int linenum;
	private int coPurchasingId;
	private String username;

	public CoPurchasingLineItemDTO() {
		super();
	}

	public CoPurchasingLineItemDTO(int coPurchasingId, String username) {
		super();
		this.coPurchasingId = coPurchasingId;
		this.username = username;
	}

	public CoPurchasingLineItemDTO(String username) {
		super();
		this.username = username;
	}

	public CoPurchasingLineItemDTO(int linenum, int coPurchasingId, String username) {
		super();
		this.linenum = linenum;
		this.coPurchasingId = coPurchasingId;
		this.username = username;
	}

	public int getDeliveryId() {
		return linenum;
	}



	public void setDeliveryId(int deliveryId) {
		this.linenum = deliveryId;
	}



	public int getCoPurchasingId() {
		return coPurchasingId;
	}



	public void setCoPurchasingId(int coPurchasingId) {
		this.coPurchasingId = coPurchasingId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}
	
}
