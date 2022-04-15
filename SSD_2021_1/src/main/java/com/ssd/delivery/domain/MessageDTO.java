package com.ssd.delivery.domain;
import java.io.Serializable;

@SuppressWarnings("serial")
public class MessageDTO implements Serializable
{
	private int dmNo;
	private String senderUsername;
	private String receiverUsername;
	private String content;
	private String messageDate; //String으로 변경 가능
	
	//기본 생성자
	public MessageDTO() {
		super();
	}
	
	public MessageDTO(String senderUsername, String receiverUsername, String content, String messageDate) {
		super();
		this.senderUsername = senderUsername;
		this.receiverUsername = receiverUsername;
		this.content = content; 
		this.messageDate = messageDate;
	}
	
	//getter & setter
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
	public int getDmNo() {
		return dmNo;
	}
	public void setDmNo(int dmNo) {
		this.dmNo = dmNo;
	}

}
