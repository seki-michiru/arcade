package jp.co.example.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class LoginForm {

	@NotBlank(message="IDは必須です。")
	@Length(max=50, message="50文字以内で入力してください")
	private String loginId;
	@NotBlank(message="PASSは必須です。")
	@Length(max=50, message="50文字以内で入力してください")
	private String password;

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




}
