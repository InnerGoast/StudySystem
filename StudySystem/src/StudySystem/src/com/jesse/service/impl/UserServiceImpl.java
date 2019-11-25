package com.seehope.service.impl;

import java.sql.SQLException;

import com.seehope.dao.IUserDao;
import com.seehope.dao.impl.UserDaoImpl;
import com.seehope.po.User;
import com.seehope.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao =new UserDaoImpl();
	@Override
	public User login(String name, String password) throws SQLException{
		return userDao.login(name,password);
	}

}
