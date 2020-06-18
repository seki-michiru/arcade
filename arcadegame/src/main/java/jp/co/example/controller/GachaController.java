package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.Items;
import jp.co.example.service.GachaService;

//mport jp.co.example.service.GachaService;

@Controller
public class GachaController {
	@Autowired
	private GachaService gachaService;

	@RequestMapping("/gacha")
	public String gacha(Model model) {

		return "gacha";
	}

	@RequestMapping("/gachaPlay")
	public String gachaPlay(Model model, HttpSession session) {

		Integer randomNumber = gachaService.Random();
		List<Items> list = gachaService.gachaItem(randomNumber);
		session.setAttribute("getItem", list);

		//List<UserInfo> user = (List<UserInfo>) session.getAttribute("list");

		gachaService.itemCollect(2, randomNumber);
		gachaService.coinWast(2);
		//
		//		gachaService.itemCollect(user.get(0).getUserId(),randomNumber);
		//		gachaService.coinWast(user.get(0).getUserId());
		return "gachaPlay";
	}

	@RequestMapping("/gachaResult")
	public String gachaResult(Model model) {

		return "gachaResult";
	}

}
