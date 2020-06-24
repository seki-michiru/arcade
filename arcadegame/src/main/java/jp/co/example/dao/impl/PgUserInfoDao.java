package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UserInfoDao;
import jp.co.example.entity.UserInfo;

@Repository
public class PgUserInfoDao implements UserInfoDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<UserInfo> findAll() {

		String sql = "SELECT * FROM user_info";
		List<UserInfo> result = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return result.isEmpty() ? null : result;

	}

	public List<UserInfo> findIdPass(String loginId, String password) {

		String sql = "SELECT * FROM user_info WHERE login_id = :loginId AND password = :password";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		param.addValue("password", password);

		List<UserInfo> resultList = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return resultList.isEmpty() ? null : resultList;

	}

	public void insert(String loginId, String userName, String password) {

		String sql = "INSERT INTO user_info (login_id, user_name, password, create_date) VALUES (:LoginId, :UserName, :Password, current_date)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("LoginId", loginId);
		param.addValue("UserName", userName);
		param.addValue("Password", password);

		jdbcTemplate.update(sql, param);

	}

	public List<UserInfo> findByUserId(Integer userId) {

		String sql = "SELECT * FROM user_info WHERE user_id = :UserId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);

		List<UserInfo> result1 = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return result1.isEmpty() ? null : result1;

	}

	public List<UserInfo> findByLoginId(String loginId) {

		String sql = "SELECT * FROM user_info WHERE login_id = :LoginId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("LoginId", loginId);

		List<UserInfo> result1 = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return result1.isEmpty() ? null : result1;

	}

	public List<UserInfo> allItem(Integer userId) {
		String sql = "select g.game_name, i.item_name, i.item_explan, s.item_have "
				+ "from user_info u join item_stocks s on u.user_id=s.user_id "
				+ "join items i on s.item_id=i.item_id join games g on i.game_id=g.game_id where u.user_id = :UserId and item_have > 0 "
				+ "order by game_name";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);

		List<UserInfo> allItem = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return allItem.isEmpty() ? null : allItem;
	}

	public List<UserInfo> findRanking(Integer gameId) {
		String sql = "SELECT user_name, rank() over (order by(MAX(score))desc) rank, MAX(score) AS highScore , count(*) AS playNum "
				+ "FROM user_info "
				+ "JOIN scores ON user_info.user_id = scores.user_id "
				+ "where game_id = :GameId "
				+ "GROUP BY user_info.user_name "
				+ "LIMIT 3";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("GameId", gameId);

		List<UserInfo> ranking = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return ranking.isEmpty() ? null : ranking;
	}

	public List<UserInfo> findMyRanking(Integer gameId, Integer userId) {
		String sql = "SELECT user_id, rank ,highScore "
				+ "from (SELECT user_id, rank() over (order by(MAX(score))desc) rank, MAX(score) AS highScore "
				+ "FROM scores where game_id = :GameId "
				+ "group by user_id) AS users "
				+ "where user_id = :UserId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("GameId", gameId);
		param.addValue("UserId", userId);

		List<UserInfo> myRank = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return myRank.isEmpty() ? null : myRank;
	}

	public List<UserInfo> higtScoreDate(String userName, Integer gameId) {
		String sql = "SELECT score_date FROM scores join user_info on scores.user_id = user_info.user_id WHERE user_name = :UserName AND game_id = :GameId ORDER BY score DESC LIMIT 1";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserName", userName);
		param.addValue("GameId", gameId);

		List<UserInfo> dateHigtScore = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return dateHigtScore.isEmpty() ? null : dateHigtScore;
	}

	@Override
	public void coinWast(Integer userId) {
		String sql = "UPDATE user_info SET coin_have = coin_have - 30 WHERE user_id = :UserId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);

		jdbcTemplate.update(sql, param);

	}

	@Override
	public List<UserInfo> userHaveCoin(Integer userId) {
		String sql = "SELECT * FROM user_info WHERE user_id = :UserId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);

		List<UserInfo> userHaveCoin = jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		return userHaveCoin.isEmpty() ? null : userHaveCoin;

	}

	@Override
	public void update(String loginId, String userName, String password, Integer userId) {

		String sql = "UPDATE user_info SET login_id = :LoginId, user_name = :UserName, password = :Password WHERE user_id = :UserId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("LoginId", loginId);
		param.addValue("UserName", userName);
		param.addValue("Password", password);
		param.addValue("UserId", userId);

		jdbcTemplate.update(sql, param);

	}

	@Override
	public List<UserInfo> findByUserName(String userName) {

		String sql = "SELECT * FROM user_info WHERE user_name = :UserName";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserName", userName);

		List<UserInfo> result2 = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return result2.isEmpty() ? null : result2;

	}

	@Override
	public List<UserInfo> findIdUserNamePass(String loginId, String userName, String password) {

		String sql = "SELECT * FROM user_info WHERE login_id = :LoginId AND user_name = :UserName AND password = :Password";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("LoginId", loginId);
		param.addValue("UserName", userName);
		param.addValue("Password", password);

		List<UserInfo> resultList3 = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return resultList3.isEmpty() ? null : resultList3;

	}


	//付けたし
	public UserInfo getCoin(Integer userId) {

		String sql = "SELECT * FROM user_info WHERE user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<UserInfo> resultList = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return resultList.isEmpty() ? null : resultList.get(0);

	}

	//付けたし
	public void subCoin(Integer userId,Integer coin) {
		String sql = "UPDATE user_info SET coin_have = coin_have - :coin WHERE user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("coin", coin);
		jdbcTemplate.update(sql,param);
	}

	public void plusCoin(Integer userId,Integer coin) {
		String sql = "UPDATE user_info SET coin_have = coin_have + :coin WHERE user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("coin", coin);
		jdbcTemplate.update(sql,param);
	}

	@Override
	public void updatelogin_date(String loginId) {

		String sql = "UPDATE user_info SET login_date = current_date WHERE login_id = :LoginId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("LoginId", loginId);

		jdbcTemplate.update(sql,param);

	}


}
