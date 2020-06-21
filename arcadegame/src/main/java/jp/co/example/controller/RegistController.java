package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.controller.form.RegistForm;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserInfoService;

@Controller
public class RegistController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/regist")
	public String regist(Model model) {

		return "regist";

	}


	@RequestMapping("/regist1")
	public String regist1(@ModelAttribute("regist") RegistForm registForm, Model model, HttpSession session) {
		System.out.println(registForm.getLoginId());


		List<UserInfo> list1 = userInfoService.findByUserId(registForm.getUserId());

		if(list1 != null ) {

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


		return "registResult";

	}

	@RequestMapping("/regist3")
	public String regist3(@ModelAttribute("regist3") RegistForm registForm, Model model, HttpSession session) {

		return "login";

	}

}
