package model.vo.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.vo.Board;

public class BoardDao {

	Member m = new Member();
	
	
	
	public int createPost(Connection conn, Board b) {

		// query 를 바깥으로 빼주는 처리.
		Properties prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
			// 이 시점이 후로는 query.xml 로부터 읽어들인 key+ value 세트들이 담겨있을것.
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int result = 0;
		PreparedStatement pstmt = null;
		// String sql = "INSERT INTO BOARD " + "VALUES
		// (SEQ_BOARD.NEXTVAL,?,?,DEFAULT,?,DEFAULT)";

		String sql = prop.getProperty("createPost");
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getWriter());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int modifyPost(Connection conn, Board b) {

		Properties prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
			// prop에 내가 만든 key, value 들이 담겨있음. key 값을 제시해서 쿼리문을 읽어들일것임.
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String sql = prop.getProperty("modifyPost"); // => 동적코딩방식

		int result = 0;
		PreparedStatement pstmt = null;
		// String sql = "UPDATE BOARD " + "SET CONTENT = ? " + "WHERE BNO = ?"; =>정적코딩방식

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getContent());
			pstmt.setInt(2, b.getBno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Board> selectAll(Connection conn) {

		Properties prop = new Properties(); // 파일로부터읽어들이기
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<>();
		// String sql = "SELECT * FROM BOARD B , MEMBER M"
		// + " WHERE B.WRITER = M.USERNO " ;
		String sql = prop.getProperty("selectAll");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board b = new Board();
				Member m = new Member(); // 조인 이용

				b.setBno(rset.getInt("BNO"));
				b.setTitle(rset.getString("TITLE"));
				b.setContent(rset.getString("CONTENT"));
				b.setCreate_date(rset.getDate("CREATE_DATE"));
				b.setWriter(rset.getString("USERID")); // 조인 이용
				b.setDelete_yn(rset.getString("DELETE_YN"));
				list.add(b);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int deletePost(Connection conn, int bno) {

		Properties prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PreparedStatement pstmt = null;
		int result = 0;
		// String sql = "UPDATE BOARD WHERE BNO = ? ";
		String sql = prop.getProperty("deletePost");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Board> searForTitle(Connection conn, String keyword) {

		Properties prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// String sql = "SELECT * FROM BOARD WHERE TITLE LIKE ?";
		String sql = prop.getProperty("searForTitle");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board b = new Board();
				Member m = new Member();
				
				b.setBno(rset.getInt("BNO"));
				b.setTitle(rset.getString("TITLE"));
				b.setContent(rset.getString("CONTENT"));
				b.setCreate_date(rset.getDate("CREATE_DATE"));
				b.setWriter(rset.getString("USERID")); // 조인 이용
				b.setDelete_yn(rset.getString("DELETE_YN"));
				list.add(b);

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public ArrayList<Board> searchForUser(Connection conn, String userId) {
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Properties prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//String sql = "SELECT * FROM BOARD WHERE WRITER = ? ";
		
		String sql = prop.getProperty("searchForUser");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				
				Board b = null;
				//Member m = new Member();
				
				/*
				 * b.setBno(rset.getInt("BNO")) b.setTitle(rset.getString("TITLE"));
				 * b.setContent(rset.getString("CONTENT"));
				 * b.setCreate_date(rset.getDate("CREATE_DATE"));
				 * b.setWriter((rset.getString("USERID")); // 조인 이용
				 * b.setDelete_yn(rset.getString("DELETE_YN"));
				 */
				
				list.add(new Board(rset.getInt("BNO"),
								   rset.getString("TITLE"),
								   rset.getString("CONTENT"),
								   rset.getDate("CREATE_DATE"),	
								   rset.getString("USERID"),
								   rset.getString("DELETE_YN")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	public ArrayList<Board> selectDate(Connection conn, int writed_date) {
		ArrayList<Board> list = new ArrayList<>(); // 빈ArrayList 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Properties prop = new Properties();
		String sql = prop.getProperty("selectDate");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1,writed_date);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Board(rset.getInt("BNO"),
						   rset.getString("TITLE"),
						   rset.getString("CONTENT"),
						   rset.getDate("CREATE_DATE"),	
						   rset.getString("USERID"),
						   rset.getString("DELETE_YN")));
		
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		return list;
	}
}
