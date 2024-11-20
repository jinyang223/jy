package com.seiryo.servlet;

import java.io.IOException;
import java.util.List;

import com.seiryo.entity.MyUserInfo;
import com.seiryo.entity.My_order_info;
import com.seiryo.service.OrderService;
import com.seiryo.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: OrderServlet
 * @Description: 注文制御層
 * @author JY
 */
public class OrderServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	//インターフェースが実装クラスを指す
	private OrderService orderService = new OrderServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//エンコーディング形式を設定する
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//判断情報を取得する
		String opt = req.getParameter("opt");
		//判断情報に基づいて異なるメソッドを呼び出す
		if("select_order_by_user_id".equals(opt)) {
			//ユーザーIDに基づいてすべての注文情報を照会するメソッドを呼び出す
			selectOrderByUserId(req,resp);
		} else if ("insert_order".equals(opt)) {
			//注文を追加するメソッドを呼び出す
			insertOrder(req,resp);
		}
	}
	
	/**
	 * @Title: insertOrder
	 * @Description: 注文を追加する
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void insertOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String order_id = req.getParameter("order_id");
		//現在のログインしたユーザーのユーザー情報IDを取得する
		MyUserInfo user = (MyUserInfo) req.getSession().getAttribute("user");
		Integer userInfoId = user.getUser_info_id();
		//ユーザー情報IDに基づいてユーザーIDを取得する
		Integer user_id = orderService.selectUserIdByUserInfoId(userInfoId);
		//ページで購入された商品の情報を取得する
		Integer commodity_id = Integer.parseInt(req.getParameter("commodity_id"));
		String order_commodity_liability1 = req.getParameter("order_commodity_liability1");
		String order_commodity_liability2 = req.getParameter("order_commodity_liability2");
		String order_commodity_liability3 = req.getParameter("order_commodity_liability3");
		String order_commodity_liability4 = req.getParameter("order_commodity_liability4");
		String order_commodity_liability5 = req.getParameter("order_commodity_liability5");
		String order_commodity_liability6 = req.getParameter("order_commodity_liability6");
		String order_commodity_liability7 = req.getParameter("order_commodity_liability7");
		String order_beneficiary_name = req.getParameter("order_beneficiary_name");
		String order_beneficiary_age = req.getParameter("order_beneficiary_age");
		String order_beneficiary_phone = req.getParameter("order_beneficiary_phone");
		String order_commodity_time_start = req.getParameter("order_commodity_time_start");
		String order_commodity_time_lengths = req.getParameter("order_commodity_time_lengths");
		Integer time_end = Integer.parseInt(order_commodity_time_start) + Integer.parseInt(order_commodity_time_lengths);
		String order_commodity_time_end = String.valueOf(time_end);
		String order_sum_price = req.getParameter("order_sum_price");
		//被保険者がアカウントを登録したかどうかを判断する
		Integer checkIsInsuredAccount = orderService.checkIsInsuredAccount(order_beneficiary_name, order_beneficiary_age, order_beneficiary_phone);
		//checkIsInsuredAccount = 0：被保険者が登録しており、さらにここでの3つの情報検証が成功した 
		//checkIsInsuredAccount = 6：そのユーザーは登録されていませんが、保険を購入することも可能です
		if (checkIsInsuredAccount == 0 || checkIsInsuredAccount == 6) {
			//被保険者の情報に誤りはない。被保険者の年齢が保険商品の加入年齢に該当するかどうかを判断する
			My_order_info my_order_info = new My_order_info();
			my_order_info.setOrder_id(order_id);
			my_order_info.setUser_id(user_id);
			my_order_info.setCommodity_id(commodity_id);
			my_order_info.setOrder_commodity_liability1(order_commodity_liability1);
			my_order_info.setOrder_commodity_liability2(order_commodity_liability2);
			my_order_info.setOrder_commodity_liability3(order_commodity_liability3);
			my_order_info.setOrder_commodity_liability4(order_commodity_liability4);
			my_order_info.setOrder_commodity_liability5(order_commodity_liability5);
			my_order_info.setOrder_commodity_liability6(order_commodity_liability6);
			my_order_info.setOrder_commodity_liability7(order_commodity_liability7);
			my_order_info.setOrder_beneficiary_name(order_beneficiary_name);
			my_order_info.setOrder_beneficiary_age(order_beneficiary_age);
			my_order_info.setOrder_beneficiary_phone(order_beneficiary_phone);
			my_order_info.setOrder_commodity_time_start(order_commodity_time_start);
			my_order_info.setOrder_commodity_time_length(order_commodity_time_lengths);
			my_order_info.setOrder_commodity_time_end(order_commodity_time_end);
			my_order_info.setOrder_sum_price(order_sum_price);
			//被保険者の年齢が保険商品の加入年齢に該当するかどうかを判断する
			boolean checkOrderBeneficiaryAge = orderService.checkOrderBeneficiaryAge(commodity_id, order_beneficiary_age);
			if (checkOrderBeneficiaryAge) {
				//金額が十分かどうかを確認する
				boolean boMoney = orderService.checkUserMoney(order_sum_price,userInfoId);
				if (boMoney) {
					//注文が正常に追加されたかどうかを判断する
					boolean bo = orderService.insertOrderInfo(my_order_info);
					if (bo) {
						List<My_order_info> orderList = orderService.selectOrderByUserId(userInfoId);
						req.getSession().setAttribute("orderList", orderList);
						//注文追加に成功した
						resp.getWriter().println(1);
					} else {
						//注文追加に失敗した
						resp.getWriter().println(0);
					}
					
				} else {
					//残高不足
					resp.getWriter().println(2);
				}
			} else {
				//被保険者の年齢が該当しない
				resp.getWriter().println(3);
			}	
		} else if (checkIsInsuredAccount == 4) {
			//被保険者は登録済みですが、ここで姓名と電話番号の検証に失敗した
			resp.getWriter().println(4);
		} else if (checkIsInsuredAccount == 5) {
			//被保険者は登録済みですが、ここで年齢が正しくない
			resp.getWriter().println(5);
		}
	}
	
	/**
	 * @Title: selectOrderByUserId
	 * @Description: 現在のログインしたユーザーのユーザーIDに基づいてすべての注文情報を照会する
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  
	 * @return void    
	 * @throws
	 */
	private void selectOrderByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//現在のログインユーザーの情報IDを取得する
		MyUserInfo user = (MyUserInfo) req.getSession().getAttribute("user");
		Integer userInfoId = user.getUser_info_id();
		List<My_order_info> orderList = orderService.selectOrderByUserId(userInfoId);
		req.getSession().setAttribute("orderList", orderList);
		resp.sendRedirect("my_order.jsp");
	}
	
}
