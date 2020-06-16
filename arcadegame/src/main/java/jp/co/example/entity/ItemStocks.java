package jp.co.example.entity;

public class ItemStocks {

	private Integer userId;
	private Integer itemId;
	private Integer itemHave;

	public ItemStocks() {



	}

	public ItemStocks(Integer userId, Integer itemId, Integer itemHave) {

		this.userId = userId;
		this.itemId = itemId;
		this.itemHave = itemHave;

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getItemHave() {
		return itemHave;
	}

	public void setItemHave(Integer itemHave) {
		this.itemHave = itemHave;
	}




}
