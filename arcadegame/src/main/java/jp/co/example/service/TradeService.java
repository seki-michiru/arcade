package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Sales;

public interface TradeService {

	List<Sales> marketTrade(Integer userId);

	void tradeSuccess(Integer saleId);

	void itemChange(Integer saleId, Integer userId);

	void marketLog(Integer saleId, Integer userId);

	List<ItemStocks> tradeCheck(Integer saleId, Integer userId);



}
