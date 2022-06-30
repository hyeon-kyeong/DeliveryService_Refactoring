package com.ssd.delivery.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssd.delivery.domain.ChatDTO;

@Mapper
public interface ChatMapper {

	void insertChat(ChatDTO chat);
	
	List<Integer> getRoomIdByUsername(@Param("username")String username);
	
	List<ChatDTO> getChatListByRoomId(@Param("roomId")int roomId);
}
