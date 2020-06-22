package jp.co.example.entity;

public class BuyInfo {

	private String itemName;
	private Integer number;

	public BuyInfo() {
	}

	public BuyInfo(String itemName, Integer number) {
		super();
		this.itemName = itemName;
		this.number = number;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
