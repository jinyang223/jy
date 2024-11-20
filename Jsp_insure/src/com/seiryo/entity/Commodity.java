package com.seiryo.entity;

/**
 * @ClassName: Commodity
 * @Description: 商品情報の実体クラス
 * @author JY
 */
public class Commodity {
	
	//商品の番号
	private Integer commodity_id;

	//商品名
	private String commodity_name;
	
	//商品の価格
	private String commodity_price;
	
	//商品の紹介
	private String commodity_introduce;
	
	//商品の画像
	private String commodity_img;
	
	//商品対象年齢開始
	private Integer commodity_age_start;
	
	//商品対象年齢終了
	private Integer commodity_age_end;
	
	//商品時間の長さ
	private String commodity_time_length;
	
	//商品の適合性别
	private Integer commodity_applicable_gender;
	
	//商品の適合場所
	private String commodity_applicable_location;
	
	//商品署名フォーム
	private String commodity_signing_form;
	
	//商品責任
	private String commodity_liability_zjs;
	
	//商品詳細情報1
	private String commodity_detailed_information1;
	
	//商品詳細情報2
	private String commodity_detailed_information2;
	
	//商品詳細情報3
	private String commodity_detailed_information3;
	
	//商品タイプ
	private String commodity_type;

	/**
	 * Commodityの初期設定をおこなう（引数を取るコンストラクタ）
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
	public Commodity(Integer commodity_id, String commodity_name, String commodity_price, String commodity_introduce,
			String commodity_img, Integer commodity_age_start, Integer commodity_age_end, String commodity_time_length,
			Integer commodity_applicable_gender, String commodity_applicable_location, String commodity_signing_form,
			String commodity_liability_zjs, String commodity_detailed_information1,
			String commodity_detailed_information2, String commodity_detailed_information3, String commodity_type) {
		super();
		this.commodity_id = commodity_id;
		this.commodity_name = commodity_name;
		this.commodity_price = commodity_price;
		this.commodity_introduce = commodity_introduce;
		this.commodity_img = commodity_img;
		this.commodity_age_start = commodity_age_start;
		this.commodity_age_end = commodity_age_end;
		this.commodity_time_length = commodity_time_length;
		this.commodity_applicable_gender = commodity_applicable_gender;
		this.commodity_applicable_location = commodity_applicable_location;
		this.commodity_signing_form = commodity_signing_form;
		this.commodity_liability_zjs = commodity_liability_zjs;
		this.commodity_detailed_information1 = commodity_detailed_information1;
		this.commodity_detailed_information2 = commodity_detailed_information2;
		this.commodity_detailed_information3 = commodity_detailed_information3;
		this.commodity_type = commodity_type;
	}

	/**
	 * Commodityの初期設定をおこなう（引数なしのコンストラクタ）
	 */
	public Commodity() {
		super();
	}

	/**
	 * 商品の番号を取得する
	 *  
	 * @return 商品の番号
	 */
	public Integer getCommodity_id() {
		return commodity_id;
	}

	/**
	 * 商品の番号を設定する
	 * 
	 * @param commodity_id を設定する商品の番号
	 */
	public void setCommodity_id(Integer commodity_id) {
		this.commodity_id = commodity_id;
	}

	/**
	 * 商品名を取得する
	 *  
	 * @return 商品名
	 */
	public String getCommodity_name() {
		return commodity_name;
	}

