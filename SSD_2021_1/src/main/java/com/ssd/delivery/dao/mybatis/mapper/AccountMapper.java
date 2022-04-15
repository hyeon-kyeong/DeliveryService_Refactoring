/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.ssd.delivery.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssd.delivery.domain.AccountDTO;
import com.ssd.delivery.domain.FavoriteUserDTO;
@Mapper
public interface AccountMapper {

	void insertAccount(AccountDTO account);
	
	void updateAccount(AccountDTO account);
	
	void deleteAccount(String username);
	
	List<AccountDTO> getUserListByAuctionId(String auctionId);
	
	List<AccountDTO> getUserListByUsername(String username);
	
	List<AccountDTO> getUserListByBidderId(String bidderId);
	
	List<AccountDTO> getUserListByCPId(String CPId);
	
	List<AccountDTO> getUserList();
	
	boolean existingUser(String username);
	
	List<FavoriteUserDTO> getFavoriteUserList(String username);
	
	AccountDTO getUser(String username);

}
