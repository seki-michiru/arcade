package jp.co.example.controller.form;

import javax.validation.constraints.NotBlank;

public class UserInfoForm {

	@NotBlank(message="IDは必須です")
	private String loginId;
	@NotBlank(message="名前は必須です")
	private String userName;
	@NotBlank(message="PASSは必須です")
	private String password;
//	private Integer userId;

//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
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


}
