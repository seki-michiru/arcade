package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Items;

public interface ItemDao{

	public List<Items> findAll();

	public List<Items> gachaItem(Integer itemId);

	public List<Items> findItemName(Integer itemId);

	public List<Items> havingItem(Integer userId);

	public List<Items> itemAll();

	public Items getItemNameEffect(Integer itemId);
}