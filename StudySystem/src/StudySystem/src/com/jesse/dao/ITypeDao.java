package com.seehope.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.po.Type;

public interface ITypeDao {
    /***
     * 根据id查询类型名称
     * @param id
     * @return
     * @throws SQLException
     */
	public String getNameById(int id) throws SQLException;
    /***
     * 获取所有的类型列表
     * @return
     * @throws SQLException
     */
	public ArrayList<Type> getTypes() throws SQLException;

}
