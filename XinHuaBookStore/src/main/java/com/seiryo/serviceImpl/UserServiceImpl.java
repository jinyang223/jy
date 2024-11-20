package com.seiryo.serviceImpl;

import java.util.List;

import com.seiryo.dao.AdminDao;
import com.seiryo.dao.UserDao;
import com.seiryo.daoImpl.AdminDaoImpl;
import com.seiryo.daoImpl.UserDaoImpl;
import com.seiryo.entity.UserInfo;
import com.seiryo.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户服务层接口实现类
 * @author JY
 */
public class UserServiceImpl implements UserService {
	
	//接口指向实现类
	private UserDao userDao = new UserDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();

	/**
	 * 验证登录账号密码是否正确
	 */
	public UserInfo checkLoginAccountAndPass(String userAccount, String userPass, Integer accountType) {
		//获取所有正常用户信息
		List<UserInfo> userInfos = userDao.queryAllUserInfo();
		UserInfo userInfo2 = null;
		if (userInfos != null && !userInfos.isEmpty()) {
			for (UserInfo userInfo : userInfos) {
				if (accountType == 0) {
					//普通用户
					if (userInfo.getUserAccount().equals(userAccount) && userInfo.getUserPass().equals(userPass) && "0".equals(userInfo.getUserType())) {
						userInfo2 = new UserInfo(userInfo.getUserId(),userInfo.getUserAccount(),userInfo.getUserPass(),userInfo.getUserNickName(),userInfo.getUserAvatar(),userInfo.getUserStatus(),userInfo.getUserType());
						return userInfo2;
					}
				} else if(accountType == 1) {
					//管理员
					if (userInfo.getUserAccount().equals(userAccount) && userInfo.getUserPass().equals(userPass) && "1".equals(userInfo.getUserType())) {
						userInfo2 = new UserInfo(userInfo.getUserId(),userInfo.getUserAccount(),userInfo.getUserPass(),userInfo.getUserNickName(),userInfo.getUserAvatar(),userInfo.getUserStatus(),userInfo.getUserType());
						return userInfo2;
					}
				}	
			}
		}
		return userInfo2;
	}

	/**
	 * 用户注册
	 */
	public boolean userRegist(String userNickName, String userAccount, String userPass) {
		return userDao.userRegist(userNickName,userAccount,userPass);
	}

	/**
	 * 验证账号是否重复注册
	 */
	public boolean checkUserAccount(String userAccount) {
		//获取所有用户信息
		List<UserInfo> userInfos = adminDao.queryAllUserInfo();
		if (userInfos != null) {
			for (UserInfo userInfo : userInfos) {
				if (userInfo.getUserAccount().equals(userAccount)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
