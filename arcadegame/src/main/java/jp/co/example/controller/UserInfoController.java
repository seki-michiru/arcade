package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.LoginForm;
import jp.co.example.controller.form.RegistForm;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserInfoService;

@Controller
public class UserInfoController {

	private UserInfoService userInfoService;

	@RequestMapping("/top")
	public String top(Model model) {

		return "top";

	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("login") LoginForm loginForm, Model model) {

		return "login";

	}

	@RequestMapping(value="/login1", method = RequestMethod.POST)
	public String login1(LoginForm loginform, Model model, HttpSession session) {

		UserInfo userInfo =userInfoService.findIdPass(loginform.getLoginId(), loginform.getPassword());

		if(userInfo == null) {

			model.addAttribute("msg", "入力したIDとPASSは存在しません");

			return "login";

		}else {

			session.setAttribute("userInfo", userInfo);
			return "menu";

		}


	}

	@RequestMapping(value="/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute("regist") RegistForm registForm, Model model) {

		return "regist";

	}

	@RequestMapping(value="/logout")
	public String logout(Model model, HttpSession session) {

		session.invalidate();
		return "top";

	}


}
