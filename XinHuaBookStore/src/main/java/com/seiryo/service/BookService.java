package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.BookInfo;
import com.seiryo.entity.LogInfo;

/**
 * @ClassName: BookService
 * @Description: 书籍服务层接口
 * @author JY
 */
public interface BookService {
	
	//查询所有书籍信息
	List<BookInfo> selectAllBook();
	
	//获取所有日志信息
	List<LogInfo> selectAllLogInfo();

	//判断登录用户是否借阅该书籍
	boolean checkLoginUserBorrowing(Integer bookId,Integer userId);
	
	//用户还书（书籍状态、日志）
	boolean loginUserBookReturn(Integer bookId,Integer userId,String nowDate);
	
	//用户借书（书籍状态、日志）
	boolean loginUserBookBorrowing(Integer bookId,Integer userId,String nowDate);
	
	//根据关键字查询书籍
	List<BookInfo> selectAllBookByKeyWord(String keyword);
}
