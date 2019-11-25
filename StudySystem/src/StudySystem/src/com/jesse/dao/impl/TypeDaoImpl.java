package com.seehope.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.dao.ITypeDao;
import com.seehope.dao.impl.utils.DBUtils;
import com.seehope.po.Type;

public class TypeDaoImpl implements ITypeDao {

	@Override
	public String getNameById(int id) throws SQLException {
		String name="";
		Connection con =DBUtils.getConnection();
		PreparedStatement pst =con.prepareStatement("select * from city_info_type where id=?");
		pst.setInt(1, id);
		ResultSet rs =pst.executeQuery();
		while(rs.next()){
			name=rs.getString("name");
		}
		DBUtils.close(con, pst, rs);
		return name;
	}

	@Override
	public ArrayList<Type> getTypes() throws SQLException {
		ArrayList<Type> types =new ArrayList<Type>();
		Connection con =DBUtils.getConnection();
		PreparedStatement pst =con.prepareStatement("select * from city_info_type");
		ResultSet rs =pst.executeQuery();
		while(rs.next()){
			Type type =new Type();
			type.setId(rs.getInt("id"));
			type.setName(rs.getString("name"));
			types.add(type);
		}
		return types;
	}

}
