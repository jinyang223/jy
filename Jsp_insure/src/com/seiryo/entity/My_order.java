package com.seiryo.entity;

/**
 * @ClassName: My_order
 * @Description: 注文情報の実体クラス
 * @author JY
 */
public class My_order {
	
	//注文番号
	private String order_id;
	
	//ユーザー番号
	private Integer user_id;
	
	//商品コード
	private Integer commodity_id;

	/**
	 * My_orderの初期設定をおこなう（引数を持つコンストラクタ）
	 *
	 * @param order_id
	 * @param user_id
	 * @param commodity_id
	 */
	public My_order(String order_id, Integer user_id, Integer commodity_id) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.commodity_id = commodity_id;
	}

	/**
	 * My_orderの初期設定をおこなう（引数なしのコンストラクタ）
	 */
	public My_order() {
		super();
	}

	/**
	 * 注文番号を取得する
	 *  
	 * @return 注文番号  
	 */
	public String getOrder_id() {
		return order_id;
	}

	/**
	 * 注文番号を設定する
	 * 
	 * @param order_id を設定する注文番号
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	/**
	 * ユーザー番号を取得する
	 * 
	 * @return ユーザー番号  
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**
	 * ユーザー番号を設定する
	 * 
	 * @param user_id を設定するユーザー番号
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	/**
	 * 商品コードを取得する
	 *  
	 * @return 商品コード    
	 */
	public Integer getCommodity_id() {
		return commodity_id;
	}

	/**
	 * 商品コードを設定する
	 * 
	 * @param commodity_id を設定する商品コード
	 */
	public void setCommodity_id(Integer commodity_id) {
		this.commodity_id = commodity_id;
	}

	/**
	 * toString メソッド
	 */
	@Override
	public String toString() {
		return "My_order [order_id=" + order_id + ", user_id=" + user_id + ", commodity_id=" + commodity_id + "]";
	}

}
