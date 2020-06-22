package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.ItemSelectForm;
import jp.co.example.entity.Items;
import jp.co.example.service.ItemStocksService;
import jp.co.example.service.ItemsService;
import jp.co.example.service.UserInfoService;

@Controller
public class GameController {

    @Autowired
    HttpSession session;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ItemStocksService itemStocksService;

    @RequestMapping("/menu")
    public String menu(Model model) {

        return "menu";
    }

    @RequestMapping("/game")
    public String game(Model model) {

        return "game";
    }

    @RequestMapping("/invaderStart")
    public String invaderStart(@ModelAttribute("ItemSelectForm") ItemSelectForm form,Model model) {
//    	 UserInfo user = (UserInfo) session.getAttribute("list");
    	 Integer userId = 1;
//    			 user.getUserId();

    	 List<Items> list = itemStocksService.getStockItem(userId,1);
    	 session.setAttribute("stockList",list);

        return "invaderStart";
    }

	@RequestMapping("/brockStart")
	public String brockStart(@ModelAttribute("ItemSelectForm") ItemSelectForm form,Model model) {
		//UserInfo user = (UserInfo) session.getAttribute("list");
		Integer userId = 1;
				//user.getUserId();

		List<Items> list = itemStocksService.getStockItem(userId, 2);
		session.setAttribute("stockList",list);

		return "brockStart";
    }

	@RequestMapping("/brockPlay")
	public String brockPlay(@ModelAttribute("ItemSelectForm") ItemSelectForm form,Model model) {

		return "brockPlay";
    }

	@RequestMapping("/brockResult")
	public String brockPlay(Model model) {

		return "brockResult";
    }
}