package com.ssd.delivery.domain;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ChatRoomJoinDTO implements Serializable {

	private int joinId;
	private String username;
	private int roomId;
	
	public ChatRoomJoinDTO(String username) {
		super();
		this.username = username;
	}
	
	public ChatRoomJoinDTO(String username, int roomId) {
		super();
		this.username = username;
		this.roomId = roomId;
	}

	public int getJoinId() {
		return joinId;
	}

	public void setJoinId(int joinId) {
		this.joinId = joinId;
	}

	public String getUsername() {
		return username;
	}

	public void set(String username) {
		this.username = username;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "ChatRoomJoinDTO [joinId=" + joinId + ", username=" + username
				+ ", roomId=" + roomId + "]";
	}

}
