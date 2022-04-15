package com.ssd.delivery.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CoPurchasingDTO implements Serializable {

	/* Private Fields */

	private int coPurchasingId;
	private int unitCost;
	private int price;
	private String username;
	private int maxNumbeOfPurchaser;
	private int deliveryId;
	private String note;
	private int flag;
	private int flag2;

	public CoPurchasingDTO() {
		super();
	}
	
	public CoPurchasingDTO(int coPurchasingId, int unitCost, int price, String username, int maxNumberofPurchaser,
			int delivery, String note) {
		super();
		this.coPurchasingId = coPurchasingId;
		this.unitCost = unitCost;
		this.price = price;
		this.username = username;
		this.maxNumbeOfPurchaser = maxNumberofPurchaser;
		this.deliveryId = delivery;
		this.note = note;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	//update 생성자
	public CoPurchasingDTO(int unitCost, int price, int maxNumberofPurchaser, int delivery, String note) {
		super();
		this.unitCost = unitCost;
		this.price = price;
		this.maxNumbeOfPurchaser = maxNumberofPurchaser;
		this.deliveryId = delivery;
		this.note = note;
	}

	public int getCoPurchasingId() {
		return coPurchasingId;
	}
	
	public void setCoPurchasingId(int coPurchasingId) {
		this.coPurchasingId = coPurchasingId;
	}
	public int getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMaxNumberOfPurchaser() {
		return maxNumbeOfPurchaser;
	}
	public void setMaxNumberOfPurchaser(int maxNumberofPurchaser) {
		this.maxNumbeOfPurchaser = maxNumberofPurchaser;
	}
	public int getDelivery() {
		return deliveryId;
	}
	public void setDelivery(int delivery) {
		this.deliveryId = delivery;
	}
	
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getFlag2() {
		return flag2;
	}

	public void setFlag2(int flag2) {
		this.flag2 = flag2;
	}

}