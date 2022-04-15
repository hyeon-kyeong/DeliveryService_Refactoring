package com.ssd.delivery.dao.mybatis;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.ssd.delivery.dao.FavoriteUserDao;
import com.ssd.delivery.dao.mybatis.mapper.FavoriteUserMapper;
import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.CoPurchasingDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;

@Repository
public class MybatisFavoriteUserDao implements FavoriteUserDao{
	
	@Autowired
	private FavoriteUserMapper favoriteUserMapper;
	
	public void insertFU(FavoriteUserDTO favoriteUser) throws DataAccessException {
		favoriteUserMapper.insertFU(favoriteUser);
	}
	
	public void updateFU(FavoriteUserDTO favoriteUser) throws DataAccessException {
		favoriteUserMapper.updateFU(favoriteUser);
	}
	
	public void deleteFU(String favId) throws DataAccessException {
		favoriteUserMapper.deleteFU(favId);
	}
	
	public List<FavoriteUserDTO> getFUByUsername(String username) throws DataAccessException {
		return favoriteUserMapper.getFUByUsername(username);
	}
	
	public List<FavoriteUserDTO> getFUList() throws DataAccessException {
		return favoriteUserMapper.getFUList();
	}

	@Override
	public void updateTradeCount(String tradeCount, String username, String favUsername) throws DataAccessException {
		favoriteUserMapper.updateTradeCount(tradeCount, username, favUsername);
		
	}

	@Override
	public List<AuctionDTO> getACTradeCount(String favUsername, String username) throws DataAccessException {
		
		return favoriteUserMapper.getACTradeCount(favUsername, username);
	}

	@Override
	public List<CoPurchasingDTO> getCPTradeCount(String favUsername, String username) throws DataAccessException {
		
		return favoriteUserMapper.getCPTradeCount(favUsername, username);
	}
}
