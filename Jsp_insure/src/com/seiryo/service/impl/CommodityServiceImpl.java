package com.seiryo.service.impl;

import java.util.List;

import com.seiryo.dao.CommodityDao;
import com.seiryo.dao.impl.CommodityDaoImpl;
import com.seiryo.entity.Commodity_liability_info;
import com.seiryo.entity.MyUserInfo;
import com.seiryo.service.CommodityService;

/**
 * @ClassName: CommodityServiceImpl
 * @Description: 商品サービス層インターフェースの実装クラス
 * @author JY
 */
public class CommodityServiceImpl implements CommodityService{
	
	//インターフェースが実装クラスに指す
	private CommodityDao commodityDao = new CommodityDaoImpl();

	/**
	 * 商品のタイプと現在のログインユーザー情報に基づいてすべての商品情報を照会する
	 */
	public List<Commodity_liability_info> selectAllCommodity(MyUserInfo myUserInfo,String commodityType) {
		return commodityDao.selectAllCommodity(myUserInfo,commodityType);
	}

}
