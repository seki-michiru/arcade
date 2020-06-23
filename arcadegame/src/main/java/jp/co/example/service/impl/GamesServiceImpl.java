package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.GamesDao;
import jp.co.example.service.GamesService;
@Service
public class GamesServiceImpl implements GamesService{

	@Autowired
	private GamesDao gamesdao;

	public void score(Integer userId, Integer score, Integer coin) {
		gamesdao.score(userId, score, coin);
	}

	public void updateCoin(Integer userId, Integer coin) {
		gamesdao.updateCoin(userId, coin);
	}

	public void brockScore(Integer userId, Integer score, Integer coin) {
		gamesdao.brockScore(userId,score,coin);
	}

}
