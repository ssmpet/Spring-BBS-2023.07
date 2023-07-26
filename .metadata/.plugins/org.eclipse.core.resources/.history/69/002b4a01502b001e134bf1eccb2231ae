package com.ys.sbbs.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ys.sbbs.entity.User;

@Mapper
public interface UserDaoMySQL {

	@Select("select count(uid) from users where isDeleted=0")
	int getUserCount();
	
	@Select("select * from users where uid=?#{uid}")
	User getUser(String uid);
	
	@Select("")
	List<User> getUserList(int offset);
}
