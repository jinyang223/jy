package com.seiryo.serviceImpl;

import java.util.List;

import com.seiryo.dao.BookDao;
import com.seiryo.daoImpl.BookDaoImpl;
import com.seiryo.entity.BookInfo;
import com.seiryo.entity.LogInfo;
import com.seiryo.service.BookService;

/**
 * @ClassName: BookServiceImpl
 * @Description: 书籍服务层接口
 * @author JY
 *
 */
public class BookServiceImpl implements BookService {

	//接口指向实现类
	private BookDao bookDao = new BookDaoImpl();
	
	/**
	 * 查询所有书籍信息
	 */
	public List<BookInfo> selectAllBook() {
		return bookDao.selectAllBook();
	}

	/**
	 * 判断登录用户是否借阅该书籍
	 */
	public boolean checkLoginUserBorrowing(Integer bookId, Integer userId) {
		
		//获取所有日志信息
		List<LogInfo> logInfos = bookDao.selectAllLogInfo();
		if (logInfos != null) {
			for (LogInfo logInfo : logInfos) {
				if (logInfo.getLogBookId() == bookId && logInfo.getLogUserId() == userId) {
					//用户id和书籍id对上之后还需判断书籍归还时间是否为空，空代表是未归还状态，否则可能出现多条数据
					if (logInfo.getLogBookReturnTime() == null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 用户还书（书籍状态、日志）
	 */
	public boolean loginUserBookReturn(Integer bookId, Integer userId,String nowDate) {
		return bookDao.loginUserBookReturn(bookId, userId, nowDate);
	}

	/**
	 * 用户借书（书籍状态、日志）
	 */
	public boolean loginUserBookBorrowing(Integer bookId, Integer userId, String nowDate) {
		return bookDao.loginUserBookBorrowing(bookId, userId, nowDate);
	}

	/**
	 * 根据关键字查询书籍
	 */
	public List<BookInfo> selectAllBookByKeyWord(String keyword) {
		return bookDao.selectAllBookByKeyWord(keyword);
	}

	/**
	 * 获取所有日志信息
	 */
	public List<LogInfo> selectAllLogInfo() {
		return bookDao.selectAllLogInfo();
	}
}
