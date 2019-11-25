package com.seehope.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.dao.ITypeDao;
import com.seehope.dao.impl.TypeDaoImpl;
import com.seehope.po.Type;
import com.seehope.service.ITypeService;

public class TypeServiceImpl implements ITypeService {
    private ITypeDao typeDao =new TypeDaoImpl();
	@Override
	public ArrayList<Type> getTypes() throws SQLException {
		// TODO Auto-generated method stub
		return typeDao.getTypes();
	}

}
