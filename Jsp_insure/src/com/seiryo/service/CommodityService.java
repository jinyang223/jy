package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.Commodity_liability_info;
import com.seiryo.entity.MyUserInfo;

/**
 * @ClassName: CommodityService
 * @Description: 商品サービス層インターフェース
 * @author JY
 */
public interface CommodityService {
	
	//商品のタイプと現在のログインユーザー情報に基づいてすべての商品情報を照会する
	List<Commodity_liability_info> selectAllCommodity(MyUserInfo myUserInfo,String commodityType);

}
