package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.SaleDeleteForm;
import jp.co.example.entity.Sales;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.SaleDeleteService;

@Controller
public class SaleDeleteController {

	@Autowired
	private SaleDeleteService SaleDeleteService;


	@RequestMapping("/saleDelete")
	public String saleDelete(@ModelAttribute("SaleDeleteForm") SaleDeleteForm from, Model model,HttpSession session) {

		@SuppressWarnings("unchecked")
		List<UserInfo> user =  (List<UserInfo>) session.getAttribute("userInfo");


		List<Sales> list = SaleDeleteService.findAll(user.get(0).getUserId());
		session.setAttribute("marketItem",list);



		return "saleDelete";
	}

	@RequestMapping("/saleDeleteResult")
	public String saleDeleteResult(Model model) {

		return "saleDeleteResult";
	}
}
