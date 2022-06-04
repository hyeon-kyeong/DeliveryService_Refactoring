package com.ssd.delivery.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.delivery.dao.AccountDao;
import com.ssd.delivery.dao.mybatis.mapper.AccountMapper;
import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;

@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public void insertAccount(AccountDTO account) throws DataAccessException {
		
		accountMapper.insertAccount(account);
	}

	@Override
	public void deleteAccount(String username) throws DataAccessException {
		
		accountMapper.deleteAccount(username);
	}

	@Override
	public List<AccountDTO> getUserListByAuctionId(String auctionId) throws DataAccessException {
		
		return accountMapper.getUserListByAuctionId(auctionId);
	}

	@Override
	public List<AccountDTO> getUserListByCPId(String CPId) throws DataAccessException {
		
		return accountMapper.getUserListByCPId(CPId);
	}

	@Override
	public boolean existingUser(String username) throws DataAccessException {
		
		return accountMapper.existingUser(username);
	}

	@Override
	public List<FavoriteUserDTO> getFavoriteUserList(String username) throws DataAccessException {
		
		return accountMapper.getFavoriteUserList(username);
	}

	@Override
	public AccountDTO findUser(String username) throws DataAccessException {
		
		return accountMapper.getUser(username);
	}

	@Override
	public void updateAccount(AccountDTO account) throws DataAccessException {
		
		accountMapper.updateAccount(account);
	}

	@Override
	public List<AccountDTO> getUserList() throws DataAccessException {
		
		return accountMapper.getUserList();
	}
	
	@Override
	public String getSaltByUsername(String username) {
		
		return accountMapper.getSaltByUsername(username);
	}

}