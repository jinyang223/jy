package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.My_order_info;

/**
 * @ClassName: OrderService
 * @Description: 注文サービス層インターフェース
 * @author JY
 */
public interface OrderService {
	
	//注文が正常に追加されたかどうかを判断する
	boolean insertOrderInfo(My_order_info info);
	
	//ユーザーIDで注文を照会する
	List<My_order_info> selectOrderByUserId(Integer userInfoId);
	
	//ユーザーIDを取得する
	Integer selectUserIdByUserInfoId(Integer userInfoId);
	
	//金額が十分かどうかを確認する
	boolean checkUserMoney(String order_sum_price,Integer userInfoId);
	
	//被保険者の年齢が保険商品の加入年齢に該当するかどうかを判断する
	boolean checkOrderBeneficiaryAge(Integer commodity_id,String order_beneficiary_age);

	//被保険者がアカウントを登録したかどうかを判断する
	Integer checkIsInsuredAccount(String order_beneficiary_name,String order_beneficiary_age,String order_beneficiary_phone);
}
