package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.BookInfo;
import com.seiryo.entity.LogInfo;
import com.seiryo.entity.UserInfo;

/**
 * @ClassName: AdminService
 * @Description: 管理服务层接口
 * @author JY
 */
public interface AdminService {
	
	//获取所有用户数据
	List<UserInfo> queryAllUserInfo();
	
	//获取所有书籍书籍
	List<BookInfo> selectAllBook();
	
	//获取所有日志信息
	List<LogInfo> selectAllLogInfo();
	
	//删除用户信息
	boolean deleteUserByUserId(Integer userId);
	
	//新增用户
	boolean addNewUser(String userAccount,String userPass,String userNickName,String userStatus,String userType);
	
	//验证账号是否重复注册
	boolean checkUserAccount(String userAccount);
	
	//根据用户id获取用户数据
	UserInfo selectUserById(Integer userId);
	
	//判断用户信息是否修改成功
	Integer checkUpdateUserInfo(Integer userId,String userPass,String userNickName,String userStatus,String userType);
	
	//新增书籍
	boolean addNewBook(String bookname, String bookIntroduce, String bookStatus, String bookType);
	
	//删除书籍信息
	boolean deleteBookByBookId(Integer bookId);
	
	//根据书籍id获取书籍数据
	BookInfo selectBookById(Integer bookId);
	
	//判断书籍信息是否修改成功
	Integer checkUpdateBookInfo(Integer bookId, String bookName, String bookIntroduce, String bookStatus, String bookType);
}
