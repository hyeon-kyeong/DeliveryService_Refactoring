package com.ssd.delivery.controller.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.ChatDTO;
import com.ssd.delivery.domain.ChatRoomJoinDTO;
import com.ssd.delivery.service.DeliveryImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController {

	@Autowired
	private DeliveryImpl deliveryImpl;
	
	@MessageMapping("/chat/{roomId}")
	@SendTo("/topic/chat/{roomId}")
	public ChatDTO chat(ChatDTO chat) throws Exception {
		return new ChatDTO(chat.getUsername(), chat.getContent(), chat.getChatDate(), chat.getRoomId());
	}
	
	@RequestMapping("/delivery/chat.do/{roomId}")
	public ModelAndView enterChatRoom(Model model, HttpSession session, @RequestParam("receiverUsername")String receiverUsername, @PathVariable("roomId") int roomId) throws Exception {
		
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");
		String senderUsername = account.getUsername();
		
//		List<Integer> roomIdSend = deliveryImpl.getRoomIdByUsername(senderUsername);
//		List<Integer> roomIdReceive = deliveryImpl.getRoomIdByUsername(receiverUsername);
//		
//		int roomId = -1;
//		if (roomIdSend != null && roomIdReceive != null) {
//			for (int s : roomIdSend) {
//				for (int r : roomIdReceive) {
//					if (s == r) {
//						roomId = s;
//						break;
//					}
//				}
//			}
//		}
		System.out.println(roomId);
		List<ChatDTO> chatList = deliveryImpl.getChatListByRoomId(roomId);
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("senderUsername", senderUsername);
		mav.addObject("receiverUsername", receiverUsername);
		mav.addObject("roomId", roomId);
		mav.addObject("chatList", chatList);
		mav.setViewName("chat");

		return mav;
	}
	
	@RequestMapping("/delivery/insertChat.do")
	public void insertChat(ChatDTO chat) {
		
		deliveryImpl.insertChat(chat);
	}

	@RequestMapping("/delivery/createChatRoom.do")
	public String createChatRoom(HttpSession session, @RequestParam("receiverUsername") String receiverUsername) throws Exception {
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
			deliveryImpl.createRoomId();
			
			ChatRoomJoinDTO chatRoomSend = new ChatRoomJoinDTO(username);
			ChatRoomJoinDTO chatRoomReceive = new ChatRoomJoinDTO(receiverUsername);
			
			deliveryImpl.insertChatRoomInfo(chatRoomSend);
			deliveryImpl.insertChatRoomInfo(chatRoomReceive);
			
			roomId = chatRoomSend.getRoomId();
		}

		mav.addObject("username", username);
		mav.addObject("receiverUsername", receiverUsername);
		mav.addObject("roomId", roomId);
		mav.setViewName("chat");

		return "redirect:/delivery/chat.do/" + roomId;
	}
	
	@RequestMapping("/delivery/chatList.do")
	public ModelAndView chatRoomList(HttpSession session) throws Exception {
		AccountDTO account = (AccountDTO)session.getAttribute("userSession");

		String username = account.getUsername();
		ModelAndView mav = new ModelAndView();
		List<Integer> roomId = deliveryImpl.getRoomIdByUsername(username);

		Map<String, Integer> map = new HashMap<>();
		for (int id : roomId) {
			List<ChatRoomJoinDTO> userList = deliveryImpl.getChatUserListByRoomId(id);

			for (ChatRoomJoinDTO user : userList) {
				if (!user.getUsername().equals(username)) {
					map.put(user.getUsername(), id);
				}
			}
		}
		
		mav.addObject("map", map);
		mav.setViewName("chatList");

		return mav;
	}
}
