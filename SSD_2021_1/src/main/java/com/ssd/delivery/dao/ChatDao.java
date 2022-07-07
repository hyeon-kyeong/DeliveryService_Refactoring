package com.ssd.delivery.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.ChatDTO;
import com.ssd.delivery.domain.ChatRoomJoinDTO;

public interface ChatDao {

	void insertChat(ChatDTO chat) throws DataAccessException;
	
	int createRoomId() throws DataAccessException;
	
	void insertChatRoomInfo(ChatRoomJoinDTO chatRoom) throws DataAccessException;
	
	int getRoomId(String username) throws DataAccessException;
	
	String getUsernameByRoomId(int roomId) throws DataAccessException;
	
	List<Integer> getRoomIdByUsername(String username) throws DataAccessException;
	
	List<ChatDTO> getChatListByRoomId(int roomId) throws DataAccessException;

	List<ChatRoomJoinDTO> getChatUserListByRoomId(int roomId) throws DataAccessException;
}
