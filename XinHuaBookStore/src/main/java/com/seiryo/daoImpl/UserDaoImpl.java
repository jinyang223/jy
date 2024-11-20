package com.seiryo.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.dao.UserDao;
import com.seiryo.entity.UserInfo;
import com.seiryo.util.JDBCUTILE;

/**
 * @ClassName: UserDaoImpl
 * @Description: 用户数据层接口实现类
 * @author JY
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 获取所有正常用户信息
	 */
	public List<UserInfo> queryAllUserInfo() {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		ResultSet rs = null;
		String sql = "SELECT * FROM USER_INFO WHERE USER_STATUS = 1";
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
	 * 用户注册
	 */
	public boolean userRegist(String userNickName, String userAccount, String userPass) {
		String sql = "INSERT INTO USER_INFO(USER_ACCOUNT,USER_PASS,USER_NICKNAME) VALUES(?,?,?)";
		boolean bo = false;
		try {
			bo = JDBCUTILE.upDataBaseTable(sql,userAccount,userPass,userNickName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}
}
