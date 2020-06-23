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

		List<UserInfo> list = userInfoService.findByLoginId((String)session.getAttribute("loginId"));


		session.setAttribute("loginId", list.get(0).getLoginId());
		session.setAttribute("userName", list.get(0).getUserName());
		session.setAttribute("password", list.get(0).getPassword());

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

			List<UserInfo> list = userInfoService.findByLoginId((String)session.getAttribute("loginId"));

			session.setAttribute("loginId", userInfoform.getLoginId());
			session.setAttribute("userName", userInfoform.getUserName());
			session.setAttribute("password", userInfoform.getPassword());

			model.addAttribute("list",list);
			return "userInfoConfirm";

		}

	}


	@RequestMapping("/userInfoResult")
	public String userInfoConfirm(@ModelAttribute("userInfo") UserInfoForm userInfoform, Model model, HttpSession session) {

		String loginId = (String)session.getAttribute("loginId");
		String userName = (String)session.getAttribute("userName");
		String password = (String)session.getAttribute("password");
		Integer userId = (Integer)session.getAttribute("userId");

		System.out.println(loginId);
		System.out.println(userName);
		System.out.println(password);

		userInfoService.update(loginId, userName, password, userId);

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
