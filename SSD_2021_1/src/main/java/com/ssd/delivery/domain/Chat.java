package com.ssd.delivery.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Chat {
	
//	private String username;
//	private String message;
//
//
//	public Chat(String username, String message) {
//		this.username = username;
//		this.message = message;
//	}

	
	private int dmNo;
	private String senderUsername;
	private String receiverUsername;
	private String content;
	private String messageDate; //String으로 변경 가능
	
	
	public Chat(String senderUsername, String content) {
		// TODO Auto-generated constructor stub
		this.senderUsername = senderUsername;
		this.content = content;
	}
	public int getDmNo() {
		return dmNo;
	}
	public void setDmNo(int dmNo) {
		this.dmNo = dmNo;
	}
	public String getSenderUsername() {
		return senderUsername;
	}
	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}
	public String getReceiverUsername() {
		return receiverUsername;
	}
	public void setReceiverUsername(String receiverUsername) {
		this.receiverUsername = receiverUsername;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	@Override
	public String toString() {
		return "Chat [name=" + senderUsername + ", message=" + content + "]";
	}
	
	

}
