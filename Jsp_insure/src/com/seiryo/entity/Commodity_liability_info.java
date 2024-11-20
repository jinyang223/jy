package com.seiryo.entity;

/**
 * @ClassName: Commodity
 * @Description: 商品詳細情報の実体クラス
 * @author JY
 */
public class Commodity_liability_info extends Commodity{
	
	//商品責任情報id
	private Integer commodity_liability_info_id;
	
	//商品責任情報1
	private String commodity_liability_info1;
	
	//商品責任情報2
	private String commodity_liability_info2;
	
	//商品責任情報3
	private String commodity_liability_info3;
	
	//商品責任情報4
	private String commodity_liability_info4;
	
	//商品責任情報5
	private String commodity_liability_info5;
	
	//商品責任情報6
	private String commodity_liability_info6;
	
	//商品責任情報7
	private String commodity_liability_info7;

	/**
	 * Commodity_liability_infoの初期設定をおこなう（引数を取るコンストラクタ）
	 *
	 * @param commodity_id
	 * @param commodity_name
	 * @param commodity_price
	 * @param commodity_introduce
	 * @param commodity_img
	 * @param commodity_age_start
	 * @param commodity_age_end
	 * @param commodity_time_length
	 * @param commodity_applicable_gender
	 * @param commodity_applicable_location
	 * @param commodity_signing_form
	 * @param commodity_liability_zjs
	 * @param commodity_detailed_information1
	 * @param commodity_detailed_information2
	 * @param commodity_detailed_information3
	 * @param commodity_type
	 * @param commodity_liability_info_id
	 * @param commodity_liability_info1
	 * @param commodity_liability_info2
	 * @param commodity_liability_info3
	 * @param commodity_liability_info4
	 * @param commodity_liability_info5
	 * @param commodity_liability_info6
	 * @param commodity_liability_info7
	 */
	public Commodity_liability_info(Integer commodity_id, String commodity_name, String commodity_price,
			String commodity_introduce, String commodity_img, Integer commodity_age_start, Integer commodity_age_end,
			String commodity_time_length, Integer commodity_applicable_gender, String commodity_applicable_location,
			String commodity_signing_form, String commodity_liability_zjs, String commodity_detailed_information1,
			String commodity_detailed_information2, String commodity_detailed_information3, String commodity_type,
			Integer commodity_liability_info_id, String commodity_liability_info1, String commodity_liability_info2,
			String commodity_liability_info3, String commodity_liability_info4, String commodity_liability_info5,
			String commodity_liability_info6, String commodity_liability_info7) {
		super(commodity_id, commodity_name, commodity_price, commodity_introduce, commodity_img, commodity_age_start,
				commodity_age_end, commodity_time_length, commodity_applicable_gender, commodity_applicable_location,
				commodity_signing_form, commodity_liability_zjs, commodity_detailed_information1,
				commodity_detailed_information2, commodity_detailed_information3, commodity_type);
		this.commodity_liability_info_id = commodity_liability_info_id;
		this.commodity_liability_info1 = commodity_liability_info1;
		this.commodity_liability_info2 = commodity_liability_info2;
		this.commodity_liability_info3 = commodity_liability_info3;
		this.commodity_liability_info4 = commodity_liability_info4;
		this.commodity_liability_info5 = commodity_liability_info5;
		this.commodity_liability_info6 = commodity_liability_info6;
		this.commodity_liability_info7 = commodity_liability_info7;
	}

	/**
	 * Commodity_liability_infoの初期設定をおこなう（引数なしのコンストラクタ）
	 */
	public Commodity_liability_info() {
		super();
	}

	/**
	 * Commodity_liability_infoの初期設定をおこなう（引数を取るコンストラクタ）
	 *
	 * @param commodity_id
	 * @param commodity_name
	 * @param commodity_price
	 * @param commodity_introduce
	 * @param commodity_img
	 * @param commodity_age_start
	 * @param commodity_age_end
	 * @param commodity_time_length
	 * @param commodity_applicable_gender
	 * @param commodity_applicable_location
	 * @param commodity_signing_form
	 * @param commodity_liability_zjs
	 * @param commodity_detailed_information1
	 * @param commodity_detailed_information2
	 * @param commodity_detailed_information3
	 * @param commodity_type
	 */
	public Commodity_liability_info(Integer commodity_id, String commodity_name, String commodity_price,
			String commodity_introduce, String commodity_img, Integer commodity_age_start, Integer commodity_age_end,
			String commodity_time_length, Integer commodity_applicable_gender, String commodity_applicable_location,
			String commodity_signing_form, String commodity_liability_zjs, String commodity_detailed_information1,
			String commodity_detailed_information2, String commodity_detailed_information3, String commodity_type) {
		super(commodity_id, commodity_name, commodity_price, commodity_introduce, commodity_img, commodity_age_start,
				commodity_age_end, commodity_time_length, commodity_applicable_gender, commodity_applicable_location,
				commodity_signing_form, commodity_liability_zjs, commodity_detailed_information1,
				commodity_detailed_information2, commodity_detailed_information3, commodity_type);
	}

