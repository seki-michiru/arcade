package jp.co.example.dao;

public interface GamesDao {
	public void score(Integer userId, Integer score, Integer coin);

	public void updateCoin(Integer userId, Integer coin);

	public void brockScore(Integer userId, Integer score, Integer coin);
}