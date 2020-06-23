package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.TradesDao;

@Repository
public class PgTradesDao implements TradesDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void marketLog(Integer salesId, Integer userId) {
		String sql = "INSERT INTO trades (sale_id,user_id,trade_date)"
				+" VALUES (:SalesId,:UserId,CURRENT_DATE);";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("SalesId", salesId);
		param.addValue("UserId", userId);
		jdbcTemplate.update(sql, param);

	}

}
