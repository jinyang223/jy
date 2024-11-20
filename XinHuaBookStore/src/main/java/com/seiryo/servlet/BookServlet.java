package com.seiryo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seiryo.entity.BookInfo;
import com.seiryo.entity.LogInfo;
import com.seiryo.entity.UserInfo;
import com.seiryo.service.BookService;
import com.seiryo.serviceImpl.BookServiceImpl;
import com.seiryo.util.JSONUtil;

/**
 * @ClassName: BookServlet
 * @Description: 书籍控制层
 * @author JY
 */
public class BookServlet extends HttpServlet {
	
	//接口指向实现类
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 实现方法
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取ajax传输值
		String opt = req.getParameter("opt");
		if ("checkUserLoginSelectBooks".equals(opt)) {
			//展示全部商品
			checkUserLoginSelectBooks(req, resp);
		} else if ("chooseBook".equals(opt)) {
			//选择书籍借阅或归还
			chooseBook(req, resp);
		} else if ("searchBook".equals(opt)) {
			//根据关键字查询书籍
			searchBook(req, resp);
		} else if ("checkUserLoginSelectMyBooks".equals(opt)) {
			//查看当前登录用户正在阅读的书籍
			checkUserLoginSelectMyBooks(req, resp);
		}
	}
	
	/**
	 * @Title: checkUserLoginSelectMyBooks
	 * @Description: 查看当前登录用户正在阅读的书籍
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void checkUserLoginSelectMyBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//判断用户是否登录，未登录直接遍历所有书籍信息，登录则根据登录信息决定是否显示还书按钮
		UserInfo userInfo = (UserInfo)req.getSession().getAttribute("user");
		if (userInfo == null) {
			return;
		}
		//获取当前登录的用户id
		Integer userId = userInfo.getUserId();
		//查询所有日志信息
		List<LogInfo> logInfos = bookService.selectAllLogInfo();
		//查询所有书籍信息
		List<BookInfo> bookInfos = bookService.selectAllBook();
		//创建集合存储查询到的书籍信息
		List<BookInfo> bookInfos2 = new ArrayList<BookInfo>();
		if (logInfos != null && bookInfos != null) {
			for (LogInfo logInfo : logInfos) {
				if (logInfo.getLogUserId() == userId && logInfo.getLogBookReturnTime() == null) {
					for (BookInfo bookInfo : bookInfos) {
						if(bookInfo.getBookId() == logInfo.getLogBookId()) {
							bookInfos2.add(bookInfo);
						}
					}
				}
			}
		}
		req.getSession().setAttribute("bookInfos2", bookInfos2);
		String data = "";
		try {
			data = JSONUtil.toJSONString(bookInfos2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().println(data);
	}
	
	/**
	 * @Title: checkUserLoginSelectBooks
	 * @Description: 判断用户是否登录，决定index页面显示的书籍内容。未登录，直接全部正常显示，登录则根据用户借阅信息决定是否显示“我要还书”按钮
	 * @param   
	 * @return void    
	 * @throws
	 */
	private void checkUserLoginSelectBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//判断用户是否登录，未登录直接遍历所有书籍信息，登录则根据登录信息决定是否显示还书按钮
		UserInfo userInfo = (UserInfo)req.getSession().getAttribute("user");
		if (userInfo == null) {
			//调用查询所有书本信息的方法
			selectAllBook(req, resp);
			return ;
		}
		//获取当前登录的用户id
		Integer userId = userInfo.getUserId();
		//查询所有书籍信息
		List<BookInfo> bookInfos = bookService.selectAllBook();
		//查询所有日志信息
		List<LogInfo> logInfos = bookService.selectAllLogInfo();
		if (logInfos != null && bookInfos != null) {
			for (LogInfo logInfo : logInfos) {
				if (logInfo.getLogUserId() != userId && logInfo.getLogBookReturnTime() == null) {
					for (BookInfo bookInfo : bookInfos) {
						if (logInfo.getLogBookId() == bookInfo.getBookId()) {
							bookInfo.setBookReturnButton(1);
						}
					}
				}
			}
		}
		req.getSession().setAttribute("bookInfos", bookInfos);
		String data = "";
		try {
			data = JSONUtil.toJSONString(bookInfos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().println(data);
	}
	
	/**
	 * @Title: selectAllBook
	 * @Description: 展示全部商品
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void selectAllBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询所有书籍信息
		List<BookInfo> bookInfos = bookService.selectAllBook();
		req.getSession().setAttribute("bookInfos", bookInfos);
		String data = "";
		try {
			data = JSONUtil.toJSONString(bookInfos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().println(data);
	}
	
	/**
	 * @Title: chooseBook
	 * @Description: 选择书籍借阅或归还
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void chooseBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//选择借阅或归还的书籍id
		Integer bookId = Integer.parseInt(req.getParameter("bookId"));
		//判断用户是否登录，未登录无法借阅或归还
		UserInfo userInfo = (UserInfo)req.getSession().getAttribute("user");
		if (userInfo == null) {
			resp.getWriter().println(2);
			return ;
		}
		//获取当前登录的用户id
		Integer userId = userInfo.getUserId();
		//获取选中按钮
		String buttonValue = req.getParameter("buttonValue");
		boolean bookReturn = false;
		boolean bookBorrowing = false;
		if("我要还书".equals(buttonValue)) {
			bookReturn = true;
		} else if ("我要借书".equals(buttonValue)) {
			bookBorrowing = true;
		}
		//还书
		if (bookReturn) {
			//判断登录用户是否借阅了该书籍
			boolean bo = bookService.checkLoginUserBorrowing(bookId,userId);
			if(bo) {
				//该用户确实借阅了该书籍，且书籍未归还，进行还书操作（书籍状态、日志）
				//获取当前时间
				SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String nowDate = s.format(new Date());
				//还书操作（书籍状态、日志）
				boolean boBookReturn = bookService.loginUserBookReturn(bookId, userId, nowDate);
				if (boBookReturn) {
					//还书成功
					resp.getWriter().println(0);
				}else {
					//还书失败
					resp.getWriter().println(4);
				}
			}else {
				//未借阅该书籍
				resp.getWriter().println(3);
			}
		}
		//借书
		if (bookBorrowing) {
			//获取当前时间
			SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String nowDate = s.format(new Date());
			//借书操作
			boolean boBookBorrowing = bookService.loginUserBookBorrowing(bookId, userId, nowDate);
			if(boBookBorrowing) {
				//借书成功
				resp.getWriter().println(1);
			} else {
				//借书失败
				resp.getWriter().println(5);
			}
		}
	}
	
	/**
	 * @Title: searchBook
	 * @Description: 根据关键字查询书籍
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void searchBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面传输的关键字
		String keyword = req.getParameter("keyword");
		//查询有关书籍
		List<BookInfo> bookInfos = bookService.selectAllBookByKeyWord(keyword);
		String data = "";
		try {
			data = JSONUtil.toJSONString(bookInfos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().println(data);
	}
}
