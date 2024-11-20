package com.seiryo.service;

import com.seiryo.entity.UserInfo;

/**
 * @ClassName: UserService
 * @Description: 用户服务层接口
 * @author JY
 */
public interface UserService {
	
	//验证登录账号密码是否正确
	UserInfo checkLoginAccountAndPass(String userAccount,String userPass,Integer accountType);
	
	//验证账号是否重复注册
	boolean checkUserAccount(String userAccount);
	
	//用户注册
	boolean userRegist(String userNickName,String userAccount,String userPass);
}
