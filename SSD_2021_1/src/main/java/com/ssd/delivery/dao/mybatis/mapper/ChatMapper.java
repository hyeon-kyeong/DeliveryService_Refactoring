package com.ssd.delivery.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssd.delivery.domain.ChatDTO;
import com.ssd.delivery.domain.ChatRoomJoinDTO;

@Mapper
public interface ChatMapper {

	void insertChat(ChatDTO chat);
	
	int createRoomId();
	
	void insertChatRoomInfo(ChatRoomJoinDTO chatRoom);
	
	int getRoomId(String username);
	
	String getUsernameByRoomId(int roomId);
	
	List<Integer> getRoomIdByUsername(@Param("username")String username);
	
	List<ChatDTO> getChatListByRoomId(@Param("roomId")int roomId);
}
