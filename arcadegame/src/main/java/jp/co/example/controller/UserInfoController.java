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
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.LoginForm;
import jp.co.example.controller.form.RegistForm;
import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserInfoService;

@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/top")
	public String top(Model model) {

		return "top";

	}
	@RequestMapping("/login")
	public String login(Model model) {

		return "login";

	}

	@RequestMapping(value="/login1", method = RequestMethod.POST)
	public String login1(@Validated @ModelAttribute("login1") LoginForm loginform, BindingResult result, Model model, HttpSession session) {

		if(result.hasErrors()) {
			return "login";
		}

		List<UserInfo> userInfo1 = userInfoService.findIdPass(loginform.getLoginId(), loginform.getPassword());
		List<UserInfo> list = userInfoService.findAll();

		String userName = "";



		if(userInfo1 == null) {

			model.addAttribute("msg", "入力したIDとPASSは存在しません");

			return "login";

		}else {

			String loginId = loginform.getLoginId();
			String password = loginform.getPassword();

			for(UserInfo u : userInfo1) {

				userName = u.getUserName();
				loginId = u.getLoginId();
				password = u.getPassword();

			}

			session.setAttribute("loginId", loginId);
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			session.setAttribute("list", list.get(0));

			return "menu";

		}



	}

	@RequestMapping("/regist")
	public String regist(Model model) {

		return "regist";

	}


	@RequestMapping(value="/regist1", method = RequestMethod.POST)
	public String regist1(@ModelAttribute("regist") RegistForm registForm, Model model, HttpSession session) {
		System.out.println(registForm.getLoginId());


		List<UserInfo> list1 = userInfoService.findByUserId(registForm.getUserId());
//				userInfoService.findByLoginId(registForm.getLoginId());
//		System.out.println(list1.get(0).getLoginId());

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

	@RequestMapping(value="/regist2", method = RequestMethod.POST)
	public String regist2(@ModelAttribute("regist2") RegistForm registForm, Model model, HttpSession session) {


		return "registResult";

	}

	@RequestMapping(value="/regist3", method = RequestMethod.POST)
	public String regist3(@ModelAttribute("regist3") RegistForm registForm, Model model, HttpSession session) {

		return "login";

	}

	@RequestMapping("/menu")
	public String menu(Model model) {

		return "logout";

	}

	@RequestMapping("/userInfo")
	public String userInfo(Model model, HttpSession session) {

		return "userInfo";

	}

	@RequestMapping("/userInfo1")
	public String userInfo1(@ModelAttribute("userInfo1") LoginForm loginform, BindingResult result, Model model, HttpSession session) {


		return "userInfoChange";

	}

	@RequestMapping("/userInfo2")
	public String userInfo2(@ModelAttribute("userInfo2") Model model) {



		return "userInfoChange";

	}


	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {

		session.invalidate();
		return "top";

	}


}
