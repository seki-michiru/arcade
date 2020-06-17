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
public class PgUserInfoDao implements UserInfoDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<UserInfo> findAll() {

		String sql = "SELECT * FROM user_info";
		List<UserInfo> result = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return result.isEmpty() ? null : result;


	}

	public UserInfo findIdPass(String roginId, String password) {

		String sql = "SELECT * FROM user_info WHERE rogin_id = :rogin_id AND password = :password";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("roginId", roginId);
		param.addValue("password", password);

		List<UserInfo> resultList = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return resultList.isEmpty() ? null : resultList.get(0);

	}

	public void insert(String roginId, String userName, String password) {

		String sql = "INSERT INTO user_info (rogin_id, user_name, password) VALUES (:roginId, :userName, :password)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("roginId", roginId);
		param.addValue("userName",userName);
		param.addValue("password", password);

		jdbcTemplate.update(sql, param);

	}

}
