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
import jp.co.example.entity.UserInfo;

@Repository
public class PgItemStocksDao implements ItemStocksDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void itemCollect(Integer userId, Integer itemId) {
		String sql = "UPDATE item_stocks SET item_have = item_have + 1 WHERE user_id = :UserId AND item_id = :ItemId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("UserId", userId);
		param.addValue("ItemId", itemId);
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
		String sql = "SELECT item_stocks.item_id,game_name,item_name,item_price/2 price,item_have FROM games JOIN items ON items.game_id = games.game_id JOIN item_stocks ON item_stocks.item_id = items.item_id WHERE user_id = :userId AND item_have > 0"
				+" ORDER BY games.game_id,items.item_price";
		param.addValue("userId", userId);
		List<ItemStocks> result = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<ItemStocks>(ItemStocks.class));
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
		String sql = "SELECT item_stocks.item_id,items.item_name FROM item_stocks JOIN items ON item_stocks.item_id = items.item_id WHERE user_id = :userId AND game_id = :gameId AND item_have > 0 ORDER BY items.item_id;";
		param.addValue("userId", userId);
		param.addValue("gameId", gameId);
		List<Items> result = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Items>(Items.class));
		return result.isEmpty() ? null : result;
	}

	@Override
	public void itemWast(Integer userId, Integer giveItem) {
		//出品者のアイテム減らす
		MapSqlParameterSource param1 = new MapSqlParameterSource();
		String sql1 = "UPDATE item_stocks SET item_have = item_have - 1"
				+ " WHERE user_id = :UserId"
				+ " AND item_id = :GiveItem";

		param1.addValue("UserId", userId);
		param1.addValue("GiveItem", giveItem);
		jdbcTemplate.update(sql1, param1);
	}

	@Override
	public void itemChange(Integer saleId, Integer userId) {

		//出品者のアイテム増やす
		MapSqlParameterSource param2 = new MapSqlParameterSource();
		String sql2 = "UPDATE item_stocks SET item_have = item_have + 1"
				+ " WHERE item_id = (SELECT take_item AS item_id FROM sales WHERE sale_id = :SaleId)"
				+ " AND user_id = (SELECT user_id FROM sales WHERE sale_id = :SaleId)";

		param2.addValue("SaleId", saleId);
		jdbcTemplate.update(sql2, param2);

		//交換者のアイテム減らす
		MapSqlParameterSource param3 = new MapSqlParameterSource();
		String sql3 = "UPDATE item_stocks SET item_have = item_have - 1"
				+ " WHERE item_id = (SELECT take_item AS item_id FROM sales WHERE sale_id = :SaleId)"
				+ " AND user_id = :UserId";

		param3.addValue("SaleId", saleId);
		param3.addValue("UserId", userId);
		jdbcTemplate.update(sql3, param3);


		//交換者のアイテム増やす
		MapSqlParameterSource param4 = new MapSqlParameterSource();
		String sql4 = "UPDATE item_stocks SET item_have = item_have + 1"
				+ " WHERE item_id = (SELECT give_item AS item_id FROM sales WHERE sale_id = :SaleId)"
				+ " AND user_id = :UserId";
		param4.addValue("SaleId", saleId);
		param4.addValue("UserId", userId);
		jdbcTemplate.update(sql4, param4);
	}

	@Override
	public void itemInsert(String loginId,String password,Integer itemId) {

		String sql1 = "SELECT * FROM user_info WHERE login_id = :loginId AND password = :password";
		String sql = "INSERT INTO item_stocks (user_id, item_id) VALUES (:UserId, 1), (:UserId, 2), (:UserId, 3), (:UserId, 4), (:UserId, 5), (:UserId, 6), (:UserId, 7)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		param.addValue("password", password);

		List<UserInfo> resultList = jdbcTemplate.query(sql1, param,
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		Integer id = resultList.get(0).getUserId();

		param.addValue("UserId", id);
		param.addValue("ItemId", itemId);

		jdbcTemplate.update(sql, param);

	}

	@Override
	public List<ItemStocks> tradeCheck(Integer saleId, Integer userId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = "SELECT item_have FROM item_stocks"
				+ " WHERE item_id = "
				+ "(SELECT take_item AS item_id FROM sales WHERE sale_id = :SaleId)"
				+ " AND user_id = :UserId"
				+ " AND item_have > 0";
		param.addValue("SaleId", saleId);
		param.addValue("UserId", userId);
		List<ItemStocks> result = jdbcTemplate.query(sql, param,
				new BeanPropertyRowMapper<ItemStocks>(ItemStocks.class));
		return result.isEmpty() ? null : result;
	}

	//トレード削除・アイテム返還
	@Override
	public void itemReturn(Integer saleId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		String sql = "UPDATE item_stocks SET item_have = item_have + 1"
				+ " WHERE item_id = (SELECT give_item AS item_id FROM sales WHERE sale_id = :SaleId)"
				+ " AND user_id = (SELECT user_id FROM sales WHERE sale_id = :SaleId)";

		param.addValue("SaleId", saleId);
		jdbcTemplate.update(sql, param);

	}
}