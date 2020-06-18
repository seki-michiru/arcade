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
	public UserInfo findIdPass(String loginId, String password) {

		return userInfoDao.findIdPass(loginId, password);

	}

	@Override
	public void insert(String loginId, String userName, String password) {

		userInfoDao.insert(loginId, userName, password);

	}

	@Override
	public List<UserInfo> findByUserId(Integer userId) {

		return userInfoDao.findByUserId(userId);

	}

	@Override
	public List<UserInfo> findByLoginId(String loginId) {

		return userInfoDao.findByLoginId(loginId);

	}


}
