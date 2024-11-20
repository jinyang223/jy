package com.seiryo.entity;

/**
 * @ClassName: MyUserInfo
 * @Description: ユーザー詳細情報の実体クラス
 * @author JY
 * @date 2024-11-04 10:12:47
 */
public class MyUserInfo extends MyUser{
	
	//ユーザー情報id
	private Integer user_info_id;
	
	//ユーザーの電話番号
	private String user_phone;
	
	//ユーザー残高
	private String user_money;
	
	//ユーザー名
	private String user_name;
	
	//ユーザーの誕生日
	private String user_birthday;
	
	//ユーザーの性別
	private String user_sex;
	
	//ユーザーの状態
	private Integer user_status;

	/**
	 * 
	 * MyUserInfoの初期設定をおこなう（引数を持つコンストラクタ）
	 *
	 * @param user_id
	 * @param user_email
	 * @param user_password
	 * @param user_info_id
	 * @param user_phone
	 * @param user_money
	 * @param user_name
	 * @param user_birthday
	 * @param user_sex
	 * @param user_status
	 */
	public MyUserInfo(Integer user_id, String user_email, String user_password, Integer user_info_id,
			String user_phone, String user_money, String user_name, String user_birthday, String user_sex,
			Integer user_status) {
		super(user_id, user_email, user_password);
		this.user_info_id = user_info_id;
		this.user_phone = user_phone;
		this.user_money = user_money;
		this.user_name = user_name;
		this.user_birthday = user_birthday;
		this.user_sex = user_sex;
		this.user_status = user_status;
	}

	/**
	 * MyUserInfoの初期設定をおこなう（引数なしコンストラクタ）
	 *
	 * @param user_id
	 * @param user_email
	 * @param user_password
	 */
	public MyUserInfo(Integer user_id, String user_email, String user_password) {
		super(user_id, user_email, user_password);
	}

	/**
	 * ユーザー情報idを取得する
	 *  
	 * @return ユーザー情報id    
	 */
	public Integer getUser_info_id() {
		return user_info_id;
	}

	/**
	 * ユーザー情報idを設定する
	 * 
	 * @param user_info_id を設定するユーザー情報id
	 */
	public void setUser_info_id(Integer user_info_id) {
		this.user_info_id = user_info_id;
	}

	/**
	 * ユーザーの電話番号を取得する
	 *  
	 * @return ユーザーの電話番号   
	 */
	public String getUser_phone() {
		return user_phone;
	}

	/**
	 * ユーザーの電話番号を設定する
	 * 
	 * @param user_phone を設定するユーザーの電話番号
	 */
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	/**
	 * ユーザー残高を取得する
	 *  
	 * @return ユーザー残高 
	 */
	public String getUser_money() {
		return user_money;
	}

	/**
	 * ユーザー残高を設定する
	 * 
	 * @param user_money を設定するユーザー残高 
	 */
	public void setUser_money(String user_money) {
		this.user_money = user_money;
	}

	/**
	 * ユーザー名を取得する
	 *  
	 * @return ユーザー名
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * ユーザー名を設定する
	 * 
	 * @param user_name を設定するユーザー名
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * ユーザーの誕生日
	 *  
	 * @return ユーザーの誕生日    
	 */
	public String getUser_birthday() {
		return user_birthday;
	}

	/**
	 * ユーザーの誕生日を設定する
	 * 
	 * @param user_birthday を設定するユーザーの誕生日
	 */
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	/**
	 * ユーザーの性別
	 *  
	 * @return ユーザーの性別  
	 */
	public String getUser_sex() {
		return user_sex;
	}

	/**
	 * ユーザーの性別を設定する
	 * 
	 * @param user_sex を設定するユーザーの性別
	 */
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	/**
	 * ユーザーの状態
	 *  
	 * @return ユーザーの状態  
	 */
	public Integer getUser_status() {
		return user_status;
	}

	/**
	 * ユーザーの状態  を設定する
	 * 
	 * @param user_status を設定するユーザーの状態  
	 */
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}

	/**
	 * toString メソッド
	 */
	@Override
	public String toString() {
		return "MyUserInfo [user_info_id=" + user_info_id + ", user_phone=" + user_phone
				+ ", user_money=" + user_money + ", user_name=" + user_name + ", user_birthday=" + user_birthday
				+ ", user_sex=" + user_sex + ", user_status=" + user_status + "]";
	}

}
