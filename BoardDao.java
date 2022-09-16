package com.kh.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.BoardTemplate;

public class BoardDao {

	public int createPost(Connection conn, Board b) {

		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO BOARD " + "VALUES(SEQ_BOARD.NEXTVAL , ?, ?, DEFAULT,?, DEFAULT)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getWriter());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		BoardTemplate.close(pstmt);
		return result;
	}

	public ArrayList<Board> selectAll(Connection conn) {
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// Board b = new Board();
		// Member m = new Member();
		String sql = "SELECT BNO,TITLE,CONTENT,CREATE_DATE,USERID " + "FROM BOARD, MEMBER " + "WHERE WRITER = USERNO";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board b = new Board();
				Member m = new Member();
				b.setBno(rset.getInt("BNO"));
				b.setTitle(rset.getString("TITLE"));
				b.setContent(rset.getString("CONTENT"));
				b.setCreate_date(rset.getDate("CREATE_DATE"));
				b.setWriter(rset.getString("USERID"));

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BoardTemplate.close(rset);
		}
		BoardTemplate.close(pstmt);

		return list;
	}

	public ArrayList<Board> selectAll(Connection conn, int N) {
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Board b = null;
		Member m = null;

		String sql = "SELECT ROWNUM, BNO, TITLE, CONTENT, CREATE_DATE,USERID "
				+ "FROM(SELECT*FROM BOARD,MEMBER WHERE WRITER = USERNO ORDER BY CREATE_DATE DESC) "
				+ "WHERE ROWNUM <= ?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, N);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				b = new Board();
				m = new Member();

				b.setBno(rset.getInt("BNO"));
				b.setTitle(rset.getString("TITLE"));
				b.setContent(rset.getString("CONTENT"));
				b.setCreate_date(rset.getDate("CREATE_DATE"));
				b.setWriter(rset.getString("USERID"));

				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		BoardTemplate.close(rset);
		BoardTemplate.close(conn);

		return list;
	}

	public ArrayList<Board> selectDate(Connection conn, String dd) {
		ArrayList<Board> list = new ArrayList<>(); // 빈ArrayList 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Board b = null;
		Member m = null;

		String sql = "SELECT BNO , TITLE, CONTENT, CREATE_DATE, USERID, DELETE_YN " + "FROM BOARD, MEMBER "
				+ "WHERE EXTRACT(DAY FROM CREATE_DATE) = ? " + "AND WRITER = USERNO";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dd);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				b = new Board();
				m = new Member();
				b.setBno(rset.getInt("BNO"));
				b.setTitle(rset.getString("TITLE"));
				b.setContent(rset.getString("CONTENT"));
				b.setCreate_date(rset.getDate("CREATE_DATE"));
				b.setWriter(rset.getString("USERID"));

				list.add(b);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		BoardTemplate.close(rset);
		BoardTemplate.close(conn);

		return list;

	}

	public int userLogin(Connection conn, String userId, String userPwd) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		

		String sql = "SELECT USERID, USERPWD " + 
					 "FROM MEMBER " +  
					 "WHERE USERID = ? AND USERPWD = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			pstmt.setString(2,userPwd);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				m = new Member();
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				
			if (rset.getString(1).equals(userId) && (rset.getString(2).equals(userPwd))) 
				result = 1;

			 else if (rset.getString(1).equals(userId) && !(rset.getString(2).equals(userPwd))) 

				result = 0;
			
			else if (!(rset.getString(1).equals(userId)))

				result = -1;

			}

		} catch (SQLException e) {

			e.printStackTrace();
			BoardTemplate.close(rset);
			BoardTemplate.close(pstmt);
		}

		return result;
	}
}
