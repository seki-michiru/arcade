package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.Items;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.GachaService;
import jp.co.example.service.UserInfoService;

//mport jp.co.example.service.GachaService;

@Controller
public class GachaController {
	@Autowired
	private GachaService gachaService;

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/gacha")
	@Transactional
	public String gacha(Model model,HttpSession session) {
		UserInfo user =  (UserInfo) session.getAttribute("list");
		Integer userId = user.getUserId();
		List<UserInfo> coinHave = gachaService.userHaveCoin(userId);

		//int coinHave = coin.get(0).getCoinHave();


		session.setAttribute("coin",coinHave.get(0).getCoinHave());

		return "gacha";
	}

	@RequestMapping("/gachaPlay")
	@Transactional
	public String gachaPlay(Model model, HttpSession session) {

		UserInfo user =  (UserInfo) session.getAttribute("list");

		Integer userId = user.getUserId();
		UserInfo userInfo = userInfoService.getCoin(userId);
		Integer userCoin = userInfo.getCoinHave();

		//コイン判定
		if(userCoin < 30) {
			model.addAttribute("msg", "コインが足りません");
			return "gacha";
		}
		else {
			//アイテム名取得
		Integer randomNumber = gachaService.Random();
		List<Items> list = gachaService.gachaItem(randomNumber);
		session.setAttribute("getItem", list);
		//アイテム増やす
		gachaService.itemCollect(userId, randomNumber);

		//減る前のコイン数を保存
		//session.setAttribute("oldCoin", user.get(0).getCoinHave());

		//コイン数を減らす
		gachaService.coinWast(userId);

		//コインが減った後のユーザー情報を取得
		List<UserInfo> coinHave = gachaService.userHaveCoin(userId);

		//int coinHave = coin.get(0).getCoinHave();


		session.setAttribute("coin",coinHave.get(0).getCoinHave());


		return "gachaPlay";
		}
	}

	@RequestMapping("/gachaResult")
	public String gachaResult(Model model) {

		return "gachaResult";
	}

}
