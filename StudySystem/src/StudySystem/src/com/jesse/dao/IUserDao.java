package com.seehope.dao;

import java.sql.SQLException;

import com.seehope.po.User;

public interface IUserDao {
    /***
     * ����id��ȡ�û���
     * @param id
     * @return
     * @throws SQLException
     */
	public String getNameById(int id) throws SQLException;
    /***
     * ��¼����:У���û�������û����������Ƿ��ж�Ӧ������
     * @param name
     * @param password
     * @return
     * @throws SQLException
     */
	public User login(String name, String password) throws SQLException;

}
