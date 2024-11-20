package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.Commodity_liability_info;
import com.seiryo.entity.MyUserInfo;

/**
 * @ClassName: CommodityDao
 * @Description: 商品データ層のインターフェース
 * @author JY
 */
public interface CommodityDao {
	
	//商品のタイプと現在のログインユーザー情報に基づいてすべての商品情報を照会する
	List<Commodity_liability_info> selectAllCommodity(MyUserInfo myUserInfo,String commodityType);

}
