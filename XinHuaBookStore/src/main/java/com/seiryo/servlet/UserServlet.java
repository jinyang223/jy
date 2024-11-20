package com.seiryo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seiryo.entity.UserInfo;
import com.seiryo.service.UserService;
import com.seiryo.serviceImpl.UserServiceImpl;

/**
 * @ClassName: UserServlet
 * @Description: 用户控制层
 * @author JY
 */
public class UserServlet extends HttpServlet {
	
	//接口指向实现类
	private UserService userService = new UserServiceImpl();

	/**
	 * 实现方法
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取ajax传输值
		String opt = req.getParameter("opt");
		if ("login".equals(opt)) {
			//普通用户登录
			userLogin(req, resp);
		} else if ("adminLogin".equals(opt)) {
			//管理员登录
			adminLogin(req, resp);
		} else if ("userRegist".equals(opt)) {
			//用户注册
			userRegist(req, resp);
		} else if ("userLogout".equals(opt)) {
			//用户登出
			userLogout(req, resp);
		}
	}
	
	/**
	 * @Title: userLogin
	 * @Description: 普通用户登录
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取页面传输值
		String userAccount = req.getParameter("userAccount");
		String userPass = req.getParameter("userPass");
		Integer accountType = 0;
		//验证账号密码是否正确
		UserInfo userInfo = userService.checkLoginAccountAndPass(userAccount, userPass, accountType);
		if(userInfo != null) {
			//验证成功
			req.getSession().setAttribute("user", userInfo);
			resp.getWriter().println(0);
		}else {
			//验证失败
			resp.getWriter().println(2);
		}
	}

	/**
	 * @Title: adminLogin
	 * @Description: 管理员用户登录
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取页面传输值
		String userAccount = req.getParameter("userAccount");
		String userPass = req.getParameter("userPass");
		Integer accountType = 1;
		//验证账号密码是否正确
		UserInfo userInfo = userService.checkLoginAccountAndPass(userAccount, userPass, accountType);
		if(userInfo != null) {
			//验证成功
			req.getSession().setAttribute("user", userInfo);
			resp.getWriter().println(1);
		}else {
			//验证失败
			resp.getWriter().println(2);
		}
	}
	
	/**
	 * @Title: userRegist
	 * @Description: 用户注册
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void userRegist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面传输值
		String userNickName = req.getParameter("userNickName");
		String userAccount = req.getParameter("userAccount");
		String userPass = req.getParameter("userPass");
		//判断账号是否重复
		boolean boUserAccountCheck = userService.checkUserAccount(userAccount);
		if (boUserAccountCheck) {
			//账号重复注册
			resp.getWriter().println(0);
		} else {
			//信息存入数据库
			boolean bo = userService.userRegist(userNickName,userAccount,userPass);
			if (bo) {
				//注册成功
				resp.getWriter().println(1);
			} else {
				//注册失败
				resp.getWriter().println(2);
			}
		}
	}
	
	/**
	 * @Title: userLogout
	 * @Description: 用户登出
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void userLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//清除session
		req.getSession().invalidate();
	}
}
