package com.seehope.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.po.Type;

public interface ITypeService {
   /**
    * ��ȡ���е���Ϣ����б�
    * @return
    * @throws SQLException
    */
	public ArrayList<Type> getTypes() throws SQLException;

}
