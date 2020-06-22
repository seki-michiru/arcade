package jp.co.example.entity;

public class ItemStocks {

	private Integer userId;
	private Integer itemId;
	private Integer itemHave;

	//付けたし
	private String gameName;
	private String itemName;
	private Integer price;

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

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}






}
