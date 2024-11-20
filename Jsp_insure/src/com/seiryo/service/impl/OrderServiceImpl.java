package com.seiryo.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.seiryo.dao.OrderDao;
import com.seiryo.dao.UserDao;
import com.seiryo.dao.impl.OrderDaoImpl;
import com.seiryo.dao.impl.UserDaoImpl;
import com.seiryo.entity.MyUserInfo;
import com.seiryo.entity.My_order_info;
import com.seiryo.service.OrderService;

/**
 * @ClassName: OrderServiceImpl
 * @Description: 注文層インターフェースの実装クラス
 * @author JY
 */
public class OrderServiceImpl implements OrderService{
	
	//インターフェースが実装クラスを指す
	private OrderDao orderDao = new OrderDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	/**
	 * 注文が正常に追加されたかどうかを判断する
	 */
	public boolean insertOrderInfo(My_order_info info) {
		return orderDao.insertOrderInfo(info);
	}

	/**
	 * ユーザーIDで注文を照会する
	 */
	public List<My_order_info> selectOrderByUserId(Integer userInfoId) {
		//全ての注文情報を取得する
		List<My_order_info> infoList = orderDao.selectAllOrder();
		//現在のログインしたユーザーIDを取得する
		Integer user_id = orderDao.selectUserIdByUserInfoId(userInfoId);
		//コレクションを作成して、現在のログインユーザーの注文情報を保存する
		List<My_order_info> orderList = new ArrayList<My_order_info>();
		if(infoList != null) {
			for(My_order_info order:infoList) {
				if(order.getUser_id() == user_id) {
					orderList.add(order);
				}
			}
		}
		return orderList;
	}

	/**
	 * ユーザーIDを取得する
	 */
	public Integer selectUserIdByUserInfoId(Integer userInfoId) {
		return orderDao.selectUserIdByUserInfoId(userInfoId);
	}

	/**
	 * 金額が十分かどうかを確認する
	 */
	public boolean checkUserMoney(String order_sum_price, Integer userInfoId) {
		return orderDao.checkUserMoney(order_sum_price, userInfoId);
	}

	/**
	 * 被保険者の年齢が保険商品の加入年齢に該当するかどうかを判断する
	 */
	public boolean checkOrderBeneficiaryAge(Integer commodity_id, String order_beneficiary_age) {
		Integer[] commodity_age = orderDao.checkOrderBeneficiaryAge(commodity_id);
		Integer commodity_age_start = commodity_age[0];
		Integer commodity_age_end = commodity_age[1];
		Integer beneficiary_age = Integer.parseInt(order_beneficiary_age);
		if ((beneficiary_age >= commodity_age_start) && (beneficiary_age <= commodity_age_end)) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 被保険者がアカウントを登録したかどうかを判断する
	 */
	public Integer checkIsInsuredAccount(String order_beneficiary_name, String order_beneficiary_age,String order_beneficiary_phone) {
		//すべてのユーザー情報を取得する
		List<MyUserInfo> myUserInfos = userDao.selectAllUserInfo();
		for (MyUserInfo myUserInfo : myUserInfos) {
			if (myUserInfo.getUser_phone().equals(order_beneficiary_phone)) {
				if (myUserInfo.getUser_name().equals(order_beneficiary_name) && myUserInfo.getUser_phone().equals(order_beneficiary_phone)) {
					//誕生日に応じて現在の年齢を取得する
					String birthdayString = myUserInfo.getUser_birthday(); 
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			        LocalDate birthday = LocalDate.parse(birthdayString, formatter);
			        LocalDate today = LocalDate.now();
			        Integer yearsBetween = (int) ChronoUnit.YEARS.between(birthday, today);
			        if(yearsBetween == Integer.parseInt(order_beneficiary_age)) {
			        	return 0;
			        } else {
						return 5;
					}
				} else {
					return 4;
				}
			}
		}
		return 6;
	}
}
