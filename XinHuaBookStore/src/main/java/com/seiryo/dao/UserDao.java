package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.UserInfo;

/**
 * @ClassName: UserDao
 * @Description: 用户数据层接口
 * @author JY
 */
public interface UserDao {
	
	//获取所有正常用户信息
	List<UserInfo> queryAllUserInfo();
	
	//用户注册
	boolean userRegist(String userNickName,String userAccount,String userPass);
}
