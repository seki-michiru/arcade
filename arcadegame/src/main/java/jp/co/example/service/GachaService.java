package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Items;

public interface GachaService {


		public int Random();

		public List<Items> gachaItem(Integer randomNumber);

		public void itemCollect(Integer userId,Integer itemId);

		public void coinWast(Integer userId);
}
