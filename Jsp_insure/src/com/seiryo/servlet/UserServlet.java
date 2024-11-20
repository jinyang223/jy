package com.seiryo.servlet;

import java.io.IOException;
import java.util.List;

import com.seiryo.entity.MyUserInfo;
import com.seiryo.service.UserService;
import com.seiryo.service.impl.UserServiceImpl;
import com.seiryo.utile.MD5UTIL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: UserServlet
 * @Description: ユーザー制御層
 * @author JY
 */
public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	//インターフェースが実装クラスを指す
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//エンコーディング形式を設定する
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//判断情報を取得する
		String opt = req.getParameter("opt");
		//判断情報に基づいて異なるメソッドを呼び出す
		if("user_regist".equals(opt)) {
			//ユーザー登録のメソッドを呼び出す
			userRegister(req,resp);
		} else if ("user_login".equals(opt)) {
			//ユーザーログインのメソッドを呼び出す
			userLogin(req,resp);
		} else if ("userInfoChange".equals(opt)) {
			//ユーザー情報変更のメソッドを呼び出す
			userInfoChange(req,resp);
		}
		
	}
	
	/**
	 * @Title: userInfoChange
	 * @Description: ユーザー情報変更のメソッド
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void userInfoChange(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ページから渡された情報を取得する
		String user_pass = req.getParameter("userPass");
		String user_phone = req.getParameter("userPhone");
		String addMoney = req.getParameter("addMoney");
		//チャージする金額
		Double addMoneyDouble = Double.parseDouble(addMoney);
		//現在のログインユーザーの情報IDを取得する
		MyUserInfo user = (MyUserInfo) req.getSession().getAttribute("user");
		Integer userInfoId = user.getUser_info_id();
		//変える前のパスワードを取得する
		String userPass = "";
		List<MyUserInfo> myUserInfoList = userService.selectAllUserInfo();
		for (MyUserInfo myUserInfo : myUserInfoList) {
			if (userInfoId.equals(myUserInfo.getUser_info_id())) {
				userPass = myUserInfo.getUser_password();
			}
		}
		Integer i = 0;
		//判断パスワードを変更したかどうか。パスワードを変更した場合、ログイン画面に戻る。パスワードを変更しなかった場合、現在のページを更新する。
		if (user_pass.equals(userPass)) {
			i = 2;
		} else {
			i = 1;
		}
		//ユーザー情報IDを通じてユーザー情報を更新する
		boolean bo = userService.upDataUserInfo(userInfoId,user_pass,user_phone,addMoneyDouble);
		//情報をAJAXに渡す
		if(bo) {
			if(i == 1) {
				resp.getWriter().println(1);
			} else {
				//メールアドレスとパスワードでログイン成功を判断し、成功した場合に現在のログインユーザーの情報を取得する
				myUserInfoList = userService.selectAllUserInfo();
				for (MyUserInfo myUserInfo : myUserInfoList) {
					if (userInfoId.equals(myUserInfo.getUser_info_id())) {
						user.setUser_phone(myUserInfo.getUser_phone());
						user.setUser_money(myUserInfo.getUser_money());
					}
				}
				req.getSession().setAttribute("user", user);
				resp.getWriter().println(2);
			}
		} else {
			resp.getWriter().println(0);
		}
	}
	
	/**
	 * @Title: userLogin
	 * @Description: ユーザーログインのメソッド
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//ページから渡された情報を取得する
		String user_email = req.getParameter("userEmail");
		String user_pass = req.getParameter("userPass");
		//MD5暗号化
		user_pass = MD5UTIL.md5(user_pass);
		//メールアドレスとパスワードでログイン成功を判断し、成功した場合に現在のログインユーザーの情報を取得する
		MyUserInfo user = userService.pdUserLogin(user_email, user_pass);
		if(user != null) {
			HttpSession session = req.getSession();
			//取得したユーザー情報をセッションに保存する
			session.setAttribute("user", user);
			//情報をAJAXに渡す
			resp.getWriter().println(1);
		}else {
			//情報をAJAXに渡す
			resp.getWriter().println(0);
		}
	}
	
	/**
	 * @Title: userRegister
	 * @Description: ユーザー登録のメソッド
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void userRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//ページから渡された情報を取得する
		String userName = req.getParameter("userName");
		String userBirthday = req.getParameter("userBirthday");
		String userSex = req.getParameter("userSex");
		String userPhone = req.getParameter("userPhone");
		String userEmail = req.getParameter("userEmail");
		String userPass = req.getParameter("userPass");
		if("1".equals(userSex)) {
			userSex = "先生";
		}else {
			userSex = "女士";
		}
		//初期化パラメーターを設定する
		int a = 0;
		//アカウントが重複しているかどうかを判断するメソッドを呼び出す(メールアドレスと携帯電話が重複するかどうかを判断する)
		if(!(userService.pdUserEmail(userEmail)) && !(userService.pdUserPhone(userPhone))) {
			//新しいオブジェクトを作成してユーザー情報を保存する
			MyUserInfo myUserInfo = new MyUserInfo(null,userEmail,userPass, null, userPhone, "0", userName, userBirthday,userSex, 1);
			//ユーザー情報を挿入(そうにゅう)する
			if(userService.insertUser(myUserInfo)) {
				a = 1;
			} else {
				a = 3;
			}
		} else {
			a = 2;
		}
		//情報をAJAXに渡す
		resp.getWriter().println(a);
	}
}
