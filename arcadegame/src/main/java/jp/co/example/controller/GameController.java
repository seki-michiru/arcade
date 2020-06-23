package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.GameResultForm;
import jp.co.example.controller.form.ItemSelectForm;
import jp.co.example.entity.Items;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.GamesService;
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

    @Autowired
    private GamesService gamesService;

    @RequestMapping("/game")
    public String game(Model model) {

        return "game";
    }

    @RequestMapping("/invaderStart")
    public String invaderStart(@ModelAttribute("ItemSelectForm") ItemSelectForm form,Model model) {
   	 UserInfo user = (UserInfo) session.getAttribute("list");
    	 Integer userId = user.getUserId();

    	 List<Items> list = itemStocksService.getStockItem(userId,1);
    	 session.setAttribute("stockList",list);

        return "invaderStart";
    }

    @RequestMapping("/invaderPlay")
	public String invaderPlay(@ModelAttribute("test") GameResultForm form,@ModelAttribute("ItemSelectForm") ItemSelectForm itemform, Model model) {
    	Integer one = itemform.getGameIdOne();
    	Integer tow = itemform.getGameIdTow();
    	Integer three = itemform.getGameIdThree();

    	Items itemOne = itemsService.getItemNameEffect(one);
    	Items itemTow =  itemsService.getItemNameEffect(tow);
    	Items itemThree = itemsService.getItemNameEffect(three);

    	session.setAttribute("one",itemOne);
    	session.setAttribute("tow",itemTow);
    	session.setAttribute("three",itemThree );

		return "invaderPlay";
    }

	@RequestMapping("/result")
	public String invaderPlay(@ModelAttribute("test") GameResultForm form,Model model) {
		String loginId = (String)session.getAttribute("loginId");

		List<UserInfo> list = userInfoService.findByLoginId(loginId);


		Integer userId = list.get(0).getUserId();
		Integer score = form.getScore();
		Integer coin = score /3;

		gamesService.updateCoin(userId, coin);

		gamesService.score(userId, score, coin);

		model.addAttribute("score", score);
		model.addAttribute("coin", coin);

		return "invaderResult";
    }

	@RequestMapping("/invaderResult")
	public String invaderResult(@ModelAttribute("test") GameResultForm form,Model model) {

		return "invaderResult";
    }

	@RequestMapping("/brockStart")
	public String brockStart(@ModelAttribute("ItemSelectForm") ItemSelectForm form,Model model) {
		UserInfo user = (UserInfo) session.getAttribute("list");
		Integer userId = user.getUserId();

		List<Items> list = itemStocksService.getStockItem(userId, 2);
		session.setAttribute("stockList",list);

		return "brockStart";
    }

	@RequestMapping("/brockPlay")
	public String brockPlay(@ModelAttribute("ItemSelectForm") ItemSelectForm itemform,Model model) {

    	Integer one = itemform.getGameIdOne();
    	Integer tow = itemform.getGameIdTow();
    	Integer three = itemform.getGameIdThree();

    	Items itemOne = itemsService.getItemNameEffect(one);
    	Items itemTow =  itemsService.getItemNameEffect(tow);
    	Items itemThree = itemsService.getItemNameEffect(three);

    	session.setAttribute("one",itemOne);
    	session.setAttribute("tow",itemTow);
    	session.setAttribute("three",itemThree );

		return "brockPlay";
    }

	@RequestMapping("/brockResult")
	public String brockPlay(Model model) {

		return "brockResult";
    }
}