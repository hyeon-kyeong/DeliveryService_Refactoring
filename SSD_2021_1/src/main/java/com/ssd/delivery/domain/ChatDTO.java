package com.ssd.delivery.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class ChatDTO implements Serializable {

	private int chatId;
	private String username;
	private String content;
	private String chatDate;
	private int roomId;

	// 기본 생성자
	public ChatDTO() {
		super();
	}
	
	public ChatDTO(String username, String content, String chatDate, int roomId) {
		super();
		this.username = username;
		this.content = content;
		this.chatDate = chatDate;
		this.roomId = roomId;
	}
	
//	public ChatDTO(int chatId, String username, String content, String chatDate,
//			int roomId) {
//		super();
//		this.chatId = chatId;
//		this.username = username;
//		this.content = content;
//		this.chatDate = chatDate;
//		this.roomId = roomId;
//	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChatDate() {
		return chatDate;
	}

	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "ChatDTO [chatId=" + chatId + ", username=" + username
				+ ", content=" + content + ", chatDate=" + chatDate
				+ ", roomId=" + roomId + "]";
	}

}
