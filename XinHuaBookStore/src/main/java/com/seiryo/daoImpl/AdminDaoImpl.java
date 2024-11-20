package com.seiryo.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.dao.AdminDao;
import com.seiryo.entity.UserInfo;
import com.seiryo.util.JDBCUTILE;

/**
 * @ClassName: AdminDaoImpl
 * @Description: 管理数据层接口实现类
 * @author JY
 */
public class AdminDaoImpl implements AdminDao {
	
	/**
	 * 获取所有用户信息
	 */
	public List<UserInfo> queryAllUserInfo() {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		ResultSet rs = null;
		String sql = "SELECT * FROM USER_INFO";
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql);
			while (rs.next()) {
				Integer userId = rs.getInt("USER_ID");
				String userAccount = rs.getString("USER_ACCOUNT");
				String userPass = rs.getString("USER_PASS");
				String userNickName = rs.getString("USER_NICKNAME");
				String userAvatar = rs.getString("USER_AVATAR");
				String userStatus = rs.getString("USER_STATUS");
				String userType = rs.getString("USER_TYPE");
				userInfos.add(new UserInfo(userId,userAccount,userPass,userNickName,userAvatar,userStatus,userType));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfos;
	}

	/**
	 * 删除用户信息
	 */
	public boolean deleteUserByUserId(Integer userId) {
		String sql = "DELETE FROM USER_INFO WHERE USER_ID = ?";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 新增用户
	 */
	public boolean addNewUser(String userAccount, String userPass, String userNickName, String userStatus, String userType) {
		boolean bo = false;
		String sql = "INSERT INTO USER_INFO(USER_ACCOUNT,USER_PASS,USER_NICKNAME,USER_STATUS,USER_TYPE) VALUES(?,?,?,?,?)";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, userAccount,userPass,userNickName,userStatus,userType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 修改用户信息
	 */
	public boolean updateUserInfo(Integer userId, String userPass, String userNickName, String userStatus, String userType) {
		String sql = "UPDATE USER_INFO SET USER_PASS = ?,USER_NICKNAME = ?,USER_STATUS = ?,USER_TYPE = ? WHERE USER_ID = ?";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, userPass,userNickName,userStatus,userType,userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 新增书籍
	 */
	public boolean addNewBook(String bookname, String bookIntroduce, String bookStatus, String bookType) {
		boolean bo = false;
		String sql = "INSERT INTO BOOK_INFO(BOOK_NAME,BOOK_INTRODUCE,BOOK_COVER,BOOK_STATUS,BOOK_TYPE) VALUES(?,?,?,?,?)";
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, bookname,bookIntroduce,"images/default.png",bookStatus,bookType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 删除书籍信息
	 */
	public boolean deleteBookByBookId(Integer bookId) {
		String sql = "DELETE FROM BOOK_INFO WHERE BOOK_ID = ?";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, bookId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/**
	 * 修改书籍信息
	 */
	public boolean updateBookInfo(Integer bookId, String bookName, String bookIntroduce, String bookStatus, String bookType) {
		String sql = "UPDATE BOOK_INFO SET BOOK_NAME = ?,BOOK_INTRODUCE = ?,BOOK_STATUS = ?,BOOK_TYPE = ? WHERE BOOK_ID = ?";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql, bookName,bookIntroduce,bookStatus,bookType,bookId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}
}
