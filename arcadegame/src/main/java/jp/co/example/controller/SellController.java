package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.SellForm;
import jp.co.example.entity.BuyInfo;
import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.ItemStocksService;
import jp.co.example.service.ItemsService;
import jp.co.example.service.UserInfoService;

@Controller
public class SellController {

    @Autowired
    HttpSession session;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ItemStocksService itemStocksService;

    @RequestMapping("/sell")
    public String sell(@ModelAttribute("sellForm") SellForm form,Model model) {
    	 UserInfo user = (UserInfo) session.getAttribute("list");
    	 Integer userId = user.getUserId();
    	session.removeAttribute("StockAll");
        List<ItemStocks> list = itemStocksService.findStockAll(userId);

    	UserInfo userInfo = userInfoService.getCoin(userId);
    	Integer userCoin = userInfo.getCoinHave();

        if(list==null) {
        	model.addAttribute("msg","所持アイテムはありません");
        	model.addAttribute("flag","非表示");
        }else {

        	session.setAttribute("StockAll",list);
        	session.setAttribute("coin",userCoin);
        }

        return "sell";
    }


    @RequestMapping("/sellResult")
    public String sellResult(@ModelAttribute("sellForm") SellForm form,Model model) {

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
    		model.addAttribute("msg", "売却するアイテムを選択してください");
    		return "sell";
    	}

     	int sumPrice = 0;

    		for(int i = 0; i < itemId.size(); i++) {
    			sumPrice += itemsService.findItemName(itemId.get(i)).get(0).getItemPrice() / 2 * number.get(i);
    		}



    	UserInfo user = (UserInfo) session.getAttribute("list");
    	Integer userId = user.getUserId();

    	List<BuyInfo> sell = new ArrayList<>();


    	userInfoService.plusCoin(userId, sumPrice);

    		for(int i = 0; i < itemId.size(); i++){
        		if(number.get(i) == 0) {
        			continue;
        		}

    			itemStocksService.minusStock(userId, itemId.get(i), number.get(i));
    			sell.add(new BuyInfo(itemsService.findItemName(itemId.get(i)).get(0).getItemName(),number.get(i)));
    		}


    	UserInfo userInfo = userInfoService.getCoin(userId);
    	Integer userCoin = userInfo.getCoinHave();

    		session.setAttribute("sellInfo",sell);
    		session.setAttribute("coin",userCoin);

    		return "sellResult";


    }
}