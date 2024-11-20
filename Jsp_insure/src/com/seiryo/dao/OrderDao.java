package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.My_order_info;

/**
 * @ClassName: OrderDao
 * @Description: 注文データ層インターフェース
 * @author JY
 */
public interface OrderDao {
	
	//注文が正常に追加されたかどうかを判断する
	boolean insertOrderInfo(My_order_info info);
	
	//ユーザーIDで注文を照会する
	List<My_order_info> selectAllOrder();

	//ユーザーIDを取得する
	Integer selectUserIdByUserInfoId(Integer userInfoId);
	
	//金額が十分かどうかを確認する
	boolean checkUserMoney(String order_sum_price,Integer userInfoId);

	//被保険者の年齢が保険商品の加入年齢に該当するかどうかを判断する
	Integer[] checkOrderBeneficiaryAge(Integer commodity_id);
}
