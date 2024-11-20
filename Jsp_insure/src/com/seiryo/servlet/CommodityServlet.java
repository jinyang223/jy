package com.seiryo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.entity.Commodity_liability_info;
import com.seiryo.entity.MyUserInfo;
import com.seiryo.service.CommodityService;
import com.seiryo.service.impl.CommodityServiceImpl;
import com.seiryo.utile.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @ClassName: CommodityServlet
 * @Description: 商品制御層
 * @author JY
 */
public class CommodityServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	//インターフェースが実装クラスを指す
	private CommodityService commodityService = new CommodityServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//エンコーディング形式を設定する
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//判断情報を取得する
		String opt = req.getParameter("opt");
		//判断情報に基づいて異なるメソッドを呼び出す
		if("selectAllCommodityList".equals(opt)) {
			//商品種別に基づいて商品を検索するメソッドを呼び出す
			selectAllCommodity(req,resp);
		}else if("commodityQueryById".equals(opt)) {
			//商品IDに基づいて特定の商品内容を取得するメソッドを呼び出す
			commodityQueryById(req,resp);
		}else if("commodityQueryByType".equals(opt)) {
			//商品のタイプと現在のログインユーザー情報に基づいてすべての商品情報を照会する
			commodityQueryByType(req, resp);
		}
		
	}
	
	/**
	 * @Title: commodityQueryByType
	 * @Description: 商品種別に基づいて商品を検索する
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void commodityQueryByType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		
		//ページから渡された情報を取得する
		String commodity_type = req.getParameter("commodity_type");
		HttpSession session = req.getSession();
		session.setAttribute("commodityType", commodity_type);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	/**
	 * @Title: commodityQueryById
	 * @Description: 商品IDに基づいて特定の商品内容を取得し、保存する
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void commodityQueryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ページから渡された情報を取得する
		String commodity_id = req.getParameter("commodity_id");
		String pd = req.getParameter("pd");
		HttpSession session = req.getSession();
		List<Commodity_liability_info> commodityList = (ArrayList<Commodity_liability_info>)session.getAttribute("commodityList");
		for(Commodity_liability_info liability_info:commodityList) {
			if(liability_info.getCommodity_id() == Integer.parseInt(commodity_id)) {
				session.setAttribute("commodityInfo", liability_info);
				break;
			}
		}
		req.getRequestDispatcher(pd).forward(req, resp);
	}
	
	/**
	 * @Title: selectAllCommodity
	 * @Description: 商品のタイプと現在のログインユーザー情報に基づいてすべての商品情報を照会する
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void selectAllCommodity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//現在のログインユーザーのセッションを取得する
		HttpSession session = req.getSession();
		MyUserInfo myUserInfo = (MyUserInfo)session.getAttribute("user");
		//商品のタイプを取得する
		String commodityType = (String) session.getAttribute("commodityType");
		//商品のタイプと現在のログインユーザー情報に基づいてすべての商品情報を照会する（現在のユーザー情報に基づいてホームページで対応する商品を推薦する）
		List<Commodity_liability_info> commodityList = commodityService.selectAllCommodity(myUserInfo,commodityType);
		//照会した商品情報をセッションに保存する
		session.setAttribute("commodityList", commodityList);
		String data = "";
		try {
			data = JSONUtil.toJSONString(commodityList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().println(data);
		
	}
}
