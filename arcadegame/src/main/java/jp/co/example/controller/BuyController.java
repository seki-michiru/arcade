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
		List<Items> list = itemsService.findAll();

		UserInfo user = (UserInfo) session.getAttribute("list");
		Integer userId = user.getUserId();
		UserInfo userInfo = userInfoService.getCoin(userId);
		Integer userCoin = userInfo.getCoinHave();
		session.setAttribute("item", list);
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


    	if(itemId.isEmpty() || itemId == null) {
    		model.addAttribute("msg", "購入するアイテムを選択してください");
    		return "buy";
    	}


    	for(int i = 0; i < form.getNumber().length; i++) {
    		if(form.getNumber()[i] == 0) {
    			continue;
    		}
			number.add(form.getNumber()[i]);
    	}

     	int sumPrice = 0;
    	List<String> itemName =  new ArrayList<>();



    	try {

    		for(int i = 0; i < itemId.size(); i++) {
    			sumPrice += itemsService.findItemName(itemId.get(i)).get(0).getItemPrice() * number.get(i);
    			itemName.add(itemsService.findItemName(itemId.get(i)).get(0).getItemName());
    		}
    	}catch(IndexOutOfBoundsException e){
    		model.addAttribute("msg", "個数を選択してください");
			return "buy";
    	}



    	UserInfo user = (UserInfo) session.getAttribute("list");
    	Integer userId = user.getUserId();
		UserInfo userInfo = userInfoService.getCoin(userId);
		Integer userCoin = userInfo.getCoinHave();

    	List<BuyInfo> buy = new ArrayList<>();

    	if(sumPrice < userCoin) {

    		try {

    			for(int i = 0; i < itemId.size(); i++){
    				userInfoService.subCoin(userId, sumPrice);
    				itemStocksService.plusStock(userId, itemId.get(i), number.get(i));
    				buy.add(new BuyInfo(itemName.get(i),number.get(i)));
    			}

    		}catch(IndexOutOfBoundsException e){
    			model.addAttribute("msg", "個数を選択してください");
    			return "buy";
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
    //user.getUserId() user.getCoinHave(); user.getCoinHave()

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