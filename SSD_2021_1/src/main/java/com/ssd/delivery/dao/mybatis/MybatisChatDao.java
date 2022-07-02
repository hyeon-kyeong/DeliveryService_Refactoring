package com.ssd.delivery.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.delivery.dao.mybatis.mapper.ChatMapper;
import com.ssd.delivery.domain.ChatDTO;
import com.ssd.delivery.domain.ChatRoomJoinDTO;

@Repository
public class MybatisChatDao {

	@Autowired
	private ChatMapper chatMapper;
	
	public void insertChat(ChatDTO chat) throws DataAccessException {
		chatMapper.insertChat(chat);
	}
	
	public int createRoomId() throws DataAccessException {
		return chatMapper.createRoomId();
	}
	
	public void insertChatRoomInfo(ChatRoomJoinDTO chatRoom) throws DataAccessException {
		chatMapper.insertChatRoomInfo(chatRoom);
	}
	
	public int getRoomId(String username) throws DataAccessException {
		return chatMapper.getRoomId(username);
	}
	
	public String getUsernameByRoomId(int roomId) throws DataAccessException {
		return chatMapper.getUsernameByRoomId(roomId);
	}
	
	public List<Integer> getRoomIdByUsername(String username) throws DataAccessException{
		return chatMapper.getRoomIdByUsername(username);
	}
	
	public List<ChatDTO> getChatListByRoomId(int roomId) throws DataAccessException {
		return chatMapper.getChatListByRoomId(roomId);
	}
}
