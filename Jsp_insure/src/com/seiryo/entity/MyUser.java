package com.seiryo.entity;

/**
 * @ClassName: MyUser
 * @Description: ユーザー情報の実体クラス
 * @author JY
 */
public class MyUser {
	
	//ユーザーのid
	private Integer user_id;
	
	//ユーザーのメール
	private String user_email;
	
	//ユーザーのパスワード
	private String user_password;

	/**
	 * MyUserの初期設定をおこなう（引数を持つコンストラクタ）
	 *
	 * @param user_id
	 * @param user_email
	 * @param user_password
	 */
	public MyUser(Integer user_id, String user_email, String user_password) {
		super();
		this.user_id = user_id;
		this.user_email = user_email;
		this.user_password = user_password;
	}

	/**
	 * MyUserの初期設定をおこなう（引数なしのコンストラクタ）
	 */
	public MyUser() {
		super();
	}

	/**
	 * ユーザーのidを取得する
	 * 
	 * @return ユーザーのid    
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**
	 * ユーザーのidを設定する
	 * 
	 * @param user_id を設定するユーザーのid
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	/**
	 * ユーザーのメールを取得する
	 *  
	 * @return ユーザーのメール    
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * ユーザーのメールを設定する
	 * 
	 * @param user_email を設定するユーザーのメール
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	/**
	 * ユーザーのパスワードを取得する
	 *
	 * @return ユーザーのパスワード    
	 */
	public String getUser_password() {
		return user_password;
	}

	/**
	 * ユーザーのパスワードを設定する
	 * 
	 * @param user_password を設定するユーザーのパスワード
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * toString メソッド
	 */
	@Override
	public String toString() {
		return "My_user [user_id=" + user_id + ", user_email=" + user_email + ", user_password=" + user_password + "]";
	}

}
