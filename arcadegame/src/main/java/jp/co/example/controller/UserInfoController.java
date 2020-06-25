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

import jp.co.example.controller.form.UserInfoForm;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserInfoService;

@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;


	@RequestMapping("/userInfo")
	public String userInfo(Model model, HttpSession session) {

		return "userInfo";

	}

	@RequestMapping("/userInfoChange")
	public String userInfoChange(@ModelAttribute("userInfo") UserInfoForm userInfoform, BindingResult result, Model model, HttpSession session) {


		return "userInfoChange";

	}

	@RequestMapping("/userInfoChange1")
	public String userInfoChange1(@Validated @ModelAttribute("userInfo") UserInfoForm userInfoform, BindingResult result, Model model, HttpSession session) {

		if(result.hasErrors()) {

			return "userInfoChange";

		}

		List<UserInfo> userInfo2 = userInfoService.findIdUserNamePass(userInfoform.getLoginId(), userInfoform.getUserName(), userInfoform.getPassword());


		if(userInfo2 != null) {

			model.addAttribute("msg","IDまたはユーザー名がが既に存在します。");

			return "userInfoChange";

		}else {


			session.setAttribute("LoginId", userInfoform.getLoginId());
			session.setAttribute("UserName", userInfoform.getUserName());
			session.setAttribute("Password", userInfoform.getPassword());

			//model.addAttribute("list",list);
			return "userInfoConfirm";

		}

	}


	@RequestMapping("/userInfoResult")
	public String userInfoConfirm(Model model,  HttpSession session) {

		String loginId = (String)session.getAttribute("LoginId");
		String userName =  (String)session.getAttribute("UserName");
		String password = (String)session.getAttribute("Password");
		Integer userId =  (Integer)session.getAttribute("userId");


		session.setAttribute("loginId", loginId);
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);
		session.setAttribute("userId", userId);


		userInfoService.update(loginId, userName, password, userId);

		List<UserInfo>list = userInfoService.findIdUserNamePass(loginId, userName, password);

		session.setAttribute("list", list.get(0));

		return "userInfoResult";

	}

	@RequestMapping("/userInfoResult1")
	public String userInfoResult1(@ModelAttribute("userInfo") Model model) {

		return "menu";

	}

	@RequestMapping("/menu")
	public String menu(Model model) {

		return "menu";

	}


	@RequestMapping("/menu1")
	public String menu1(Model model) {

		return "logout";

	}


	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {

		session.invalidate();
		return "top";

	}


}
