package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ItemStocksDao;

@Repository
public class PgItemStocksDao implements ItemStocksDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void itemCollect(Integer userId,Integer itemId) {
		String sql = "UPDATE item_stocks SET item_have = item_have + 1 WHERE user_id = :UserId AND item_id = :ItemId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);
		param.addValue("ItemId",itemId );
		jdbcTemplate.update(sql, param);
	}
}