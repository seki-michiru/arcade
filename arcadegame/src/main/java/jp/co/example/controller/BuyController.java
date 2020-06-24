package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.buyForm;
import jp.co.example.entity.BuyInfo;
import jp.co.example.entity.Items;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.ItemStocksService;
import jp.co.example.service.ItemsService;
import jp.co.example.service.UserInfoService;

@Controller
public class BuyController {

    @Autowired
    HttpSession session;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ItemStocksService itemStocksService;

	@RequestMapping("/buy")
	public String buy(@ModelAttribute("buyForm") buyForm form, Model model) {
		List<Items> list = itemsService.itemAll();

		UserInfo user = (UserInfo) session.getAttribute("list");
		Integer userId = user.getUserId();
		UserInfo userInfo = userInfoService.getCoin(userId);
		Integer userCoin = userInfo.getCoinHave();
		session.setAttribute("items", list);
		session.setAttribute("coin", userCoin);

		return "buy";
	}


    //付けたし
    @RequestMapping("/buyResult")
    public String buyResult(@ModelAttribute("buyForm") buyForm form,Model model) {

    	List<Integer> itemId = new ArrayList<>();
    	List<Integer> number = new ArrayList<>();

    	for(int i = 0; i < form.getItemsId().length; i++) {
    			itemId.add(form.getItemsId()[i]);
    	}

    	Integer sumNumber = 0;

    	for(int i = 0; i < form.getNumber().length; i++) {
			number.add(form.getNumber()[i]);
			sumNumber += form.getNumber()[i];
    	}


    	if(sumNumber == 0) {
    		model.addAttribute("msg", "購入するアイテムの個数を選択してください");
    		return "buy";
    	}

     	int sumPrice = 0;

    		for(int i = 0; i < itemId.size(); i++) {
    			if(number.get(i) != 0){
    				Integer price = itemsService.findItemName(itemId.get(i)).get(0).getItemPrice();
    				sumPrice += price * number.get(i);
    			}
    		}


    	UserInfo user = (UserInfo) session.getAttribute("list");
    	Integer userId = user.getUserId();
		UserInfo userInfo = userInfoService.getCoin(userId);
		Integer userCoin = userInfo.getCoinHave();

    	List<BuyInfo> buy = new ArrayList<>();

    	if(sumPrice < userCoin) {

    		userInfoService.subCoin(userId, sumPrice);

    			for(int i = 0; i < itemId.size(); i++){
            		if(number.get(i) == 0) {
            			continue;
            		}
    				itemStocksService.plusStock(userId, itemId.get(i), number.get(i));
    				buy.add(new BuyInfo(itemsService.findItemName(itemId.get(i)).get(0).getItemName(),number.get(i)));
    			}

        	UserInfo Info = userInfoService.getCoin(userId);
        	userCoin = Info.getCoinHave();

    		session.setAttribute("buyInfo",buy);
    		session.setAttribute("coin",userCoin);

    		return "buyResult";

    	}else {

    		model.addAttribute("msg","コインが不足しています");
    		return "buy";
    	}

    }

    @RequestMapping("/shop")
    public String shop(Model model) {
    	UserInfo user = (UserInfo) session.getAttribute("list");
    	Integer userId = user.getUserId();
    	UserInfo userInfo = userInfoService.getCoin(userId);
    	Integer userCoin = userInfo.getCoinHave();

    	session.setAttribute("coin",userCoin);

        return "shop";
    }
}