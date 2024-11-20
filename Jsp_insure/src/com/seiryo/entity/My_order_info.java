package com.seiryo.entity;

/**
 * @ClassName: My_order_info
 * @Description: 注文詳細情報の実体クラス
 * @author JY
 */
public class My_order_info extends My_order{
	
	//注文情報id
	private Integer order_info_id;
	
	//注文商品責任1
	private String order_commodity_liability1;
	
	//注文商品責任2
	private String order_commodity_liability2;
	
	//注文商品責任3
	private String order_commodity_liability3;
	
	//注文商品責任4
	private String order_commodity_liability4;
	
	//注文商品責任5
	private String order_commodity_liability5;
	
	//注文商品責任6
	private String order_commodity_liability6;
	
	//注文商品責任7
	private String order_commodity_liability7;
	
	//注文受益者名
	private String order_beneficiary_name;
	
	//注文受益者の年齢
	private String order_beneficiary_age;
	
	//注文受益者の携帯電話
	private String order_beneficiary_phone;

	//注文商品の開始時間
	private String order_commodity_time_start;
	
	//注文商品の終了時間
	private String order_commodity_time_end;
	
	//注文商品の時間長さ
	private String order_commodity_time_length;
	
	//注文総価格
	private String order_sum_price;

	/**
	 * My_order_infoの初期設定をおこなう（引数を持つコンストラクタ）
	 *
	 * @param order_id
	 * @param user_id
	 * @param commodity_id
	 * @param order_info_id
	 * @param order_commodity_liability1
	 * @param order_commodity_liability2
	 * @param order_commodity_liability3
	 * @param order_commodity_liability4
	 * @param order_commodity_liability5
	 * @param order_commodity_liability6
	 * @param order_commodity_liability7
	 * @param order_beneficiary_name
	 * @param order_beneficiary_age
	 * @param order_beneficiary_phone
	 * @param order_commodity_time_start
	 * @param order_commodity_time_end
	 * @param order_commodity_time_length
	 * @param order_sum_price
	 */
	public My_order_info(String order_id, Integer user_id, Integer commodity_id, Integer order_info_id,
			String order_commodity_liability1, String order_commodity_liability2, String order_commodity_liability3,
			String order_commodity_liability4, String order_commodity_liability5, String order_commodity_liability6,
			String order_commodity_liability7, String order_beneficiary_name, String order_beneficiary_age,
			String order_beneficiary_phone, String order_commodity_time_start, String order_commodity_time_end,
			String order_commodity_time_length, String order_sum_price) {
		super(order_id, user_id, commodity_id);
		this.order_info_id = order_info_id;
		this.order_commodity_liability1 = order_commodity_liability1;
		this.order_commodity_liability2 = order_commodity_liability2;
		this.order_commodity_liability3 = order_commodity_liability3;
		this.order_commodity_liability4 = order_commodity_liability4;
		this.order_commodity_liability5 = order_commodity_liability5;
		this.order_commodity_liability6 = order_commodity_liability6;
		this.order_commodity_liability7 = order_commodity_liability7;
		this.order_beneficiary_name = order_beneficiary_name;
		this.order_beneficiary_age = order_beneficiary_age;
		this.order_beneficiary_phone = order_beneficiary_phone;
		this.order_commodity_time_start = order_commodity_time_start;
		this.order_commodity_time_end = order_commodity_time_end;
		this.order_commodity_time_length = order_commodity_time_length;
		this.order_sum_price = order_sum_price;
	}

	/**
	 * My_order_infoの初期設定をおこなう（引数なしのコンストラクタ）
	 */
	public My_order_info() {
		super();
	}

	/**
	 * My_order_infoの初期設定をおこなう（引数を持つコンストラクタ）
	 *
	 * @param order_id
	 * @param user_id
	 * @param commodity_id
	 */
	public My_order_info(String order_id, Integer user_id, Integer commodity_id) {
		super(order_id, user_id, commodity_id);
	}

	/**
	 * 注文情報idを取得する
	 *  
	 * @return 注文情報id 
	 */
	public Integer getOrder_info_id() {
		return order_info_id;
	}

