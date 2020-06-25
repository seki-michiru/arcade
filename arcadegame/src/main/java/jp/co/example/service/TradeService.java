package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Sales;

public interface TradeService {

	List<Sales> marketTrade(Integer userId);

	void itemChange(Integer saleId, Integer userId);

	List<ItemStocks> tradeCheck(Integer saleId, Integer userId);

	public void trade(Integer saleId,Integer userId);

}
