package jp.co.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.entity.UserInfo;

@Repository
public class PgUserInfoDao implements UserInfoDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<UserInfo> findAll() {

		String sql = "SELECT * FROM user_info";
		List<UserInfo> result = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));


	}

	public UserInfo findIdPass(Integer roginId, String password) {

		String sql = "SELECT * FROM user_info WHERE rogin_id = ? AND password = ?";

	}


	public void insert(Integer roginId, String userName, String password) {

		String sql = "INSERT INTO user_info (rogin_id, user_name, password) VALUES (?, ?, ?)";


	}

}
