package com.ys.sbbs.dbo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ys.sbbs.entity.User;

@Mapper
public interface UserDaoOracle {

	@Select("select count(uname) from users where isDeleted=0")
	int getUserCount();
	
	@Select("select * from users where \"uid\"=#{uid}")
	User getUser(String uid);
	
	@Select("select u.* from users u"
			+ "	where isDeleted=0 order by regDate desc, \"uid\""
			+ " offset #{offset} rows fetch next 10 rows only")
	List<User> getUserList(int offset);

	@Insert("insert into users values(#{uid}, #{pwd}, #{uname}, "
			+ " #{email}, default, default, "
			+ " #{profile, jdbcType=VARCHAR},"
			+ " #{addr, jdbcType=VARCHAR})")
	void insertUser(User user);

	@Update("update users set uname=#{uname}, email=#{email},"
			+ " \"profile\"=#{profile, jdbcType=VARCHAR},"
			+ " addr=#{addr, jdbcType=VARCHAR} where \"uid\"=#{uid}")
	void updateUser(User user);

	@Update("update users set isDeleted=1 where \"uid\"=#{uid}")
	void deleteUser(String uid);
	
	@Update("update users set pwd=#{pwd} where \"uid\"=#{uid}")
	void updateUserPassword(String pwd, String uid);
}
