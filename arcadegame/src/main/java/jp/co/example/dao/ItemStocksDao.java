package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Items;

public interface ItemStocksDao {

	public void itemCollect(Integer userId, Integer itemId);

	//付けたし
	public void plusStock(Integer userId,Integer itemId,Integer number);
	//つけたし
	public List<ItemStocks> findStockAll(Integer userId);
	public void minusStock(Integer userId,Integer itemId,Integer number);
	public List<Items> getStockItem(Integer userId,Integer gameId);

	public void itemChange(Integer saleId, Integer userId);
	public void itemInsert(Integer userId, Integer itemId);

	public void itemWast(Integer userId, Integer giveItem);
}