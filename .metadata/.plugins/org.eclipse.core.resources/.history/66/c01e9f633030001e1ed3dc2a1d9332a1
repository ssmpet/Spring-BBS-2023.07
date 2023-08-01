package com.ys.sbbs.service;

import java.sql.Connection;
import java.util.List;

import com.ys.sbbs.entity.User;

public interface UserService {
	public static final int CORRECT_LOGIN = 0;
	public static final int WRONG_PASSWORD = 1;
	public static final int UID_NOT_EXIST = 2;

	public static final int LIST_PER_PAGE = 10;		// 한 페이지당 사용자 목록의 갯수
	public static final int PAGE_PER_SCREEN = 10;	// 한 화면에 표시되는 페이지 갯수
	
	int getUserCount();
	
	User getUser(String uid);
	
	List<User> getUserList(int page);
	
	void insertUser(User user);
	
	void updateUser(User user);
	
	void updateUserPassword(String pwd, String uid);
	
	void deleteUser(String uid);

	int login(String uid, String pwd);
}
