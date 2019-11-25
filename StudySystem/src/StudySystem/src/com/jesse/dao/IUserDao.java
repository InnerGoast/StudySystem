package com.seehope.dao;

import java.sql.SQLException;

import com.seehope.po.User;

public interface IUserDao {
    /***
     * 根据id获取用户名
     * @param id
     * @return
     * @throws SQLException
     */
	public String getNameById(int id) throws SQLException;
    /***
     * 登录功能:校验用户传入的用户名和密码是否有对应的数据
     * @param name
     * @param password
     * @return
     * @throws SQLException
     */
	public User login(String name, String password) throws SQLException;

}
