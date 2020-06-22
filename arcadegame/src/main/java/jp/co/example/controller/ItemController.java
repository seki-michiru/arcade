package jp.co.example.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserInfoService;

@Controller
public class ItemController {
	@Autowired
	private UserInfoService userInfoService;

	/*@RequestMapping("/item")
	public String item(Model model) {

		return "item";

	}
	*/

	@RequestMapping("/item")
	public String item(@ModelAttribute("item") HttpSession session, Request request) {

		List<UserInfo> list =userInfoService.findByLoginId((String)session.getAttribute("loginId"));
		Integer userId = null;

		for(UserInfo u: list) {
			userId = u.getUserId();
		}
		List<UserInfo> allItem = userInfoService.allItem(userId);

		System.out.println(allItem);

		/*String itemName = "";
		String itemExplan = "";
		String gameName = "";
		Integer itemHave = null;

		for(UserInfo u : allItem) {

		itemName = u.getItemName();
		itemExplan = u.getItemExplan();
		gameName = u.getGameName();
		itemHave = u.getItemHave();

		}

		request.setAttribute("itemName", itemName);
		request.setAttribute("itemExplan", itemExplan);
		request.setAttribute("gameName", gameName);
		request.setAttribute("itemHave", itemHave);
*/

		request.setAttribute("allItem", allItem);

		return "item";
}
}


