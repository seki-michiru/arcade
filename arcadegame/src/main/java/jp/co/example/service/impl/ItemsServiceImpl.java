package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ItemsDao;
import jp.co.example.entity.Items;
import jp.co.example.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsDao itemsDao;

	public List<Items> findAll(){
		return itemsDao.findAll();
	}
}