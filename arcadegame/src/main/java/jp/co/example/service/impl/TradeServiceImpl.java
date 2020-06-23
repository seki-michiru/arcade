package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ItemStocksDao;
import jp.co.example.dao.SalesDao;
import jp.co.example.dao.TradesDao;
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

	@Override
	public void tradeSuccess(Integer userId) {
		salesDao.tradeSuccess(userId);

	}

	@Override
	public void itemChange(Integer saleId, Integer userId) {
		itemStocksDao.itemChange(saleId,userId);

	}

	@Override
	public void marketLog(Integer saleId, Integer userId) {
		tradesDao.marketLog(saleId,userId);

	}

}
