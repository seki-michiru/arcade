package jp.co.example.entity;

import java.util.Date;

public class Trades {

	private Integer saleId;
	private Integer userId;
	private Date tradeDate;

	public Trades() {



	}

	public Trades(Integer saleId, Integer userId, Date tradeDate) {

		this.saleId = saleId;
		this.userId = userId;
		this.tradeDate = tradeDate;

	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}




}
