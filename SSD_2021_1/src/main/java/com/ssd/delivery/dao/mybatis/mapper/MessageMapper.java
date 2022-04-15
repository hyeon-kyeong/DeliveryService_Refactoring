package com.ssd.delivery.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssd.delivery.domain.MessageDTO;
@Mapper
public interface MessageMapper {
	
	void insertMessage(MessageDTO message);
	
	void updateMessage(MessageDTO message);
	
	void deleteMessage(String username);
	
	List<MessageDTO> getMessageListByUsername(@Param("username")String username);
	
	List<MessageDTO> getMessageListByReceiverUsername(@Param("receiver")String receiver);
	
	List<MessageDTO> getMessageContentByUsername(@Param("username")String sender, @Param("receiverUsername")String receiver);
	
	List<MessageDTO> getMessageContentByReceiverUsername(@Param("receiverUsername")String sender, @Param("username")String receiver);
	
	List<MessageDTO> getMessageList();
}
