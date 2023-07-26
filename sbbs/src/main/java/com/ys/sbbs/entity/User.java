package com.ys.sbbs.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {

	private String uid;
	private String pwd;
	private String uname;
	private String email;
	private LocalDate regDate;
	private int isDeleted;
	private String profile;
	private String addr;
	
	// Update 할 경우 사용
	public User(String uid, String uname, String email, String profile, String addr) {
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.profile = profile;
		this.addr = addr;
	}

	// Insert 할 경우 사용
	public User(String uid, String pwd, String uname, String email, String profile, String addr) {
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.profile = profile;
		this.addr = addr;
	}
	
}
