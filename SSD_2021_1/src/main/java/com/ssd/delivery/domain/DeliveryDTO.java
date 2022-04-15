package com.ssd.delivery.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DeliveryDTO implements Serializable {
 
	/* Private Fields */

	private int deliveryId;
	private String address1;
	private String address2;
	private String username;
	private String serviceDate;
	private int price;
	private int width;
	private int depth;
	private int height;
	private int weight;
	private int loadage;

	public DeliveryDTO() {
		super();
	}
	public DeliveryDTO(String address1, String address2, String username, String serviceDate, int price, int width, int depth, int height, int weight, int loadage) {
		super();
	
		this.address1 = address1;
		this.address2 = address2;
		this.username = username;
		this.serviceDate = serviceDate;
		this.price = price;
		this.width = width;
		this.depth = depth;
		this.height = height;
		this.weight = weight;
		this.loadage = loadage;
	}

	/* JavaBeans Properties */

	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getLoadage() {
		return loadage;
	}
	public void setLoadage(int loadage) {
		this.loadage = loadage;
	}

}
