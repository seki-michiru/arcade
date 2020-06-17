package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.UserInfo;

public interface UserInfoDao {

	public List<UserInfo> findAll();
	public UserInfo findIdPass(Integer roginId, String password);
	public void insert(Integer roginId, String userName, String password);


}
