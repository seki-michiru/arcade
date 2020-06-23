package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.GamesDao;
@Repository
public class PgGamesDao implements GamesDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void score(Integer userId, Integer score, Integer coin) {
		String sql = "INSERT INTO scores(user_id, game_id, score, score_coin, score_date) VALUES (:UserId, 1, :Score, :Coin, current_date)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);
		param.addValue("Score", score);
		param.addValue("Coin", coin);

		jdbcTemplate.update(sql, param);
	}

	public void updateCoin(Integer userId, Integer coin) {
		String sql = "UPDATE user_info SET coin_have = coin_have + :Coin WHERE user_id = :UserId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("Coin", coin);
		param.addValue("UserId", userId);

		jdbcTemplate.update(sql, param);
	}

	public void brockScore(Integer userId, Integer score, Integer coin) {
		String sql = "INSERT INTO scores(user_id, game_id, score, score_coin, score_date) VALUES (:UserId, 2, :Score, :Coin, current_date)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);
		param.addValue("Score", score);
		param.addValue("Coin", coin);

		jdbcTemplate.update(sql, param);
	}
}