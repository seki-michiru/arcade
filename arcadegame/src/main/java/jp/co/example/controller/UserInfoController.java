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

import jp.co.example.controller.form.LoginForm;
import jp.co.example.controller.form.RegistForm;
import jp.co.example.controller.form.UserInfoForm;
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

	@RequestMapping("/login1")
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


	@RequestMapping("/regist1")
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

	@RequestMapping("/regist2")
	public String regist2(@ModelAttribute("regist2") RegistForm registForm, Model model, HttpSession session) {


		return "registResult";

	}

	@RequestMapping("/regist3")
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
	public String userInfo2(@ModelAttribute("userInfo2") UserInfoForm userInfoform, Model model, HttpSession session) {

		List<UserInfo> userInfo2 = userInfoService.findIdUserNamePass(userInfoform.getLoginId(), userInfoform.getUserName(), userInfoform.getPassword());

		if(userInfo2 == null) {

			model.addAttribute("msg","IDまたは");

			return "userInfoChange";

		}else {

			session.setAttribute("loginId", userInfoform.getLoginId());
			session.setAttribute("userName", userInfoform.getUserName());
			session.setAttribute("password", userInfoform.getPassword());

			return "userInfoConfirm";

		}

	}

	@RequestMapping("/userInfo3")
	public String userInfo3(@ModelAttribute("userInfo3") UserInfoForm userInfoform, Model model, HttpSession session) {

		userInfoService.findIdUserNamePass(userInfoform.getLoginId(), userInfoform.getUserName(), userInfoform.getPassword());

		session.setAttribute("loginId", userInfoform.getLoginId());
		session.setAttribute("userName", userInfoform.getUserName());
		session.setAttribute("password", userInfoform.getPassword());

		return "userInfoResult";

	}

	@RequestMapping("/userInfo4")
	public String userInfo4(@ModelAttribute("userInfo4") Model model) {

		return "menu";

	}


	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {

		session.invalidate();
		return "top";

	}


}
