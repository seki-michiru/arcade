package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.RegistForm;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.ItemStocksService;
import jp.co.example.service.UserInfoService;

@Controller
public class RegistController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private ItemStocksService itemStocksService;

	@RequestMapping("/regist")
	public String regist(Model model) {

		return "regist";

	}


	@RequestMapping("/regist1")
	public String regist1(@Validated @ModelAttribute("regist") RegistForm registForm, BindingResult result, Model model, HttpSession session) {

		if(result.hasErrors()) {

			return "regist";

		}

		List<UserInfo> list1 = userInfoService.findByLoginId(registForm.getLoginId());



		if(list1 != null) {

			model.addAttribute("msg1", "IDまたはユーザー名が既に存在します。");

			return "regist";

		}else {


			userInfoService.insert(registForm.getLoginId(), registForm.getUserName(), registForm.getPassword());

			session.setAttribute("loginId", registForm.getLoginId());
			session.setAttribute("userName", registForm.getUserName());
			session.setAttribute("password", registForm.getPassword());

			return "registConfirm";

		}

	}

	@RequestMapping("/regist2")
	public String regist2(@ModelAttribute("regist2") RegistForm registForm, Model model, HttpSession session) {


		List<UserInfo> userInfo = userInfoService.findIdPass(registForm.getLoginId(), registForm.getPassword());
		Integer itemId = null;

		itemStocksService.itemInsert(userInfo.get(0).getUserId(), itemId);
		System.out.println(userInfo.get(0).getUserId());

		return "registResult";

	}

	@RequestMapping("/regist3")
	public String regist3(@ModelAttribute("regist3") RegistForm registForm, Model model, HttpSession session) {

		return "login";

	}

}
