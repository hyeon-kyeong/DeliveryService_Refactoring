package com.ssd.delivery.controller.chat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.Chat;
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
		ModelAndView mav = new ModelAndView();

		mav.addObject("username", username);
		mav.setViewName("chat");

		return mav;
	}
	
	@RequestMapping("/delivery/insertChat.do")
	public void insertChat(MessageDTO chat) {

		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String currentDate = dFormat.format(date);
		
		MessageDTO chat2 = new MessageDTO(chat.getSenderUsername(), chat.getSenderUsername(), chat.getContent(), currentDate);
		
		System.out.println("xxxxxxxxxx");
		System.out.println(chat2.toString());
		deliveryImpl.insertMessage(chat2);
		
	}
}