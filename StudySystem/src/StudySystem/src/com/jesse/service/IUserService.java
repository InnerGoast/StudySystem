package com.seehope.service;

import java.sql.SQLException;

import com.seehope.po.User;

public interface IUserService {
    /***
     * ��¼����:�����û�������û�����������У��
     * @param name
     * @param password
     * @return
     */
	public User login(String name, String password) throws SQLException;

}
