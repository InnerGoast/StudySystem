package com.seehope.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.po.Type;

public interface ITypeService {
   /**
    * 获取所有的消息类别列表
    * @return
    * @throws SQLException
    */
	public ArrayList<Type> getTypes() throws SQLException;

}
