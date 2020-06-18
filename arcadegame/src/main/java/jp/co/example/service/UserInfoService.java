package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.UserInfo;

public interface UserInfoService {

	public List<UserInfo> findAll();
	public UserInfo findIdPass(String loginId, String password);
	public void insert(String loginId, String userName, String password);
	public List<UserInfo> findByUserId(Integer userId);
	public List<UserInfo> findByLoginId(String loginId);
	public List<UserInfo> allItem(Integer userId);
	public List<UserInfo> findRanking(Integer gameId);
	public List<UserInfo> playCount(Integer userId, Integer gameId);



}
