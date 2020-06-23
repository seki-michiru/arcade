package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Items;

public interface SaleService {
	public List<Items> findAll();

	public List<Items> havingItem(Integer userId);

	public void marketOpen(Integer userId, Integer giveItem, Integer takeItem);


}
