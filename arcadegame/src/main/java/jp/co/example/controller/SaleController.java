package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.SaleForm;
import jp.co.example.entity.Items;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.SaleService;

@Controller
public class SaleController {

	@Autowired
	private SaleService saleService;

	@RequestMapping("/sale")
	public String sale(@ModelAttribute("SaleForm") SaleForm saleForm, Model model,HttpSession session) {

		List<Items> list = saleService.findAll();

		@SuppressWarnings("unchecked")
		List<UserInfo> user =  (List<UserInfo>) session.getAttribute("userInfo");

		List<Items> stockItem = saleService.havingItem(user.get(0).getUserId());

		System.out.println(stockItem);

		session.setAttribute("userStockItem", stockItem);
		session.setAttribute("itemlist", list);
		return "sale";
	}

	@RequestMapping("/saleResult")
	public String saleResult(Model model) {

		return "saleResult";
	}


}
