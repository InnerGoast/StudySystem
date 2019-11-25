package com.seehope.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.seehope.dao.IUserDao;
import com.seehope.dao.impl.utils.DBUtils;
import com.seehope.po.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String getNameById(int id) throws SQLException {
		String name="";
		Connection con=DBUtils.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from city_info_user where id=?");
		pst.setInt(1, id);
		ResultSet rs =pst.executeQuery();
		while(rs.next()){
			name=rs.getString("name");
		}
		DBUtils.close(con, pst, rs);
		return name;
	}

	@Override
	public User login(String name, String password) throws SQLException {
		User user=null;
		Connection con=DBUtils.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from city_info_user where role=1 and name=? and password=?");
		pst.setString(1, name);
		pst.setString(2, password);
		ResultSet rs =pst.executeQuery();
		while(rs.next()){
			user=new User();
		    user.setId(rs.getInt("id"));
		    user.setName(rs.getString("name"));
		    user.setPassword(rs.getString("password"));
		    user.setLoginTime(rs.getDate("loginTime"));
		    user.setRole(rs.getInt("role"));
		}
		return user;
	}

}
