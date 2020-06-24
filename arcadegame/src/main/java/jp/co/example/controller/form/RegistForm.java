package jp.co.example.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class RegistForm {

	private Integer userId;
	@NotBlank(message="IDは必須です")
	@Length(max=50, message="50文字以内で入力してください")
	private String loginId;
	@NotBlank(message="名前は必須です")
	@Length(max=50, message="50文字以内で入力してください")
	private String userName;
	@NotBlank(message="PASSは必須です")
	@Length(max=50, message="50文字以内で入力してください")
	private String password;


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


}
