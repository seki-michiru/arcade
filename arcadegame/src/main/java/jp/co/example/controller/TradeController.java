package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class TradeController {
	//@Autowired
	//private GachaService gachaService;
	@RequestMapping("/tradeMenu")
	public String tradeMenu(Model model) {

		return "tradeMenu";
	}
	@RequestMapping("/trade")
	public String trade(Model model) {

		return "trade";
	}
	@RequestMapping("/tradeDelete")
	public String tradeResult(Model model) {

		return "tradeDelete";
	}

}
