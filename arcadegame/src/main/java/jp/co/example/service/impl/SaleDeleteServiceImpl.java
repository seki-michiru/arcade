package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.SalesDao;
import jp.co.example.entity.Sales;
import jp.co.example.service.SaleDeleteService;

@Service
public class SaleDeleteServiceImpl implements SaleDeleteService {

	@Autowired
	private SalesDao salesDao;

	@Override
	public List<Sales> findAll(Integer userId) {

		return salesDao.findAll(userId);
	}

	@Override
	public void marketCancel(Integer salesId) {
		salesDao.marketCancel(salesId);
	}

}
