package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//mport jp.co.example.service.GachaService;

@Controller
public class GachaController {

	//private GachaService gachaService;

	@RequestMapping("/gacha")
	public String gacha(Model model) {

		return "gacha";
	}
	@RequestMapping("/gachaPlay")
	public String gachaPlay(Model model) {


		return "gachaPlay";
	}
	@RequestMapping("/gachaResult")
	public String gachaResult(Model model) {

		return "gachaResult";
	}

}