	/**
	 * 注文情報idを設定する
	 * 
	 * @param order_info_id を設定する注文情報id
	 */
	public void setOrder_info_id(Integer order_info_id) {
		this.order_info_id = order_info_id;
	}

	/**
	 * 注文商品責任1を取得する
	 *  
	 * @return 注文商品責任1   
	 */
	public String getOrder_commodity_liability1() {
		return order_commodity_liability1;
	}

	/**
	 * 注文商品責任1を設定する
	 * 
	 * @param order_commodity_liability1 を設定する注文商品責任1
	 */
	public void setOrder_commodity_liability1(String order_commodity_liability1) {
		this.order_commodity_liability1 = order_commodity_liability1;
	}

	/**
	 * 注文商品責任2を取得する
	 *  
	 * @return 注文商品責任2
	 */
	public String getOrder_commodity_liability2() {
		return order_commodity_liability2;
	}

	/**
	 * 注文商品責任2を設定する
	 * 
	 * @param order_commodity_liability2 を設定する注文商品責任2
	 */
	public void setOrder_commodity_liability2(String order_commodity_liability2) {
		this.order_commodity_liability2 = order_commodity_liability2;
	}

	/**
	 * 注文商品責任3を取得する
	 *  
	 * @return 注文商品責任3   
	 */
	public String getOrder_commodity_liability3() {
		return order_commodity_liability3;
	}

	/**
	 * 注文商品責任3を設定する
	 * 
	 * @param order_commodity_liability3 を設定する注文商品責任3
	 */
	public void setOrder_commodity_liability3(String order_commodity_liability3) {
		this.order_commodity_liability3 = order_commodity_liability3;
	}

	/**
	 * 注文商品責任4を取得する
	 *  
	 * @return 注文商品責任4   
	 */
	public String getOrder_commodity_liability4() {
		return order_commodity_liability4;
	}

	/**
	 * 注文商品責任4を設定する
	 * 
	 * @param order_commodity_liability4 を設定する注文商品責任4
	 */
	public void setOrder_commodity_liability4(String order_commodity_liability4) {
		this.order_commodity_liability4 = order_commodity_liability4;
	}

	/**
	 * 注文商品責任5を取得する
	 *  
	 * @return 注文商品責任5    
	 */
	public String getOrder_commodity_liability5() {
		return order_commodity_liability5;
	}

	/**
	 * 注文商品責任5を設定する
	 * 
	 * @param order_commodity_liability5 を設定する注文商品責任5
	 */
	public void setOrder_commodity_liability5(String order_commodity_liability5) {
		this.order_commodity_liability5 = order_commodity_liability5;
	}

	/**
	 * 注文商品責任6を取得する
	 *  
	 * @return 注文商品責任6  
	 */
	public String getOrder_commodity_liability6() {
		return order_commodity_liability6;
	}

	/**
	 * 注文商品責任6を設定する
	 * 
	 * @param order_commodity_liability6 を設定する注文商品責任6
	 */
	public void setOrder_commodity_liability6(String order_commodity_liability6) {
		this.order_commodity_liability6 = order_commodity_liability6;
	}

	/**
	 * 注文商品責任7を取得する
	 *  
	 * @return 注文商品責任7 
	 */
	public String getOrder_commodity_liability7() {
		return order_commodity_liability7;
	}

	/**
	 * 注文商品責任7を設定する
	 * 
	 * @param order_commodity_liability7 を設定する注文商品責任7
	 */
	public void setOrder_commodity_liability7(String order_commodity_liability7) {
		this.order_commodity_liability7 = order_commodity_liability7;
	}

	/**
	 * 注文受益者名を取得する
	 *  
	 * @return 注文受益者名  
	 */
	public String getOrder_beneficiary_name() {
		return order_beneficiary_name;
	}

	/**
	 * 注文受益者名を設定する
	 * 
	 * @param order_beneficiary_name を設定する注文受益者名
	 */
	public void setOrder_beneficiary_name(String order_beneficiary_name) {
		this.order_beneficiary_name = order_beneficiary_name;
	}

