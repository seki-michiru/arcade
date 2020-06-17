package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ItemsDao;
import jp.co.example.entity.Items;

@Repository
public class PgItemDao implements ItemsDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Items> findAll(){
		String sql = "SELECT * FROM items";
	List<Items> result = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Items>(Items.class));
	return result.isEmpty() ? null : result;
	}
}