package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.UserInfoDao;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public List<UserInfo> findAll() {

		return userInfoDao.findAll();

	}

	@Override
	public UserInfo findIdPass(String roginId, String password) {

		return userInfoDao.findIdPass(roginId, password);

	}

	@Override
	public void insert(String roginId, String userName, String password) {

		userInfoDao.insert(roginId, userName, password);

	}


}
