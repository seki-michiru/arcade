package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ItemDao;
import jp.co.example.entity.Items;

@Repository
public class PgItemsDao implements ItemDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public List<Items> findAll() {
		String sql = "SELECT * FROM items ORDER BY item_id";
		List<Items> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Items>(Items.class));
		return result.isEmpty() ? null : result;
	}

	public List<Items> gachaItem(Integer itemId) {
		String sql = "SELECT * FROM items WHERE item_id = :ItemId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("ItemId", itemId);
		List<Items> result = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Items>(Items.class));
		return result.isEmpty() ? null : result;
	}

	public List<Items> findItemName(Integer itemId) {
		String sql = "SELECT * FROM items WHERE item_id = :itemId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("itemId", itemId);
		List<Items> result = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<Items>(Items.class));
		return result;
	}

	public List<Items> havingItem(Integer userId) {
		String sql = "SELECT items.item_id,game_name,item_name" +
				" FROM items" +
				" JOIN games" +
				" ON items.game_id = games.game_id" +
				" JOIN item_stocks" +
				" ON items.item_id = item_stocks.item_id" +
				" WHERE item_have > 0" +
				" AND user_id = :UserId" +
				" ORDER BY items.item_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);
		List<Items> result = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Items>(Items.class));
		return result.isEmpty() ? null : result;
	}

	public List<Items> itemAll() {
		String sql = "SELECT items.game_id,game_name,item_id,item_name,item_price FROM games JOIN items ON games.game_id = items.game_id ORDER BY games.game_id,items.item_price";
		List<Items> result = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Items>(Items.class));
		return result.isEmpty() ? null : result;
	}

	public Items getItemNameEffect(Integer itemId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = "SELECT item_name,item_effect FROM items WHERE item_id = :itemId";
		param.addValue("itemId", itemId);
		List<Items> result = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Items>(Items.class));
		return result.isEmpty() ? null : result.get(0);
	}
}