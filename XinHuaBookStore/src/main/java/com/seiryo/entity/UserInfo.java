package com.seiryo.entity;

/**
 * @ClassName: UserInfo
 * @Description: 用户实体类
 * @author JY
 */
public class UserInfo {
	
	//用户ID
	private Integer userId;
	
	//用户账号
	private String userAccount;
	
	//用户密码
	private String userPass;
	
	//用户昵称
	private String userNickName;
	
	//用户头像
	private String userAvatar;
	
	//用户状态 1正常/0注销
	private String userStatus;
	
	//用户类型 0普通用户/1管理员
	private String userType;

	//get和set方法
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * UserInfoの初期設定をおこなう（コンストラクタ）
	 *
	 * @param userId
	 * @param userAccount
	 * @param userPass
	 * @param userNickName
	 * @param userAvatar
	 * @param userStatus
	 * @param userType
	 */
	public UserInfo(Integer userId, String userAccount, String userPass, String userNickName, String userAvatar,
			String userStatus, String userType) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userPass = userPass;
		this.userNickName = userNickName;
		this.userAvatar = userAvatar;
		this.userStatus = userStatus;
		this.userType = userType;
	}

	/**
	 * UserInfoの初期設定をおこなう（コンストラクタ）
	 */
	public UserInfo() {
		super();
	}

	/**
	 * toString方法
	 */
	public String toString() {
		return "UserInfo [userId=" + userId + ", userAccount=" + userAccount + ", userPass=" + userPass
				+ ", userNickName=" + userNickName + ", userAvatar=" + userAvatar + ", userStatus=" + userStatus
				+ ", userType=" + userType + "]";
	}

}
