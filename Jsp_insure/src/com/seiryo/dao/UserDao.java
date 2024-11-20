package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.MyUserInfo;

/**
 * @ClassName: UserDao
 * @Description: ユーザーデータ層インターフェース
 * @author JY
 */
public interface UserDao {
	
	//ユーザー登録情報をデータベースに保存する
	boolean insertUser(MyUserInfo myUserInfo);
	
	//すべてのユーザー情報を取得する
	List<MyUserInfo> selectAllUserInfo();

	//ユーザー情報を変更する
	boolean upDataUserInfo(Integer userInfoId,String user_pass,String user_phone,Double addMoneyDouble);
}
