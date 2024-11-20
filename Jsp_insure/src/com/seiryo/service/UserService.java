package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.MyUserInfo;

/**
 * @ClassName: UserService
 * @Description: ユーザーサービス層インターフェース
 * @author JY
 */
public interface UserService {
	
	//ユーザー登録情報をデータベースに保存したかどうかを判断する
	boolean insertUser(MyUserInfo myUserInfo);
	
	//すべてのユーザー情報を取得する
	List<MyUserInfo> selectAllUserInfo();
	
	//ユーザーのメールアドレスが存在するかどうかを判断する
	boolean pdUserEmail(String email);
	
	//ユーザーの携帯電話が存在するかどうかを判断する
	boolean pdUserPhone(String phone);
	
	//ユーザーのログインが成功したかどうかを判断する
	MyUserInfo pdUserLogin(String email,String pass);
	
	//ユーザー情報が更新に成功したかどうかを判断する
	boolean upDataUserInfo(Integer userInfoId,String user_pass,String user_phone,Double addMoneyDouble);

}
