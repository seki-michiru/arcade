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
	public List<UserInfo> findIdPass(String loginId, String password) {

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

	@Override
	public List<UserInfo> allItem(Integer userId) {

		return userInfoDao.allItem(userId);

	}

	@Override
	public List<UserInfo> findRanking(Integer gameId) {

		return userInfoDao.findRanking(gameId);

	}

	@Override
	public List<UserInfo> playCount(Integer userId, Integer gameId) {

		return userInfoDao.playCount(userId, gameId);

	}

	@Override
	public void update(String loginId, String userName, String password, Integer userId) {

		userInfoDao.update(loginId, userName, password, userId);

	}

	@Override
	public List<UserInfo> findByUserName(String userName) {

		return userInfoDao.findByUserName(userName);

	}
	@Override
	public List<UserInfo> findIdUserNamePass(String loginId, String userName, String password) {

		return userInfoDao.findIdUserNamePass(loginId, userName, password);

	}

}
