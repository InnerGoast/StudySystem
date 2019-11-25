package com.seehope.service;

import java.sql.SQLException;

import com.seehope.po.User;

public interface IUserService {
    /***
     * 登录方法:根据用户输入的用户名和密码做校验
     * @param name
     * @param password
     * @return
     */
	public User login(String name, String password) throws SQLException;

}
