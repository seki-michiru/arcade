package jp.co.example.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String rankingInvader(Model model, HttpSession session) {

	List<UserInfo> list = userInfoService.findByLoginId((String)session.getAttribute("loginId"));
	Integer myUserId = null;
	Integer gameId = 1;

	for(UserInfo u: list) {

		myUserId = u.getUserId();

	}

		List<UserInfo> rankingInvader = userInfoService.findRanking(gameId);
		System.out.println(rankingInvader.size());
		System.out.println(rankingInvader.get(0).getUserName());

		List<Date> higtScoreDateFirst = new ArrayList<>();

		for(int i = 0; i < rankingInvader.size(); i++) {
			String userName = rankingInvader.get(i).getUserName();

			higtScoreDateFirst.add(userInfoService.higtScoreDate(userName, gameId).get(0).getScoreDate());

		}
		System.out.println(higtScoreDateFirst.size());

		Date date1 = null;
		Date date2 = null;
		Date date3 = null;

		try {

			date1 = higtScoreDateFirst.get(0);
			date2 = higtScoreDateFirst.get(1);
			date3 = higtScoreDateFirst.get(2);
		} catch(IndexOutOfBoundsException e) {
			System.out.println("アウトオブばうんず");
		}

		model.addAttribute("date1", date1);
		model.addAttribute("date2", date2);
		model.addAttribute("date3", date3);
		/*List<UserInfo> higtScoreDateSecond = userInfoService.higtScoreDate(rankingInvader.get(1).getUserName(), gameId);
		List<UserInfo> higtScoreDateThird = userInfoService.higtScoreDate(rankingInvader.get(2).getUserName(), gameId);*/
		List<UserInfo> myRank = userInfoService.findMyRanking(gameId, myUserId);

		System.out.println(rankingInvader);
		System.out.println(myRank);
		System.out.println(higtScoreDateFirst);


		model.addAttribute("rankingInvader", rankingInvader);
		model.addAttribute("higtScoreDateFirst", higtScoreDateFirst);
		/*model.addAttribute("higtScoreDateSecond", higtScoreDateSecond);
		model.addAttribute("higtScoreDateThird", higtScoreDateThird);
		*/
		model.addAttribute("myRank", myRank);

		return "rankingInvader";
}


@RequestMapping("/rankingBrock")
	public String rankingBrock(Model model,  HttpSession session) {

	List<UserInfo> list = userInfoService.findByLoginId((String)session.getAttribute("loginId"));
	Integer myUserId = null;
	Integer gameId = 2;

	for(UserInfo u: list) {

		myUserId = u.getUserId();

	}
	System.out.println(myUserId);

		List<UserInfo> rankingBrock = userInfoService.findRanking(gameId);
		List<Date> higtScoreDateFirst = new ArrayList<>();

		for(int i = 0; i < rankingBrock.size(); i++) {
			String userName = rankingBrock.get(i).getUserName();

			higtScoreDateFirst.add(userInfoService.higtScoreDate(userName, gameId).get(0).getScoreDate());

		}

		System.out.println(higtScoreDateFirst.size());

		Date date1 = null;
		Date date2 = null;
		Date date3 = null;

		try {

			date1 = higtScoreDateFirst.get(0);
			date2 = higtScoreDateFirst.get(1);
			date3 = higtScoreDateFirst.get(2);
		} catch(IndexOutOfBoundsException e) {
			System.out.println("アウトオブばうんず");
		}

		model.addAttribute("date1", date1);
		model.addAttribute("date2", date2);
		model.addAttribute("date3", date3);
		/*List<UserInfo> higtScoreDateSecond = userInfoService.higtScoreDate(rankingBrock.get(1).getUserName(), gameId);
		List<UserInfo> higtScoreDateThird = userInfoService.higtScoreDate(rankingBrock.get(2).getUserName(), gameId);*/
		List<UserInfo> myRank = userInfoService.findMyRanking(gameId, myUserId);

		System.out.println(rankingBrock);
		System.out.println(myRank);
		System.out.println(higtScoreDateFirst);

		model.addAttribute("rankingBrock", rankingBrock);
		model.addAttribute("higtScoreDateFirst", higtScoreDateFirst);
		/*model.addAttribute("higtScoreDateSecond", higtScoreDateSecond);
		model.addAttribute("higtScoreDateThird", higtScoreDateThird);
		*/

		model.addAttribute("myRank", myRank);

		return "rankingBrock";


	}

}
