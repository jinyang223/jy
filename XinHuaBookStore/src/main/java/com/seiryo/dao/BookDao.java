package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.BookInfo;
import com.seiryo.entity.LogInfo;

/**
 * @ClassName: BookDao
 * @Description: 书籍数据层接口
 * @author JY
 */
public interface BookDao {
	
	//查询所有书籍信息
	List<BookInfo> selectAllBook();
	
	//查询所有日志信息
	List<LogInfo> selectAllLogInfo();
	
	//用户还书（书籍状态、日志）
	boolean loginUserBookReturn(Integer bookId,Integer userId,String nowDate);
	
	//用户借书（书籍状态、日志）
	boolean loginUserBookBorrowing(Integer bookId,Integer userId,String nowDate);
	
	//根据关键字查询书籍
	List<BookInfo> selectAllBookByKeyWord(String keyword);
}