	/**
	 * 商品責任情報idを取得する
	 *  
	 * @return 商品責任情報id 
	 */
	public Integer getCommodity_liability_info_id() {
		return commodity_liability_info_id;
	}

	/**
	 * 商品責任情報idを設定する
	 * 
	 * @param commodity_liability_info_id を設定する商品責任情報id
	 */
	public void setCommodity_liability_info_id(Integer commodity_liability_info_id) {
		this.commodity_liability_info_id = commodity_liability_info_id;
	}

	/**
	 * 商品責任情報1を取得する
	 *  
	 * @return 商品責任情報1
	 */
	public String getCommodity_liability_info1() {
		return commodity_liability_info1;
	}

	/**
	 * 商品責任情報1を設定する
	 * 
	 * @param commodity_liability_info1 を設定する商品責任情報1
	 */
	public void setCommodity_liability_info1(String commodity_liability_info1) {
		this.commodity_liability_info1 = commodity_liability_info1;
	}

	/**
	 * 商品責任情報2を取得する
	 *  
	 * @return 商品責任情報2
	 */
	public String getCommodity_liability_info2() {
		return commodity_liability_info2;
	}

	/**
	 * 商品責任情報2を設定する
	 * 
	 * @param commodity_liability_info2 を設定する商品責任情報2
	 */
	public void setCommodity_liability_info2(String commodity_liability_info2) {
		this.commodity_liability_info2 = commodity_liability_info2;
	}

	/**
	 * 商品責任情報3を取得する
	 *  
	 * @return 商品責任情報3
	 */
	public String getCommodity_liability_info3() {
		return commodity_liability_info3;
	}

	/**
	 * 商品責任情報3を設定する
	 * 
	 * @param commodity_liability_info3 を設定する商品責任情報3
	 */
	public void setCommodity_liability_info3(String commodity_liability_info3) {
		this.commodity_liability_info3 = commodity_liability_info3;
	}

	/**
	 * 商品責任情報4を取得する
	 *  
	 * @return 商品責任情報4
	 */
	public String getCommodity_liability_info4() {
		return commodity_liability_info4;
	}

	/**
	 * 商品責任情報4を設定する
	 * 
	 * @param commodity_liability_info4 を設定する商品責任情報4
	 */
	public void setCommodity_liability_info4(String commodity_liability_info4) {
		this.commodity_liability_info4 = commodity_liability_info4;
	}

	/**
	 * 商品責任情報5を取得する
	 *  
	 * @return 商品責任情報5
	 */
	public String getCommodity_liability_info5() {
		return commodity_liability_info5;
	}

	/**
	 * 商品責任情報5を設定する
	 * 
	 * @param commodity_liability_info5 を設定する商品責任情報5
	 */
	public void setCommodity_liability_info5(String commodity_liability_info5) {
		this.commodity_liability_info5 = commodity_liability_info5;
	}

	/**
	 * 商品責任情報6を取得する
	 *  
	 * @return 商品責任情報6
	 */
	public String getCommodity_liability_info6() {
		return commodity_liability_info6;
	}

	/**
	 * 商品責任情報6を設定する
	 * 
	 * @param commodity_liability_info6 を設定する商品責任情報6
	 */
	public void setCommodity_liability_info6(String commodity_liability_info6) {
		this.commodity_liability_info6 = commodity_liability_info6;
	}

	/**
	 * 商品責任情報7を取得する
	 *  
	 * @return 商品責任情報7
	 */
	public String getCommodity_liability_info7() {
		return commodity_liability_info7;
	}

	/**
	 * 商品責任情報7を設定する
	 * 
	 * @param commodity_liability_info7 を設定する商品責任情報7
	 */
	public void setCommodity_liability_info7(String commodity_liability_info7) {
		this.commodity_liability_info7 = commodity_liability_info7;
	}

	/**
	 * toString メソッド
	 */
	@Override
	public String toString() {
		return "Commodity_liability_info [commodity_liability_info_id=" + commodity_liability_info_id
				+ ", commodity_liability_info1=" + commodity_liability_info1 + ", commodity_liability_info2="
				+ commodity_liability_info2 + ", commodity_liability_info3=" + commodity_liability_info3
				+ ", commodity_liability_info4=" + commodity_liability_info4 + ", commodity_liability_info5="
				+ commodity_liability_info5 + ", commodity_liability_info6=" + commodity_liability_info6
				+ ", commodity_liability_info7=" + commodity_liability_info7 + "]";
	}

}
