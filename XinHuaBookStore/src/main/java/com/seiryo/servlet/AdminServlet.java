package com.seiryo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.seiryo.entity.BookInfo;
import com.seiryo.entity.LogInfo;
import com.seiryo.entity.UserInfo;
import com.seiryo.service.AdminService;
import com.seiryo.serviceImpl.AdminServiceImpl;
import com.seiryo.util.JSONUtil;

/**
 * @ClassName: AdminServlet
 * @Description: 管理控制层
 * @author JY
 */
public class AdminServlet extends HttpServlet {
	
	//接口指向实现类
	private AdminService adminService = new AdminServiceImpl();
	
	/**
	 * 实现方法
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取ajax传输值
		String opt = req.getParameter("opt");
		if ("selectAllData".equals(opt)) {
			//进入管理员页面刷新数据表数据	
			selectAllData(req, resp);
		}else if ("deleteUserByUserId".equals(opt)) {
			//根据用户id删除用户信息
			deleteUserByUserId(req, resp);
		}else if ("addUser".equals(opt)) {
			//新增用户
			addUser(req, resp);
		}else if ("selectUserById".equals(opt)) {
			//根据用户id查询用户信息
			selectUserById(req, resp);
		}else if ("updateUserInfo".equals(opt)) {
			//修改用户信息
			updateUserInfo(req, resp);
		}else if ("addBook".equals(opt)) {
			//新增书籍
			addBook(req, resp);
		}else if ("deleteBookByBookId".equals(opt)) {
			//根据书籍id删除书籍信息
			deleteBookByBookId(req, resp);
		}else if ("selectBookById".equals(opt)) {
			//根据用户id查询书籍信息
			selectBookById(req, resp);
		}else if ("updateBookInfo".equals(opt)) {
			//修改书籍信息
			updateBookInfo(req, resp);
		}
	}
	
	/**
	 * @Title: selectAllData
	 * @Description: 查询所有表格数据
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void selectAllData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取所有用户数据
		List<UserInfo> userInfos = adminService.queryAllUserInfo();
		//获取所有书籍书籍
		List<BookInfo> bookInfos = adminService.selectAllBook();
		//获取所有日志信息
		List<LogInfo> logInfos = adminService.selectAllLogInfo();
		//创建一个Map集合存储这三个集合
		Map<String, Object> allDataMap = new HashMap<String, Object>();
		allDataMap.put("userInfos", userInfos);
		allDataMap.put("bookInfos", bookInfos);
		allDataMap.put("logInfos", logInfos);
		//将Map转换为JSON字符串
		String data = "";
		try {
			data = JSONUtil.toJSONString(allDataMap);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//将JSON字符串响应给客户端
		resp.getWriter().println(data);
	}
	
	/**
	 * @Title: deleteUser
	 * @Description: 删除用户信息
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void deleteUserByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取选中的用户id
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		boolean bo = adminService.deleteUserByUserId(userId);
		if(bo) {
			//删除成功
			resp.getWriter().println(0);
		}
	}
	
	/**
	 * @Title: addUser
	 * @Description: 新增用户
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取输入的新用户各项信息
		String userAccount = req.getParameter("username");
		String userPass = req.getParameter("password");
		String userNickName = req.getParameter("nickname");
		String userStatus = req.getParameter("status");
		String userType = req.getParameter("type");
		//判断账号是否重复
		boolean boUserAccountCheck = adminService.checkUserAccount(userAccount);
		if (boUserAccountCheck) {
			//账号重复
			resp.getWriter().println(1);
		} else {
			//新增用户
			boolean bo = adminService.addNewUser(userAccount, userPass, userNickName, userStatus, userType);
			if (bo) {
				//添加成功
				resp.getWriter().println(0);
			}
		}	
	}
	
	/**
	 * @Title: selectUserById
	 * @Description: 根据用户id查询用户信息
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void selectUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取选中的用户id
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		//根据用户id获取用户数据
		UserInfo userInfo = adminService.selectUserById(userId);
		if(userInfo != null) {
			req.getSession().setAttribute("userInfo", userInfo);
			resp.getWriter().println(1);
		}
	}
	
	/**
	 * @Title: updateUserInfo
	 * @Description: 修改用户信息
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void updateUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取修改的用户信息
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		String userPass = req.getParameter("userPass");
		String userNickName = req.getParameter("userNickName");
		String userStatus = req.getParameter("userStatus");
		String userType = req.getParameter("userType");
		//判断用户信息是否修改成功
		Integer checkUpdateUserInfo = adminService.checkUpdateUserInfo(userId, userPass, userNickName, userStatus, userType);
		if (checkUpdateUserInfo == 0) {
			//管理员并未修改值
			resp.getWriter().println(0);
		} else if (checkUpdateUserInfo == 1) {
			//修改成功
			resp.getWriter().println(1);
		} else if (checkUpdateUserInfo == 2) {
			//修改失败
			resp.getWriter().println(2);
		}
	}
	
	/**
	 * @Title: addBook
	 * @Description: 新增书籍
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取输入的新商品各项信息
		String bookname = req.getParameter("bookname");
		String bookIntroduce = req.getParameter("bookIntroduce");
		String bookStatus = req.getParameter("bookStatus");
		String bookType = req.getParameter("bookType");
		//新增书籍
		boolean bo = adminService.addNewBook(bookname, bookIntroduce, bookStatus, bookType);
		if (bo) {
			//添加成功
			resp.getWriter().println(0);
		}
	}
	
	/**
	 * @Title: deleteBookByBookId
	 * @Description: 根据书籍id删除书籍信息
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void deleteBookByBookId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取选中的用户id
		Integer bookId = Integer.parseInt(req.getParameter("bookId"));
		boolean bo = adminService.deleteBookByBookId(bookId);
		if(bo) {
			//删除成功
			resp.getWriter().println(0);
		}
	}
	
	/**
	 * @Title: selectBookById
	 * @Description: 根据用户id查询书籍信息
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void selectBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取选中的书籍id
		Integer bookId = Integer.parseInt(req.getParameter("bookId"));
		//根据书籍id获取书籍数据
		BookInfo bookInfo = adminService.selectBookById(bookId);
		if(bookInfo != null) {
			req.getSession().setAttribute("bookInfo", bookInfo);
			resp.getWriter().println(1);
		}
	}
	
	/**
	 * @Title: updateBookInfo
	 * @Description: 修改书籍信息
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void updateBookInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取修改的书籍信息
		Integer bookId = Integer.parseInt(req.getParameter("bookId"));
		String bookName = req.getParameter("bookName");
		String bookIntroduce = req.getParameter("bookIntroduce");
		String bookStatus = req.getParameter("bookStatus");
		String bookType = req.getParameter("bookType");
		//判断书籍信息是否修改成功
		Integer checkUpdateBookInfo = adminService.checkUpdateBookInfo(bookId, bookName, bookIntroduce, bookStatus, bookType);
		if (checkUpdateBookInfo == 0) {
			//管理员并未修改值
			resp.getWriter().println(0);
		} else if (checkUpdateBookInfo == 1) {
			//修改成功
			resp.getWriter().println(1);
		} else if (checkUpdateBookInfo == 2) {
			//修改失败
			resp.getWriter().println(2);
		}
	}
}
