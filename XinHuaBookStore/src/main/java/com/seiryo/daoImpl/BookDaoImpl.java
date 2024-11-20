package com.seiryo.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.dao.BookDao;
import com.seiryo.entity.BookInfo;
import com.seiryo.entity.LogInfo;
import com.seiryo.util.JDBCUTILE;

/**
 * @ClassName: BookDaoImpl
 * @Description: 书籍数据层接口实现类
 * @author JY
 */
public class BookDaoImpl implements BookDao {

	/**
	 * 查询所有书籍信息
	 */
	public List<BookInfo> selectAllBook() {
		ResultSet rSet = null;
		String sql = "SELECT * FROM BOOK_INFO";
		List<BookInfo> bookInfos = new ArrayList<BookInfo>();
		try {
			rSet = JDBCUTILE.selectDataBaseTable(sql);
			while (rSet.next()) {
				Integer bookId = rSet.getInt("BOOK_ID");
				String bookName = rSet.getString("BOOK_NAME");
				String bookIntroduce = rSet.getString("BOOK_INTRODUCE");
				String bookCover = rSet.getString("BOOK_COVER");
				String bookStatus = rSet.getString("BOOK_STATUS");
				String bookType = rSet.getString("BOOK_TYPE");
				bookInfos.add(new BookInfo(bookId,bookName,bookIntroduce,bookCover,bookStatus,bookType));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookInfos;
	}

	/**
	 * 查询所有日志信息
	 */
	public List<LogInfo> selectAllLogInfo() {
		List<LogInfo> logInfos = new ArrayList<LogInfo>();
		ResultSet rSet = null;
		String sql = "SELECT * FROM LOG_INFO";
		try {
			rSet = JDBCUTILE.selectDataBaseTable(sql);
			while (rSet.next()) {
				Integer logId = rSet.getInt("LOG_ID");
				Integer logUserId = rSet.getInt("LOG_USER_ID");
				Integer logBookId = rSet.getInt("LOG_BOOK_ID");
				String logBorrowingTime = rSet.getString("LOG_BORROWING_TIME");
				String logBookReturnTime = rSet.getString("LOG_BOOKRETURN_TIME");
				logInfos.add(new LogInfo(logId,logUserId,logBookId,logBorrowingTime,logBookReturnTime));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logInfos ;
	}

	/**
	 * 用户还书（书籍状态、日志）
	 */
	public boolean loginUserBookReturn(Integer bookId, Integer userId,String nowDate) {
		String sql1 = "UPDATE BOOK_INFO SET BOOK_STATUS = 1 WHERE BOOK_ID = ?";
		String sql2 = "UPDATE LOG_INFO SET LOG_BOOKRETURN_TIME = ? WHERE LOG_USER_ID = ? AND LOG_BOOK_ID = ?";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql1, bookId);
			if (bo) {
				bo = JDBCUTILE.upDataBaseTable(sql2, nowDate,userId,bookId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 用户借书（书籍状态、日志）
	 */
	public boolean loginUserBookBorrowing(Integer bookId, Integer userId, String nowDate) {
		String sql1 = "UPDATE BOOK_INFO SET BOOK_STATUS = 0 WHERE BOOK_ID = ?";
		String sql2 = "INSERT INTO LOG_INFO(LOG_USER_ID,LOG_BOOK_ID,LOG_BORROWING_TIME) VALUES(?,?,?)";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql1, bookId);
			if (bo) {
				bo = JDBCUTILE.upDataBaseTable(sql2, userId,bookId,nowDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 根据关键字查询书籍
	 */
	public List<BookInfo> selectAllBookByKeyWord(String keyword) {
		ResultSet rSet = null;
		String sql = "SELECT BOOK_ID,BOOK_NAME,BOOK_INTRODUCE,BOOK_COVER,BOOK_STATUS,BOOK_TYPE FROM BOOK_INFO \r\n"
				+ "WHERE BOOK_NAME LIKE CONCAT('%', ?, '%') OR BOOK_INTRODUCE LIKE CONCAT('%', ?, '%')";
		List<BookInfo> bookInfos = new ArrayList<BookInfo>();
		try {
			rSet = JDBCUTILE.selectDataBaseTable(sql, keyword,keyword);
			while (rSet.next()) {
				Integer bookId = rSet.getInt("BOOK_ID");
				String bookName = rSet.getString("BOOK_NAME");
				String bookIntroduce = rSet.getString("BOOK_INTRODUCE");
				String bookCover = rSet.getString("BOOK_COVER");
				String bookStatus = rSet.getString("BOOK_STATUS");
				String bookType = rSet.getString("BOOK_TYPE");
				bookInfos.add(new BookInfo(bookId,bookName,bookIntroduce,bookCover,bookStatus,bookType));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookInfos;
	}
}
