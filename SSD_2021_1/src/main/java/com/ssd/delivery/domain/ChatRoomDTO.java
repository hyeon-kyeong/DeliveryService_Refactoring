package com.ssd.delivery.domain;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ChatRoomDTO implements Serializable {

	private static int roomId;

	public ChatRoomDTO() {
		super();
	}
	
	public ChatRoomDTO(int roomId) {
		super();
		this.roomId = roomId;
	}

	public static int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

}
