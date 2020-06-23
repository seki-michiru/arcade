package jp.co.example.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserInfoService;

@Controller
public class ItemController {
	@Autowired
	private UserInfoService userInfoService;



	@RequestMapping("/item")
	public String item(Model model, HttpSession session) {

		List<UserInfo> list =userInfoService.findByLoginId((String)session.getAttribute("loginId"));
		Integer userId = null;

		for(UserInfo u: list) {
			userId = u.getUserId();
		}
		List<UserInfo> allItem = null;
		allItem = userInfoService.allItem(userId);

		if(allItem == null) {
			model.addAttribute("msg", "所持アイテムはありません");
		}

		System.out.println(allItem);


		model.addAttribute("allItem", allItem);

		return "item";
}
}


