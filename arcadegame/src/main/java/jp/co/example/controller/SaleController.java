package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaleController {


	@RequestMapping("/sale")
	public String sale(Model model) {

		return "sale";
	}
	@RequestMapping("/saleResult")
	public String saleResult(Model model) {

		return "gacha";
	}
	@RequestMapping("/saleDelete")
	public String saleDelete(Model model) {

		return "saleDelete";
	}
	@RequestMapping("/saleDeleteResult")
	public String saleDeleteResult(Model model) {

		return "saleDeleteResult";
	}
}
