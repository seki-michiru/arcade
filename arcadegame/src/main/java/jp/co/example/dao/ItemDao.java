package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Items;

public interface ItemDao{

	public List<Items> findAll();

	public List<Items> gachaItem(int itemId);
}