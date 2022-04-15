package com.ssd.delivery.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.CoPurchasingDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;

@Mapper
public interface FavoriteUserMapper {

	void insertFU(FavoriteUserDTO favoriteUser);

	void updateFU(FavoriteUserDTO favoriteUser);

	void updateTradeCount(String tradeCount, String username, String favUsername);

	void deleteFU(String favId);

	List<FavoriteUserDTO> getFUByUsername(String username);

	List<FavoriteUserDTO> getFUList();

	List<AuctionDTO> getACTradeCount(String favUsername, String username);

	List<CoPurchasingDTO> getCPTradeCount(String favUsername, String username);
}
