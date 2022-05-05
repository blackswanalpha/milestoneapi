package com.milestone.api.user;

public class UserBean {

	private int userId;
	private int userMobile;
	private int userLoginId;



	private String userFullName;

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	private String loginUserName;
	private String userEmail;
	private String userimageUrl;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(int userId, int userMobile, int userLoginId, String userFullName,
					String loginUserName, String userEmail, String userimageUrl) {
		super();
		this.userId = userId;
		this.userMobile = userMobile;
		this.userLoginId = userLoginId;
		this.userFullName = userFullName;
		this.loginUserName = loginUserName;
		this.userimageUrl = userimageUrl;
		this.userEmail = userEmail;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(int userMobile) {
		this.userMobile = userMobile;
	}
	public int getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserimageUrl() {
		return userimageUrl;
	}

	public void setUserimageUrl(String userimageUrl) {
		this.userimageUrl = userimageUrl;
	}
	
	
	
}
