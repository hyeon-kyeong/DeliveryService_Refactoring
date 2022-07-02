package com.ssd.delivery.controller.chat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.Chat;
import com.ssd.delivery.domain.ChatRoomDTO;
import com.ssd.delivery.domain.ChatRoomJoinDTO;
import com.ssd.delivery.domain.MessageDTO;
import com.ssd.delivery.service.DeliveryImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController {

	@Autowired
	private DeliveryImpl deliveryImpl;
	
	@MessageMapping("/chat")
	@SendTo("/topic/chat")
	public Chat chat(Chat chat) throws Exception {
		
		return new Chat(chat.getSenderUsername(), chat.getContent());

	}


	@RequestMapping("/delivery/chat.do")
	public ModelAndView viewMessageContent(Model model, HttpSession session) throws Exception {
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");

		String username = account.getUsername();
		List<AccountDTO> receivers = deliveryImpl.getUserList();
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("username", username);
		mav.addObject("receiversList", receivers);
		mav.setViewName("chat");

		return mav;
	}
	
	@RequestMapping("/delivery/insertChat.do")
	public void insertChat(MessageDTO chat) {

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String currentDate = dFormat.format(date);
		
		MessageDTO chat2 = new MessageDTO(chat.getSenderUsername(), chat.getReceiverUsername(), chat.getContent(), currentDate);
		
		System.out.println("xxxxxxxxxx");
		System.out.println(chat2.toString());
		deliveryImpl.insertMessage(chat2);
		
	}
	
	@RequestMapping("chatSession.do")
	public String[] userReturn() {
		List<AccountDTO> receivers = deliveryImpl.getUserList();
		String[] username = new String[receivers.size()];

		for (int i = 0; i < username.length; i++) {
			username[i] = receivers.get(i).getUsername();
		}
		
		return username;
	}
	
 
	@RequestMapping("/delivery/createChatRoom.do")
	public ModelAndView createChatRoom(HttpSession session, @RequestParam("receiverUsername") String receiverUsername) throws Exception {
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");

		String username = account.getUsername();
		ModelAndView mav = new ModelAndView();
		List<Integer> roomIdSend = deliveryImpl.getRoomIdByUsername(username);
		List<Integer> roomIdReceive = deliveryImpl.getRoomIdByUsername(receiverUsername);
		
		int roomId = -1;
		if (roomIdSend != null && roomIdReceive != null) {
			for (int s : roomIdSend) {
				for (int r : roomIdReceive) {
					if (s == r) {
						roomId = s;
						break;
					}
				}
			}
		}
		
		if (roomId == -1) {
			roomId = deliveryImpl.createRoomId();

			ChatRoomDTO chatRoom = new ChatRoomDTO(roomId);
			
			ChatRoomJoinDTO chatRoomSend = new ChatRoomJoinDTO(username, roomId);
			ChatRoomJoinDTO chatRoomReceive = new ChatRoomJoinDTO(receiverUsername, roomId);
			
			deliveryImpl.insertChatRoomInfo(chatRoomSend);
			deliveryImpl.insertChatRoomInfo(chatRoomReceive);
		}
		
		mav.addObject("username", username);
		mav.addObject("receiverUsername", receiverUsername);
		mav.addObject("roomId", roomId);
		mav.setViewName("chat");

		return mav;
	}
	
}
