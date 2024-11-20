package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.UserInfo;

/**
 * @ClassName: AdminDao
 * @Description: 管理数据层接口
 * @author JY
 */
public interface AdminDao {
	
	//获取所有用户信息
	List<UserInfo> queryAllUserInfo();
	
	//删除用户信息
	boolean deleteUserByUserId(Integer userId);
	
	//新增用户
	boolean addNewUser(String userAccount,String userPass,String userNickName,String userStatus,String userType);
	
	//修改用户信息
	boolean updateUserInfo(Integer userId,String userPass,String userNickName,String userStatus,String userType);
	
	//新增书籍
	boolean addNewBook(String bookname, String bookIntroduce, String bookStatus, String bookType);
	
	//删除书籍信息
	boolean deleteBookByBookId(Integer bookId);
	
	//修改书籍信息
	boolean updateBookInfo(Integer bookId, String bookName, String bookIntroduce, String bookStatus, String bookType);
}
