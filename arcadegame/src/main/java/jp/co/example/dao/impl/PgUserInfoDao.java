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

	public UserInfo findIdPass(String loginId, String password) {

		String sql = "SELECT * FROM user_info WHERE login_id = :loginId AND password = :password";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		param.addValue("password", password);

		List<UserInfo> resultList = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return resultList.isEmpty() ? null : resultList.get(0);

	}

	public void insert(String loginId, String userName, String password) {

		String sql = "INSERT INTO user_info (login_id, user_name, password) VALUES (:LoginId, :UserName, :Password)";

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

	public void coinWast(Integer userId) {
		String sql = "UPDATE user_info SET coin_have = coin_have - 30 WHERE user_id = :UserId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);

		jdbcTemplate.update(sql, param);
	}
}
