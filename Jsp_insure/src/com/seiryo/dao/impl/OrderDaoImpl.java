package com.seiryo.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.dao.OrderDao;
import com.seiryo.entity.My_order_info;
import com.seiryo.utile.JDBCUTILE;

/**
 * @ClassName: OrderDaoImpl
 * @Description: 注文データ層インターフェースの実装クラス
 * @author JY
 */
public class OrderDaoImpl implements OrderDao{

	/**
	 * 注文が正常に追加されたかどうかを判断する
	 */
	public boolean insertOrderInfo(My_order_info info) {
		String sql1 = "INSERT INTO my_order(order_id,user_id,commodity_id) VALUES(?,?,?)";
		String sql2 = "INSERT INTO my_order_info(order_id,order_commodity_liability1,order_commodity_liability2,order_commodity_liability3,order_commodity_liability4,order_commodity_liability5,order_commodity_liability6,order_commodity_liability7,order_beneficiary_name,order_beneficiary_age,order_beneficiary_phone,order_commodity_time_start,order_commodity_time_end,order_commodity_time_length,order_sum_price) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql1, info.getOrder_id(),info.getUser_id(),info.getCommodity_id());
			if(bo) {
				bo = JDBCUTILE.upDataBaseTable(sql2, info.getOrder_id(),info.getOrder_commodity_liability1(),info.getOrder_commodity_liability2(),info.getOrder_commodity_liability3(),info.getOrder_commodity_liability4(),info.getOrder_commodity_liability5(),info.getOrder_commodity_liability6(),info.getOrder_commodity_liability7(),info.getOrder_beneficiary_name(),info.getOrder_beneficiary_age(),info.getOrder_beneficiary_phone(),info.getOrder_commodity_time_start(),info.getOrder_commodity_time_end(),info.getOrder_commodity_time_length(),info.getOrder_sum_price());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 全ての注文情報を照会する
	 */
	public List<My_order_info> selectAllOrder() {
		String sql = "SELECT m1.order_id,m1.user_id,m1.commodity_id,m2.order_info_id,m2.order_commodity_liability1,m2.order_commodity_liability2,m2.order_commodity_liability3,m2.order_commodity_liability4,m2.order_commodity_liability5,m2.order_commodity_liability6,m2.order_commodity_liability7,m2.order_beneficiary_name,m2.order_beneficiary_age,m2.order_beneficiary_phone,m2.order_commodity_time_start,m2.order_commodity_time_end,m2.order_commodity_time_length,m2.order_sum_price FROM my_order m1 JOIN my_order_info m2 ON m1.order_id = m2.order_id";
		ResultSet rest = null;
		List<My_order_info> list = new ArrayList<My_order_info>();
		try {
			rest = JDBCUTILE.selectDataBaseTable(sql);
			while(rest.next()) {
				My_order_info info = new My_order_info();
				info.setOrder_id(rest.getString("order_id"));
				info.setUser_id(rest.getInt("user_id"));
				info.setCommodity_id(rest.getInt("commodity_id"));
				info.setOrder_info_id(rest.getInt("order_info_id"));
				info.setOrder_commodity_liability1(rest.getString("order_commodity_liability1"));
				info.setOrder_commodity_liability2(rest.getString("order_commodity_liability2"));
				info.setOrder_commodity_liability3(rest.getString("order_commodity_liability3"));
				info.setOrder_commodity_liability4(rest.getString("order_commodity_liability4"));
				info.setOrder_commodity_liability5(rest.getString("order_commodity_liability5"));
				info.setOrder_commodity_liability6(rest.getString("order_commodity_liability6"));
				info.setOrder_commodity_liability7(rest.getString("order_commodity_liability7"));
				info.setOrder_beneficiary_name(rest.getString("order_beneficiary_name"));
				info.setOrder_beneficiary_age(rest.getString("order_beneficiary_age"));
				info.setOrder_beneficiary_phone(rest.getString("order_beneficiary_phone"));
				info.setOrder_commodity_time_start(rest.getString("order_commodity_time_start"));
				info.setOrder_commodity_time_end(rest.getString("order_commodity_time_end"));
				info.setOrder_commodity_time_length(rest.getString("order_commodity_time_length"));
				info.setOrder_sum_price(rest.getString("order_sum_price"));
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ユーザーIDを取得する
	 */
	public Integer selectUserIdByUserInfoId(Integer userInfoId) {
		String sql = "SELECT user_id FROM my_user_info WHERE user_info_id = ?";
		ResultSet rest = null;
		Integer user_id = 0;
		try {
			rest = JDBCUTILE.selectDataBaseTable(sql, userInfoId);
			while(rest.next()) {
				user_id = rest.getInt("user_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user_id;
	}

	/**
	 * 金額が十分かどうかを確認する
	 */
	public boolean checkUserMoney(String order_sum_price, Integer userInfoId) {
		String sql = "SELECT user_money FROM my_user_info WHERE user_info_id = ?";
		ResultSet rest = null;
		Double user_money = 0.00;
		boolean bo = false;
		try {
			rest = JDBCUTILE.selectDataBaseTable(sql, userInfoId);
			while(rest.next()) {
				user_money = rest.getDouble("user_money");
			}
			if (user_money < Double.parseDouble(order_sum_price)) {
				bo = false;
			} else {
				//ユーザーの残高を減少する
				String sql1 = "UPDATE my_user_info SET user_money = user_money - ? WHERE user_info_id = ?";
				try {
					bo = JDBCUTILE.upDataBaseTable(sql1,order_sum_price,userInfoId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 被保険者の年齢が保険商品の加入年齢に該当するかどうかを判断する
	 */
	public Integer[] checkOrderBeneficiaryAge(Integer commodity_id) {
		String sql = "SELECT commodity_age_start,commodity_age_end FROM commodity WHERE commodity_id = ?";
		ResultSet rs = null;
		Integer commodity_age_start = 0;
		Integer commodity_age_end = 0;
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, commodity_id);
			while(rs.next()) {
				commodity_age_start = rs.getInt("commodity_age_start");
				commodity_age_end = rs.getInt("commodity_age_end");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Integer[] {commodity_age_start,commodity_age_end};
	}

}
