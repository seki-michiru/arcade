package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.UserInfo;

public interface UserInfoService {

	public List<UserInfo> findAll();
	public List<UserInfo> findIdPass(String loginId, String password);
	public void insert(String loginId, String userName, String password);
	public List<UserInfo> findByUserId(Integer userId);
	public List<UserInfo> findByLoginId(String loginId);
	public List<UserInfo> allItem(Integer userId);
	public List<UserInfo> findRanking(Integer gameId);
	public List<UserInfo> findMyRanking(Integer gameId, Integer userId);
	public List<UserInfo> higtScoreDate(String userName, Integer gameId);
	public void update(String loginId, String userName, String password, Integer userId);
	public List<UserInfo> findByUserName(String userName);
	public List<UserInfo> findIdUserNamePass(Integer userId, String loginId, String userName);
	public UserInfo getCoin(Integer userId);
	public void subCoin(Integer userId,Integer coin);
	public void plusCoin(Integer userId,Integer coin);
	public void updatelogin_date(String loginId);
	public void buyResult(Integer userId,Integer price,Integer itemId,Integer number);
	public void sellResult(Integer userId,Integer price,Integer itemId,Integer number);
	public void userInsert(String loginId,String userName,String password,Integer itemId);
	public UserInfo findIdIdName(Integer userId, String loginId, String userName);


}
