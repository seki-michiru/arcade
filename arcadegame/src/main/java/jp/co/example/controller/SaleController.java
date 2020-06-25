package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.SaleForm;
import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Items;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.ItemStocksService;
import jp.co.example.service.SaleService;

@Controller
public class SaleController {

	@Autowired
	private SaleService saleService;

	@Autowired
	private ItemStocksService itemStocksService;

	@RequestMapping("/sale")
	public String sale(@ModelAttribute("SaleForm") SaleForm saleForm, Model model, HttpSession session) {

		List<Items> list = saleService.findAll();

		UserInfo user = (UserInfo) session.getAttribute("list");

		List<Items> stockItem = saleService.havingItem(user.getUserId());

		session.setAttribute("userStockItem", stockItem);
		session.setAttribute("itemlist", list);
		return "sale";
	}


	@RequestMapping("/saleResult")
	public String saleResult(@ModelAttribute("SaleForm") SaleForm form, Model model, HttpSession session) {

		UserInfo user = (UserInfo) session.getAttribute("list");

		List<Integer> takeList = new ArrayList<>();
		List<Integer> giveList = new ArrayList<>();
		Integer flag = 0;

		for (int i = 0; i < form.getTakeId().length; i++) {
			takeList.add(form.getTakeId()[i]);
		}

		for (int i = 0; i < form.getGiveId().length; i++) {
			giveList.add(form.getGiveId()[i]);
			flag = flag + form.getGiveId()[i];
		}

		if(flag == 0) {
			model.addAttribute("msg","アイテムを選択してください");
			return "sale";
		}

		for (int i = 0; i < takeList.size(); i++) {
			if(giveList.get(i) == 0) {
				continue;
			}
			saleService.marketOpen(user.getUserId(), takeList.get(i), giveList.get(i));
		}

		Integer userId = user.getUserId();
		List<ItemStocks> list = itemStocksService.findStockAll(userId);
		session.setAttribute("StockAll", list);
		return "saleResult";
	}

}
