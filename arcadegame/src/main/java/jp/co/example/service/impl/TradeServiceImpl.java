package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.ItemStocksDao;
import jp.co.example.dao.SalesDao;
import jp.co.example.dao.TradesDao;
import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Sales;
import jp.co.example.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private SalesDao salesDao;

	@Autowired
	private ItemStocksDao itemStocksDao;

	@Autowired
	private TradesDao tradesDao;

	@Override
	public List<Sales> marketTrade(Integer userId) {

		return salesDao.marketTrade(userId);
	}

	@Transactional
	public void trade(Integer saleId, Integer userId) {
		tradeSuccess(saleId);
		itemChange(saleId, userId);
		marketLog(saleId, userId);
	}

	private void tradeSuccess(Integer saleId) {
		salesDao.tradeSuccess(saleId);

	}

	@Override
	@Transactional
	public void itemChange(Integer saleId, Integer userId) {
		itemStocksDao.itemChange(saleId, userId);

	}

	private void marketLog(Integer saleId, Integer userId) {
		tradesDao.marketLog(saleId, userId);

	}

	@Override
	public List<ItemStocks> tradeCheck(Integer saleId, Integer userId) {
		return itemStocksDao.tradeCheck(saleId, userId);

	}

}
