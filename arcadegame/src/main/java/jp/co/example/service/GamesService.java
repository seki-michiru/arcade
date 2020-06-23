package jp.co.example.service;

public interface GamesService {

	public void score(Integer userId, Integer score, Integer coin);

	public void updateCoin(Integer userId, Integer coin);
}
