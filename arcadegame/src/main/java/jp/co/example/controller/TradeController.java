package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.TradeForm;
import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Sales;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.ItemStocksService;
import jp.co.example.service.TradeService;

@Controller
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@Autowired
	private ItemStocksService itemStocksService;

	@RequestMapping("/tradeMenu")
	public String tradeMenu(Model model) {

		return "tradeMenu";
	}

	@RequestMapping("/trade")
	public String trade(@ModelAttribute("TradeForm") TradeForm form, Model model, HttpSession session) {

		UserInfo user = (UserInfo) session.getAttribute("list");

		List<Sales> list = tradeService.marketTrade(user.getUserId());
		session.setAttribute("marketItem", list);

		return "trade";
	}

	@RequestMapping("/tradeResult")
	@Transactional
	public String tradeResult(@ModelAttribute("TradeForm") TradeForm form, Model model, HttpSession session) {

		UserInfo user = (UserInfo) session.getAttribute("list");

		List<Integer> tradeList = new ArrayList<>();

		for (int i = 0; i < form.getTrade().length; i++) {
			tradeList.add(form.getTrade()[i]);
		}
		for (int i = 0; i < tradeList.size(); i++) {
			tradeService.tradeSuccess(tradeList.get(i));
			tradeService.itemChange(tradeList.get(i), user.getUserId());
			tradeService.marketLog(tradeList.get(i), user.getUserId());
		}

		Integer userId = user.getUserId();
		List<ItemStocks> list = itemStocksService.findStockAll(userId);
		session.setAttribute("StockAll", list);

		return "tradeResult";
	}
}
