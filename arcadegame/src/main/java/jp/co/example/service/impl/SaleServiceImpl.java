package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ItemDao;
import jp.co.example.entity.Items;
import jp.co.example.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private ItemDao itemDao;

	public List<Items> findAll() {
		return itemDao.findAll();
	}

	@Override
	public List<Items> havingItem(Integer userId) {
		return itemDao.havingItem(userId);
	}
}
