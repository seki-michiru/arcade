package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Items;

public interface ItemsDao{

	public List<Items> findAll();

	public List<Items> gachaItem(int itemId);
}