	/**
	 * 商品名を設定する
	 * 
	 * @param commodity_name を設定する商品名
	 */
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}

	/**
	 * 商品の価格を取得する
	 *  
	 * @return 商品の価格 
	 */
	public String getCommodity_price() {
		return commodity_price;
	}

	/**
	 * 商品の価格を設定する
	 * 
	 * @param commodity_price を設定する商品の価格
	 */
	public void setCommodity_price(String commodity_price) {
		this.commodity_price = commodity_price;
	}

	/**
	 * 商品の紹介を取得する
	 *  
	 * @return 商品の紹介
	 */
	public String getCommodity_introduce() {
		return commodity_introduce;
	}

	/**
	 * 商品の紹介を設定する
	 * 
	 * @param commodity_introduce を設定する商品の紹介
	 */
	public void setCommodity_introduce(String commodity_introduce) {
		this.commodity_introduce = commodity_introduce;
	}

	/**
	 * 商品の画像を取得する
	 *  
	 * @return 商品の画像 
	 */
	public String getCommodity_img() {
		return commodity_img;
	}

	/**
	 * 商品の画像を設定する
	 * 
	 * @param commodity_img を設定する商品の画像
	 */
	public void setCommodity_img(String commodity_img) {
		this.commodity_img = commodity_img;
	}

	/**
	 * 商品対象年齢開始を取得する
	 *  
	 * @return 商品対象年齢開始
	 */
	public Integer getCommodity_age_start() {
		return commodity_age_start;
	}

	/**
	 * 商品対象年齢開始を設定する
	 * 
	 * @param commodity_age_start を設定する商品対象年齢開始
	 */
	public void setCommodity_age_start(Integer commodity_age_start) {
		this.commodity_age_start = commodity_age_start;
	}

	/**
	 * 商品対象年齢終了を取得する
	 *  
	 * @return 商品対象年齢終了 
	 */
	public Integer getCommodity_age_end() {
		return commodity_age_end;
	}

	/**
	 * 商品対象年齢終了を設定する
	 * 
	 * @param commodity_age_end を設定する商品対象年齢終了
	 */
	public void setCommodity_age_end(Integer commodity_age_end) {
		this.commodity_age_end = commodity_age_end;
	}

	/**
	 * 商品時間の長さを取得する
	 *  
	 * @return 商品時間の長さ
	 */
	public String getCommodity_time_length() {
		return commodity_time_length;
	}

	/**
	 * 商品時間の長さを設定する
	 * 
	 * @param commodity_time_length を設定する商品時間の長さ
	 */
	public void setCommodity_time_length(String commodity_time_length) {
		this.commodity_time_length = commodity_time_length;
	}

	/**
	 * 商品の適合性别を取得する
	 *  
	 * @return 商品の適合性别
	 */
	public Integer getCommodity_applicable_gender() {
		return commodity_applicable_gender;
	}

	/**
	 * 商品の適合性别を設定する
	 * 
	 * @param commodity_applicable_gender を設定する商品の適合性别
	 */
	public void setCommodity_applicable_gender(Integer commodity_applicable_gender) {
		this.commodity_applicable_gender = commodity_applicable_gender;
	}

	/**
	 * 商品の適合場所を取得する
	 *  
	 * @return 商品の適合場所
	 */
	public String getCommodity_applicable_location() {
		return commodity_applicable_location;
	}

	/**
	 * 商品の適合場所を設定する
	 * 
	 * @param commodity_applicable_location を設定する商品の適合場所
	 */
	public void setCommodity_applicable_location(String commodity_applicable_location) {
		this.commodity_applicable_location = commodity_applicable_location;
	}

	/**
	 * 商品署名フォームを取得する
	 *  
	 * @return 商品署名フォーム 
	 */
	public String getCommodity_signing_form() {
		return commodity_signing_form;
	}

	/**
	 * 商品署名フォームを設定する
	 * 
	 * @param commodity_signing_form を設定する商品署名フォーム
	 */
	public void setCommodity_signing_form(String commodity_signing_form) {
		this.commodity_signing_form = commodity_signing_form;
	}

	/**
	 * 商品責任を取得する
	 *  
	 * @return 商品責任
	 */
	public String getCommodity_liability_zjs() {
		return commodity_liability_zjs;
	}

	/**
	 * 商品責任を設定する
	 * 
	 * @param commodity_liability_zjs を設定する商品責任
	 */
	public void setCommodity_liability_zjs(String commodity_liability_zjs) {
		this.commodity_liability_zjs = commodity_liability_zjs;
	}

	/**
	 * 商品詳細情報1を取得する
	 *  
	 * @return 商品詳細情報1
	 */
	public String getCommodity_detailed_information1() {
		return commodity_detailed_information1;
	}

	/**
	 * 商品詳細情報1を設定する
	 * 
	 * @param commodity_detailed_information1 を設定する商品詳細情報1
	 */
	public void setCommodity_detailed_information1(String commodity_detailed_information1) {
		this.commodity_detailed_information1 = commodity_detailed_information1;
	}

	/**
	 * 商品詳細情報2を取得する
	 *  
	 * @return 商品詳細情報2
	 */
	public String getCommodity_detailed_information2() {
		return commodity_detailed_information2;
	}

	/**
	 * 商品詳細情報2を設定する
	 * 
	 * @param commodity_detailed_information2 を設定する商品詳細情報2
	 */
	public void setCommodity_detailed_information2(String commodity_detailed_information2) {
		this.commodity_detailed_information2 = commodity_detailed_information2;
	}

	/**
	 * 商品詳細情報3を取得する
	 *  
	 * @return 商品詳細情報3
	 */
	public String getCommodity_detailed_information3() {
		return commodity_detailed_information3;
	}

	/**
	 * 商品詳細情報3を設定する
	 * 
	 * @param commodity_detailed_information3 を設定する商品詳細情報3
	 */
	public void setCommodity_detailed_information3(String commodity_detailed_information3) {
		this.commodity_detailed_information3 = commodity_detailed_information3;
	}

	/**
	 * 商品タイプを取得する
	 *  
	 * @return 商品タイプ 
	 */
	public String getCommodity_type() {
		return commodity_type;
	}

	/**
	 * 商品タイプを設定する
	 * 
	 * @param commodity_type を設定する商品タイプ
	 */
	public void setCommodity_type(String commodity_type) {
		this.commodity_type = commodity_type;
	}

	/**
	 * toString メソッド
	 */
	@Override
	public String toString() {
		return "Commodity [commodity_id=" + commodity_id + ", commodity_name=" + commodity_name + ", commodity_price="
				+ commodity_price + ", commodity_introduce=" + commodity_introduce + ", commodity_img=" + commodity_img
				+ ", commodity_age_start=" + commodity_age_start + ", commodity_age_end=" + commodity_age_end
				+ ", commodity_time_length=" + commodity_time_length + ", commodity_applicable_gender="
				+ commodity_applicable_gender + ", commodity_applicable_location=" + commodity_applicable_location
				+ ", commodity_signing_form=" + commodity_signing_form + ", commodity_liability_zjs="
				+ commodity_liability_zjs + ", commodity_detailed_information1=" + commodity_detailed_information1
				+ ", commodity_detailed_information2=" + commodity_detailed_information2
				+ ", commodity_detailed_information3=" + commodity_detailed_information3 + ", commodity_type="
				+ commodity_type + "]";
	}
}
