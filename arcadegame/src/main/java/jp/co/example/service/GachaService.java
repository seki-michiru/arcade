package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Items;
import jp.co.example.entity.UserInfo;

public interface GachaService {


		public int Random();

		public List<Items> gachaItem(Integer randomNumber);

		public void itemCollect(Integer userId,Integer itemId);

		public void coinWast(Integer userId);

		public List<UserInfo> userHaveCoin(Integer userId);

		//トランザクション用
		public void gacha(Integer userId,Integer randomNumber);
}
