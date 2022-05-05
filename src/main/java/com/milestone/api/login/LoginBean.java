package com.milestone.api.login;

import com.milestone.api.exception.UserValidation;

import javax.validation.constraints.*;


public class LoginBean {

private int loginId, loginRoleId;

	@NotNull(message = "username shouldn't be null")
	@NotBlank(message = "user must noy be blank")
@UserValidation
private String loginName;
//	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
//	@Min(18)
//	@Max(60)
	private String loginPassword;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	private String roleName;



public LoginBean() {
	super();
	// TODO Auto-generated constructor stub
}
public LoginBean(int loginId, int loginRoleId, String loginName, String loginPassword, String roleName) {
	super();
	this.loginId = loginId;
	this.loginRoleId = loginRoleId;
	this.loginName = loginName;
	this.loginPassword = loginPassword;
	this.roleName = roleName;
}
public int getLoginId() {
	return loginId;
}
public void setLoginId(int loginId) {
	this.loginId = loginId;
}
public int getLoginRoleId() {
	return loginRoleId;
}
public void setLoginRoleId(int loginRoleId) {
	this.loginRoleId = loginRoleId;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public String getLoginPassword() {
	return loginPassword;
}
public void setLoginPassword(String loginPassword) {
	this.loginPassword = loginPassword;
}



}
