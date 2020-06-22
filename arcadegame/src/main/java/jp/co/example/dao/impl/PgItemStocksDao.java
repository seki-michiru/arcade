package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ItemStocksDao;
import jp.co.example.entity.ItemStocks;
import jp.co.example.entity.Items;

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


	public void plusStock(Integer userId, Integer itemId, Integer number) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = "UPDATE item_stocks SET item_have = item_have + :number WHERE user_id = :userId AND item_id = :itemId";
		param.addValue("number", number);
		param.addValue("userId", userId);
		param.addValue("itemId", itemId);
		jdbcTemplate.update(sql, param);
	}

	public List<ItemStocks> findStockAll(Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = "SELECT item_stocks.item_id,game_name,item_name,item_price/2 price,item_have FROM games JOIN items ON items.game_id = games.game_id JOIN item_stocks ON item_stocks.item_id = items.item_id WHERE user_id = :userId AND item_have > 0";
		param.addValue("userId", userId);
		List<ItemStocks> result = jdbcTemplate.query(sql,param,new BeanPropertyRowMapper<ItemStocks>(ItemStocks.class));
		return result.isEmpty() ? null : result;
	}

	public void minusStock(Integer userId, Integer itemId, Integer number) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = "UPDATE item_stocks SET item_have = item_have - :number WHERE user_id = :userId AND item_id = :itemId";
		param.addValue("number", number);
		param.addValue("userId", userId);
		param.addValue("itemId", itemId);
		jdbcTemplate.update(sql, param);
	}

	public List<Items> getStockItem(Integer userId, Integer gameId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = "SELECT item_stocks.item_id,items.item_name FROM item_stocks JOIN items ON item_stocks.item_id = items.item_id WHERE user_id = :userId AND game_id = :gameId AND item_have > 0;";
		param.addValue("userId", userId);
		param.addValue("gameId", gameId);
		List<Items> result = jdbcTemplate.query(sql,param,new BeanPropertyRowMapper<Items>(Items.class));
		return result.isEmpty() ? null : result;
	}
}