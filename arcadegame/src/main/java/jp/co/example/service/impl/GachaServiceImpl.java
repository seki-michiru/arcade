package jp.co.example.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ItemDao;
import jp.co.example.dao.ItemStocksDao;
import jp.co.example.dao.UserInfoDao;
import jp.co.example.entity.Items;
import jp.co.example.service.GachaService;

@Service
public class GachaServiceImpl implements GachaService {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ItemStocksDao itemStocksDao;
	@Autowired
	private UserInfoDao userInfoDao;

	public int Random() {
		Random rand = new Random();
	    int num = rand.nextInt(10) + 1;
	    System.out.println(num);
		return num;
	}

	@Override
	public List<Items> gachaItem(Integer randomNumber) {
		List<Items> list  = itemDao.gachaItem(randomNumber);

		return list;
	}

	@Override
	public void itemCollect(Integer userId, Integer itemId) {
		itemStocksDao.itemCollect(userId,itemId);
	}

	@Override
	public void coinWast(Integer userId) {
		userInfoDao.coinWast(userId);
	}
}