package com.ys.sbbs.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.sbbs.db.UserDaoMySQL;
import com.ys.sbbs.entity.User;

@Service
public class UserServiceMySQLImpl implements UserService{
	@Autowired private UserDaoMySQL userDao;

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserCount() {
		int count = userDao.getUserCount();
		return count;
	}

	@Override
	public User getUser(String uid) {
		User user = userDao.getUser(uid);
		return user;
	}

	@Override
	public List<User> getUserList(int page) {
		int offset = (page - 1) * 10;
		List<User> list = userDao.getUserList(offset);
		return list;
	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserPassword(String pwd, String uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int login(String uid, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}