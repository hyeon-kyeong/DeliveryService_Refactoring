package com.ssd.delivery.service;

import java.util.Date;
import java.util.List;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.AuctionLineItemDTO;
import com.ssd.delivery.domain.ChatDTO;
import com.ssd.delivery.domain.ChatRoomJoinDTO;
import com.ssd.delivery.domain.CoPurchasingDTO;
import com.ssd.delivery.domain.CoPurchasingLineItemDTO;
import com.ssd.delivery.domain.DeliveryDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;
import com.ssd.delivery.domain.MessageDTO;

public interface DeliveryFacade {

	// Account
	void insertAccount(AccountDTO accountDTO);

	void updateAccount(AccountDTO account);

	void deleteAccount(String username);

	List<AccountDTO> getUserListByAuctionId(String auctionId);

	List<AccountDTO> getUserListByCPId(String CPId);

	boolean existingUser(String username);

	List<FavoriteUserDTO> getFavoriteUserList(String username);

	List<AccountDTO> getUserList();

	AccountDTO findUser(String username);
	
	String getSaltByUsername(String username);

	// Auction
	void insertAuction(AuctionDTO auction);

	void updateAuction(AuctionDTO auction);

	void updateCurrentPriceAuction(int currentPrice, int auctionId);

	void deleteAuction(int auctionId);

	AuctionDTO getAuctionById(int auctionId);

	AuctionDTO getAuctionByDeliveryId(int deliveryId);
	
	List<AuctionDTO> getAuctionByUsername(String username);

	List<AuctionDTO> getAuctionList();

	void testScheduler(int deliveryId, Date closingTime);
	
	AuctionDTO getAuctionIdByUsername(String username);

	// CoPurchasing
	void insertCP(CoPurchasingDTO CP);

	void updateCP(CoPurchasingDTO CP);

	void deleteCP(int cpId);
	
	CoPurchasingDTO getCPIdByUsername(String username);

	List<CoPurchasingDTO> getCPList();

	CoPurchasingDTO getCPById(int CPId);
	
	CoPurchasingDTO getCPByDeliveryId(int deliveryId);

	List<CoPurchasingDTO> getCPListByUsername(String username);

	List<CoPurchasingDTO> isExistingCPAC();
	
	// Delivery
	void insertDelivery(DeliveryDTO delivery);

	void updateDelivery(DeliveryDTO delivery);

	void deleteDelivery(int deliveryId);

	DeliveryDTO getDeliveryIdByUsername(String username);
	
	DeliveryDTO getDeliveryById(int deliveryId);

	List<DeliveryDTO> getDeliveryByUsername(String username);

	List<DeliveryDTO> getDeliveryList();

	List<DeliveryDTO> isExistingCP();

	List<DeliveryDTO> isExistingAC();

	// FavoriteUser
	void insertFU(FavoriteUserDTO favoriteUser);

	void updateFU(FavoriteUserDTO favoriteUser);

	void deleteFU(String username);

	void updateTradeCount(String tradeCount, String username, String favUsername);

	List<FavoriteUserDTO> getFUByUsername(String username);

	List<FavoriteUserDTO> getFUList();

	List<AuctionDTO> getACTradeCount(String favUsername, String username);

	List<CoPurchasingDTO> getCPTradeCount(String favUsername, String username);


	// Message
	void insertMessage(MessageDTO message);

	void updateMessage(MessageDTO message);

	void deleteMessage(String username);

	List<MessageDTO> getMessageListByUsername(String username);

	List<MessageDTO> getMessageListByReceiverUsername(String receiver);

	List<MessageDTO> getMessageContentByUsername(String sender, String receiver);

	List<MessageDTO> getMessageContentByReceiverUsername(String sender, String receiver);

	List<MessageDTO> getMessageList();
	
	
	//Chat
	void insertChat(ChatDTO chat);
	
	int createRoomId();
	
	void insertChatRoomInfo(ChatRoomJoinDTO chatRoom);

	int getRoomId(String username);
	
	String getUsernameByRoomId(int roomId);
	
	List<Integer> getRoomIdByUsername(String username);
	
	List<ChatDTO> getChatListByRoomId(int roomId);
	
	List<ChatRoomJoinDTO> getChatUserListByRoomId(int roomId);
	
	
	// CP lineitem
	List<CoPurchasingLineItemDTO> getCPLineItemsByCPId(int cpId);

	void insertCPLineItem(CoPurchasingLineItemDTO lineItem);

	void insertCPLineItem2(CoPurchasingLineItemDTO lineItem);

	void deleteCPLineItem(int cpId);
	
	void deleteCPLineItemByUsername(String username);
	
	int CPLineItemCount(int coPurchasingId);
	 

	// AC lineitem
	List<AuctionLineItemDTO> getACLineItemsByACId(int acId);

	void insertACLineItem(AuctionLineItemDTO lineItem);

	void deleteACLineItemByUsername(String username);
	
	void deleteACLineItem(int acId);
}
