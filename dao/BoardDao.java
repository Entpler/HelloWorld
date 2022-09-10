package model.vo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Board;

public class BoardDao {

	public int createPost(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD " + "VALUES (SEQ_BOARD.NEXTVAL,?,?,DEFAULT,?,DEFAULT)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getWriter());

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
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD " + "SET CONTENT = ? " + "WHERE BNO =  ?";

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
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<>();
		String sql = "SELECT * FROM  BOARD ";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board b = new Board();

				b.setBno(rset.getInt("BNO"));
				b.setTitle(rset.getString("TITLE"));
				b.setContent(rset.getString("CONTENT"));
				b.setCreate_date(rset.getDate("CREATE_DATE"));
				b.setWriter(rset.getInt("WRITER"));
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
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE BNO = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
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
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM BOARD WHERE TITLE LIKE ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Board(rset.getInt("BNO"), rset.getString("TITlE"), rset.getString("CONTENT"),
						rset.getDate("CREATE_DATE"), rset.getInt("WRITER"), rset.getString("DELETE_YN")));

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

	public ArrayList<Board> searForTitle(Connection conn, int writer) {
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM BOARD WHERE WRITER = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writer);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Board(rset.getInt("BNO"), rset.getString("TITLE"), rset.getString("CONTENT"),
						rset.getDate("CREATE_DATE"), rset.getInt("WRITER"), rset.getString("DELETE_YN")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}
}
