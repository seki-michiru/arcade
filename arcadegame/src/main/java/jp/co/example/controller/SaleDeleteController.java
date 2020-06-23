package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.SaleDeleteForm;
import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Sales;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.ItemStocksService;
import jp.co.example.service.SaleDeleteService;

@Controller
public class SaleDeleteController {

	@Autowired
	private SaleDeleteService SaleDeleteService;

	@Autowired
	private ItemStocksService itemStocksService;


	@RequestMapping("/saleDelete")
	public String saleDelete(@ModelAttribute("SaleDeleteForm") SaleDeleteForm form, Model model,HttpSession session){

		UserInfo user =  (UserInfo) session.getAttribute("list");


		List<Sales> list = SaleDeleteService.findAll(user.getUserId());
		session.setAttribute("marketItem",list);

		return "saleDelete";
	}

	@RequestMapping("/saleDeleteResult")
	public String saleDeleteResult(@ModelAttribute("SaleDeleteForm") SaleDeleteForm form, Model model,HttpSession session) {

		List<Integer> saleList = new ArrayList<>();

		for(int i = 0; i < form.getDelete().length; i++) {
			saleList.add(form.getDelete()[i]);
		}
		for(int i = 0; i < saleList.size(); i++){
			SaleDeleteService.marketCancel(saleList.get(i));
		}

		 UserInfo user = (UserInfo) session.getAttribute("list");
    	 Integer userId = user.getUserId();
        List<ItemStocks> list = itemStocksService.findStockAll(userId);
    	session.setAttribute("StockAll",list);

		return "saleDeleteResult";
	}
}
