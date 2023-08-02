package com.ys.sbbs.dbo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ys.sbbs.entity.Board;
import com.ys.sbbs.entity.Reply;
import com.ys.sbbs.entity.User;

public class OracleDaoTest {

	public Connection getConnection() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
	//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String user = "ysuser";
		String password = "yspass";
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
//			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
		
		/*접속 해제 처리*/
//		try {
//			conn.close();
//			System.out.println("연결 해제");
//		} catch (Exception e) {
//			System.out.println("해제 오류");
//		}
		
		return conn;
	}
	
	public void getUserAllCount() {
		Connection conn = getConnection();
		
		String sql = "select count(uid) from users where isDeleted=0";

		int count = 0;
		
		try {
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				count = rs.getInt(1);
				System.out.println("getUserAllCount = " + count);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public List<User> getListUser(int page) {
		List<User> list = new ArrayList<User>();
		int offset = (page - 1) * 10;
		Connection conn = getConnection();
		String sql = "select * from users where isDeleted=0";
		
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						LocalDate.parse(rs.getString(5).substring(0, 10)), rs.getInt(6), rs.getString(7), rs.getString(8)));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Reply> getReplyList(int bid) {
		List<Reply> list = new ArrayList<Reply>();
		
		Connection conn = getConnection();
		
		String sql = "SELECT r.rid, r.\"comment\", r.regTime, r.isMine, r.\"uid\", r.bid, u.uname"
				+ "    FROM reply r join users u "
				+ "    on r.\"uid\"=u.\"uid\" where r.bid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				
				Reply reply = new Reply(rs.getInt(1), rs.getString(2),
						LocalDateTime.parse(rs.getString(3).substring(0, 19).replace(" ", "T")), 
						rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				
				list.add(reply);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Board getBoard(int bid) {
		
		Connection conn = getConnection();
		Board board = new Board();
		String sql = "SELECT b.bid, b.\"uid\", b.title, b.content, b.modTime, b.viewCount,"
				+ "	b.replyCount, b.files, u.uname "
				+ "	FROM board b JOIN users u ON b.\"uid\" = u.\"uid\""
				+ "	WHERE b.bid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setBid(rs.getInt(1));
				board.setUid(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setModTime(LocalDateTime.parse( rs.getString(5).substring(0, 19).replace(" ", "T")));
				board.setViewCount(rs.getInt(6));
				board.setReplyCount(rs.getInt(7));
				board.setFiles(rs.getString(8));
				board.setUname(rs.getString(9));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}

	public void updateBoard(Board board) {
		Connection conn = getConnection();
		String sql = "update board set title=?, content=?, modTime=CURRENT_TIMESTAMP, files=? where bid=?"; 

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getFiles());
			pstmt.setInt(4, board.getBid());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
