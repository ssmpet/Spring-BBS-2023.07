package com.ys.sbbs.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Board {
	private int bid;
	private String uid;
	private String title;
	private String content;
	private LocalDateTime modTime;
	private int viewCount;
	private int replyCount;
	private int isDeleted;
	private String files;
	private String uname;
	
	public Board(String uid, String title, String content, String files) {
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.files = files;
	}

	
	// 게시글 수정시 필요한 생성자
	public Board(int bid, String title, String content, String files) {
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.files = files;
	}

	// 게시글 목록 조회시 필요한 생성자
	public Board(int bid, String title, LocalDateTime modTime, int viewCount, int replyCount, String files,
			String uname) {
		this.bid = bid;
		this.title = title;
		this.modTime = modTime;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.files = files;
		this.uname = uname;
	}
	
}
