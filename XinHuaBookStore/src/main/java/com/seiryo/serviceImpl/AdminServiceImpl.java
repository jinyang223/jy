package com.seiryo.serviceImpl;

import java.util.List;

import com.seiryo.dao.AdminDao;
import com.seiryo.dao.BookDao;
import com.seiryo.daoImpl.AdminDaoImpl;
import com.seiryo.daoImpl.BookDaoImpl;
import com.seiryo.entity.BookInfo;
import com.seiryo.entity.LogInfo;
import com.seiryo.entity.UserInfo;
import com.seiryo.service.AdminService;

/**
 * @ClassName: AdminServiceImpl
 * @Description: 管理服务层接口实现类
 * @author JY
 *
 */
public class AdminServiceImpl implements AdminService {
	
	//接口指向实现类
	private BookDao bookDao = new BookDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();

	/**
	 * 获取所有用户数据
	 */
	public List<UserInfo> queryAllUserInfo() {
		return adminDao.queryAllUserInfo();
	}

	/**
	 * 获取所有书籍书籍
	 */
	public List<BookInfo> selectAllBook() {
		return bookDao.selectAllBook();
	}

	/**
	 * 获取所有日志信息
	 */
	public List<LogInfo> selectAllLogInfo() {
		return bookDao.selectAllLogInfo();
	}

	/**
	 * 删除用户信息
	 */
	public boolean deleteUserByUserId(Integer userId) {
		return adminDao.deleteUserByUserId(userId);
	}

	/**
	 * 新增用户
	 */
	public boolean addNewUser(String userAccount, String userPass, String userNickName, String userStatus, String userType) {
		return adminDao.addNewUser(userAccount, userPass, userNickName, userStatus, userType);
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
	
	/**
	 * 根据用户id获取用户数据
	 */
	public UserInfo selectUserById(Integer userId){
		//获取所有用户信息
		List<UserInfo> userInfos = adminDao.queryAllUserInfo();
		UserInfo userInfo = null;
		if (userInfos != null) {
			for (UserInfo userInfo1 : userInfos) {
				if (userInfo1.getUserId() == userId) {
					userInfo = new UserInfo(userInfo1.getUserId(),userInfo1.getUserAccount(),userInfo1.getUserPass(),userInfo1.getUserNickName(),userInfo1.getUserAvatar(),userInfo1.getUserStatus(),userInfo1.getUserType());
				}
			}
		}
		return userInfo;	
	}

	/**
	 * 判断用户信息是否修改成功
	 */
	public Integer checkUpdateUserInfo(Integer userId,String userPass, String userNickName, String userStatus, String userType) {
		//获取所有用户信息
		List<UserInfo> userInfos = adminDao.queryAllUserInfo();
		boolean bo = false;
		if (userInfos != null) {
			for (UserInfo userInfo : userInfos) {
				if (userInfo.getUserId() == userId) {
					//判断是否修改了值
					if (userInfo.getUserPass().equals(userPass) && userInfo.getUserNickName().equals(userNickName) && userInfo.getUserStatus().equals(userStatus) && userInfo.getUserType().equals(userType)) {
						return 0;
					}else {
						//修改数据库用户信息
						bo = adminDao.updateUserInfo(userId, userPass, userNickName, userStatus, userType);
					}
				}
			}
		}
		if (bo) {
			//修改成功
			return 1;
		}else {
			//修改失败
			return 2;
		}
	}

	/**
	 * 新增书籍
	 */
	public boolean addNewBook(String bookname, String bookIntroduce, String bookStatus, String bookType) {
		return adminDao.addNewBook(bookname, bookIntroduce, bookStatus, bookType);
	}

	/**
	 * 删除书籍信息
	 */
	public boolean deleteBookByBookId(Integer bookId) {
		return adminDao.deleteBookByBookId(bookId);
	}

	/**
	 * 根据书籍id获取书籍数据
	 */
	public BookInfo selectBookById(Integer bookId) {
		//获取所有用户信息
		List<BookInfo> bookInfos = bookDao.selectAllBook();
		BookInfo bookInfo = null;
		if (bookInfos != null) {
			for (BookInfo bookInfo2 : bookInfos) {
				if (bookInfo2.getBookId() == bookId) {
					bookInfo = new BookInfo(bookInfo2.getBookId(),bookInfo2.getBookName(),bookInfo2.getBookIntroduce(),bookInfo2.getBookCover(),bookInfo2.getBookStatus(),bookInfo2.getBookType());
				}
			}
		}
		return bookInfo;	
	}

	/**
	 * 判断书籍信息是否修改成功
	 */
	public Integer checkUpdateBookInfo(Integer bookId, String bookName, String bookIntroduce, String bookStatus, String bookType) {
		//获取所有用户信息
		List<BookInfo> bookInfos = bookDao.selectAllBook();
		boolean bo = false;
		if (bookInfos != null) {
			for (BookInfo bookInfo : bookInfos) {
				if (bookInfo.getBookId() == bookId) {
					//判断是否修改了值
					if (bookInfo.getBookName().equals(bookName) && bookInfo.getBookIntroduce().equals(bookIntroduce) && bookInfo.getBookStatus().equals(bookStatus) && bookInfo.getBookType().equals(bookType)) {
						return 0;
					} else {
						//修改数据库书籍信息
						bo = adminDao.updateBookInfo(bookId, bookName, bookIntroduce, bookStatus, bookType);
					}
				}
			}
		}
		if (bo) {
			//修改成功
			return 1;
		}else {
			//修改失败
			return 2;
		}
	}
}
