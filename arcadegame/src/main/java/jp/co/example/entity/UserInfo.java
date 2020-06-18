package jp.co.example.entity;

import java.util.Date;

public class UserInfo {

	private Integer userId;
	private String loginId;
	private String userName;
	private String password;
	private Integer coinHave;
	private Date createDate;
	private Date updateDate;
	private Date loginDate;
	private String itemName;
	private String itemExplan;
	private String gameName;
	private Integer itemHave;

	public UserInfo() {

	}

	public UserInfo(Integer userId, String loginId, String userName, String password, Integer coinHave, Date createDate, Date updateDate, Date loginDate) {

		this.userId = userId;
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.coinHave = coinHave;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.loginDate = loginDate;

	}

	public UserInfo(Integer userId, String gameName, String itemName, String itemExplan, Integer itemHave) {
		this.userId = userId;
		this.gameName = gameName;
		this.itemName = itemName;
		this.itemExplan = itemExplan;
		this.itemHave = itemHave;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemExplan() {
		return itemExplan;
	}

	public void setItemExplan(String itemExplan) {
		this.itemExplan = itemExplan;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Integer getItemHave() {
		return itemHave;
	}

	public void setItemHave(Integer itemHave) {
		this.itemHave = itemHave;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCoinHave() {
		return coinHave;
	}

	public void setCoinHave(Integer coinHave) {
		this.coinHave = coinHave;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}







}
