package com.ssd.delivery.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatDTO implements Serializable{

	private int dmNo;
	private String senderUsername;
	private String receiverUsername;
	private String content;
	private String messageDate; //String으로 변경 가능
	

}
