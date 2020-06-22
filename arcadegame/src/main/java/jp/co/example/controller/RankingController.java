package jp.co.example.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.UserInfo;
import jp.co.example.service.UserInfoService;

@Controller
public class RankingController {
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/ranking")
	public String ranking(Model model) {

		return "ranking";

	}

@RequestMapping("/rankingInvader")
	public String rankingInvader(@ModelAttribute("rankingInvader") Model model, HttpSession session, Request request) {

	List<UserInfo> list = userInfoService.findByLoginId((String)session.getAttribute("loginId"));
	Integer myUserId = null;
	Integer gameId = 1;

	for(UserInfo u: list) {

		myUserId = u.getUserId();

	}

		List<UserInfo> rankingInvader = userInfoService.findRanking(1);
		List<UserInfo> higtScoreDateFirst = userInfoService.higtScoreDate(rankingInvader.get(0).getUserId(), 1);
		List<UserInfo> higtScoreDateSecond = userInfoService.higtScoreDate(rankingInvader.get(1).getUserId(), 1);
		List<UserInfo> higtScoreDateThird = userInfoService.higtScoreDate(rankingInvader.get(2).getUserId(), 1);
		List<UserInfo> myRank = userInfoService.findMyRanking(gameId, myUserId);

		System.out.println(rankingInvader);


		request.setAttribute("rankingInvader", rankingInvader);
		request.setAttribute("higtScoreDateFirst", higtScoreDateFirst);
		request.setAttribute("higtScoreDateSecond", higtScoreDateSecond);
		request.setAttribute("higtScoreDateThird", higtScoreDateThird);

		request.setAttribute("myRank", myRank);

		return "rankingInvader";
}


@RequestMapping("/rankingBrock")
	public String rankingBrock(@ModelAttribute("rankingBrock") Model model,  HttpSession session, Request request) {

	List<UserInfo> list = userInfoService.findByLoginId((String)session.getAttribute("loginId"));
	Integer myUserId = null;
	Integer gameId = 2;

	for(UserInfo u: list) {

		myUserId = u.getUserId();

	}

		List<UserInfo> rankingBrock = userInfoService.findRanking(2);
		List<UserInfo> higtScoreDateFirst = userInfoService.higtScoreDate(rankingBrock.get(0).getUserId(), 1);
		List<UserInfo> higtScoreDateSecond = userInfoService.higtScoreDate(rankingBrock.get(1).getUserId(), 1);
		List<UserInfo> higtScoreDateThird = userInfoService.higtScoreDate(rankingBrock.get(2).getUserId(), 1);
		List<UserInfo> myRank = userInfoService.findMyRanking(gameId, myUserId);

		System.out.println(rankingBrock);

		request.setAttribute("rankingBrock", rankingBrock);
		request.setAttribute("higtScoreDateFirst", higtScoreDateFirst);
		request.setAttribute("higtScoreDateSecond", higtScoreDateSecond);
		request.setAttribute("higtScoreDateThird", higtScoreDateThird);

		request.setAttribute("myRank", myRank);

		return "rankingBrock";


	}





}
