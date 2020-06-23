package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ItemStocksDao;
import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Items;
import jp.co.example.service.ItemStocksService;

@Service
public class ItemStocksServiceimpl implements ItemStocksService {

	@Autowired
	private ItemStocksDao itemStocksDao;

	public void plusStock(Integer userId,Integer itemId,Integer number) {
		itemStocksDao.plusStock(userId,itemId,number);
	}

	public List<ItemStocks> findStockAll(Integer userId){
		return itemStocksDao.findStockAll(userId);
	}

	public void minusStock(Integer userId,Integer itemId,Integer number) {
		itemStocksDao.minusStock(userId,itemId,number);
	}
	public List<Items> getStockItem(Integer userId,Integer gameId){
		return itemStocksDao.getStockItem(userId,gameId);
	}

	public void itemInsert(Integer userId, Integer itemId) {
		itemStocksDao.itemInsert(userId, itemId);
	}

}