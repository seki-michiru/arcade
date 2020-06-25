package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.GamesDao;
import jp.co.example.service.GamesService;
@Service
public class GamesServiceImpl implements GamesService{

	@Autowired
	private GamesDao gamesdao;

	private void score(Integer userId, Integer score, Integer coin) {
		gamesdao.score(userId, score, coin);
	}

	private void updateCoin(Integer userId, Integer coin) {
		gamesdao.updateCoin(userId, coin);
	}

	private void brockScore(Integer userId, Integer score, Integer coin) {
		gamesdao.brockScore(userId,score,coin);
	}

	@Transactional
	public void invaderResult(Integer userId,Integer score,Integer coin) {
		score(userId,score,coin);
		updateCoin(userId,coin);
	}

	@Transactional
	public void brockResult(Integer userId,Integer score,Integer coin) {
		brockScore(userId,score,coin);
		updateCoin(userId,coin);
	}

}
