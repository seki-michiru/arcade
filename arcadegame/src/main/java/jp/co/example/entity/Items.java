package jp.co.example.entity;

public class Items {

	private Integer itemId;
	private Integer gameId;
	private String itemName;
	private Integer itemPrice;
	private Integer itemEffects;
	private String itemExplan;

	public Items() {



	}


	public Items(Integer itemId, Integer gameId, String itemName, Integer itemPrice, Integer itemEffects, String itemExplan) {

		this.itemId = itemId;
		this.gameId = gameId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemEffects = itemEffects;
		this.itemExplan = itemExplan;

	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public Integer getGameId() {
		return gameId;
	}


	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Integer getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}


	public Integer getItemEffects() {
		return itemEffects;
	}


	public void setItemEffects(Integer itemEffects) {
		this.itemEffects = itemEffects;
	}


	public String getItemExplan() {
		return itemExplan;
	}


	public void setItemExplan(String itemExplan) {
		this.itemExplan = itemExplan;
	}






}
