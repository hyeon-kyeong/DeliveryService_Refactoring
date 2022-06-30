package com.ssd.delivery.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.delivery.dao.mybatis.mapper.ChatMapper;
import com.ssd.delivery.domain.ChatDTO;

@Repository
public class MybatisChatDao {

	@Autowired
	private ChatMapper chatMapper;
	
	public void insertChat(ChatDTO chat) throws DataAccessException {
		chatMapper.insertChat(chat);
	}
	
	public List<Integer> getRoomIdByUsername(String username) throws DataAccessException{
		return chatMapper.getRoomIdByUsername(username);
	}
	
	public List<ChatDTO> getChatListByRoomId(int roomId) throws DataAccessException {
		return chatMapper.getChatListByRoomId(roomId);
	}
}
