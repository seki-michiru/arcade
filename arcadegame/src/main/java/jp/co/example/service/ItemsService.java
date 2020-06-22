package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Items;

public interface ItemsService{

	public List<Items> findAll();

	public List<Items> findItemName(Integer itemId);
}