	/**
	 * 注文受益者の年齢を取得する
	 *  
	 * @return 注文受益者の所在都市  
	 */
	public String getOrder_beneficiary_age() {
		return order_beneficiary_age;
	}

	/**
	 * 注文受益者の年齢を設定する
	 * 
	 * @param order_beneficiary_age を設定する注文受益者の年齢
	 */
	public void setOrder_beneficiary_age(String order_beneficiary_age) {
		this.order_beneficiary_age = order_beneficiary_age;
	}

	/**
	 * 注文受益者の携帯電話を取得する
	 *  
	 * @return 注文受益者の携帯電話  
	 */
	public String getOrder_beneficiary_phone() {
		return order_beneficiary_phone;
	}

	/**
	 * 注文受益者の携帯電話を設定する
	 * 
	 * @param order_beneficiary_phone を設定する注文受益者の携帯電話
	 */
	public void setOrder_beneficiary_phone(String order_beneficiary_phone) {
		this.order_beneficiary_phone = order_beneficiary_phone;
	}

	/**
	 * 注文商品の開始時間を取得する
	 *  
	 * @return 注文商品の開始時間
	 */
	public String getOrder_commodity_time_start() {
		return order_commodity_time_start;
	}

	/**
	 * 注文商品の開始時間を設定する
	 * 
	 * @param order_commodity_time_start を設定する注文商品の開始時間
	 */
	public void setOrder_commodity_time_start(String order_commodity_time_start) {
		this.order_commodity_time_start = order_commodity_time_start;
	}

	/**
	 * 注文商品の終了時間取得する
	 *  
	 * @return 注文商品の終了時間  
	 */
	public String getOrder_commodity_time_end() {
		return order_commodity_time_end;
	}

	/**
	 * 注文商品の終了時間を設定する
	 * 
	 * @param order_commodity_time_end を設定する注文商品の終了時間
	 */
	public void setOrder_commodity_time_end(String order_commodity_time_end) {
		this.order_commodity_time_end = order_commodity_time_end;
	}

	/**
	 * 注文商品の時間長さを取得する
	 *  
	 * @return 注文商品の時間長さ
	 */
	public String getOrder_commodity_time_length() {
		return order_commodity_time_length;
	}

	/**
	 * 注文商品の時間長さを設定する
	 * 
	 * @param order_commodity_time_length を設定する注文商品の時間長さ
	 */
	public void setOrder_commodity_time_length(String order_commodity_time_length) {
		this.order_commodity_time_length = order_commodity_time_length;
	}

	/**
	 * 注文総価格を取得する
	 *  
	 * @return 注文総価格   
	 */
	public String getOrder_sum_price() {
		return order_sum_price;
	}

	/**
	 * 注文総価格を設定する
	 * 
	 * @param order_sum_price を設定する注文総価格
	 */
	public void setOrder_sum_price(String order_sum_price) {
		this.order_sum_price = order_sum_price;
	}

	/**
	 * toString メソッド
	 */
	@Override
	public String toString() {
		return "My_order_info [order_info_id=" + order_info_id + ", order_commodity_liability1="
				+ order_commodity_liability1 + ", order_commodity_liability2=" + order_commodity_liability2
				+ ", order_commodity_liability3=" + order_commodity_liability3 + ", order_commodity_liability4="
				+ order_commodity_liability4 + ", order_commodity_liability5=" + order_commodity_liability5
				+ ", order_commodity_liability6=" + order_commodity_liability6 + ", order_commodity_liability7="
				+ order_commodity_liability7 + ", order_beneficiary_name=" + order_beneficiary_name
				+ ", order_beneficiary_age=" + order_beneficiary_age + ", order_beneficiary_phone="
				+ order_beneficiary_phone + ", order_commodity_time_start=" + order_commodity_time_start
				+ ", order_commodity_time_end=" + order_commodity_time_end + ", order_commodity_time_length="
				+ order_commodity_time_length + ", order_sum_price=" + order_sum_price + "]";
	}

}
