package com.ssd.delivery.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.ChatDTO;

public interface ChatDao {

	void insertChat(ChatDTO chat) throws DataAccessException;
	
	List<Integer> getRoomIdByUsername(String username) throws DataAccessException;
	
	List<ChatDTO> getChatListByRoomId(int roomId) throws DataAccessException;

}
