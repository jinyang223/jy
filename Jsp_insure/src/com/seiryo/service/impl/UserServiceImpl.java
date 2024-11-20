package com.seiryo.service.impl;

import java.util.List;

import com.seiryo.dao.UserDao;
import com.seiryo.dao.impl.UserDaoImpl;
import com.seiryo.entity.MyUserInfo;
import com.seiryo.service.UserService;
import com.seiryo.utile.MD5UTIL;

/**
 * @ClassName: UserServiceImpl
 * @Description: ユーザーサービス層インターフェースの実装クラス
 * @author JY
 */
public class UserServiceImpl implements UserService{
	
	//インターフェースが実装クラスを指す
	private UserDao userDao = new UserDaoImpl();

	/**
	 * ユーザー登録情報をデータベースに保存したかどうかを判断する
	 */
	public boolean insertUser(MyUserInfo myUserInfo) {
		return userDao.insertUser(myUserInfo);
	}

	/**
	 * すべてのユーザー情報を取得する
	 */
	public List<MyUserInfo> selectAllUserInfo() {
		return userDao.selectAllUserInfo();
	}

	/**
	 * ユーザーのメールアドレスが存在するかどうかを判断する
	 */
	public boolean pdUserEmail(String email) {
		List<MyUserInfo> userList = userDao.selectAllUserInfo();
		if(userList.size() > 0) {
			for(MyUserInfo user:userList) {
				if(user.getUser_email().equals(email)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * ユーザーの携帯電話が存在するかどうかを判断する
	 */
	public boolean pdUserPhone(String phone) {
		List<MyUserInfo> userList = userDao.selectAllUserInfo();
		if(userList.size() > 0) {
			for(MyUserInfo user:userList) {
				if(user.getUser_phone().equals(phone)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ユーザーのログインが成功したかどうかを判断する
	 */
	public MyUserInfo pdUserLogin(String email, String pass) {
		List<MyUserInfo> userList = userDao.selectAllUserInfo();
		if(userList.size() > 0) {
			for(MyUserInfo user:userList) {
				if(user.getUser_email().equals(email)) {
					if(MD5UTIL.md5(user.getUser_password()).equals(pass)) {
						return user;
					}
				}
			}
		}
		return null;
	}

	/**
	 *  ユーザー情報が更新に成功したかどうかを判断する
	 */
	public boolean upDataUserInfo(Integer userInfoId,String user_pass,String user_phone,Double addMoneyDouble) {
		return userDao.upDataUserInfo(userInfoId,user_pass,user_phone,addMoneyDouble);
	}
}
