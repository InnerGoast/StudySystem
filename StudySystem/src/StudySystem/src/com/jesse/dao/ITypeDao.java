package com.seehope.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.po.Type;

public interface ITypeDao {
    /***
     * ����id��ѯ��������
     * @param id
     * @return
     * @throws SQLException
     */
	public String getNameById(int id) throws SQLException;
    /***
     * ��ȡ���е������б�
     * @return
     * @throws SQLException
     */
	public ArrayList<Type> getTypes() throws SQLException;

}
