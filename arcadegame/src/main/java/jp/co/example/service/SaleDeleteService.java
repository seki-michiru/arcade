package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Sales;

public interface SaleDeleteService {
	public List<Sales> findAll(Integer userId);

	public void marketCancel(Integer salesId);

}
