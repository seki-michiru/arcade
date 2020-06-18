package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ItemDao;
import jp.co.example.entity.Items;
import jp.co.example.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemDao itemDao;

	public List<Items> findAll(){
		return itemDao.findAll();
	}
}