package com.kh.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.BoardTemplate;



public class BoardService {

	String classname = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "JDBC";
	String password = "JDBC";

	public int createPost(Board b) {
		int result = 0;

		try {
			Class.forName(classname);
			Connection conn = DriverManager.getConnection(url, id, password);
			result = new BoardDao().createPost(conn, b);
			if (result > 0) {
				BoardTemplate.commit(conn);
				
			}else
				BoardTemplate.rollback(conn);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = new ArrayList<>();
		try {
			Class.forName(classname);
			Connection conn = DriverManager.getConnection(url, id, password);
			list = new BoardDao().selectAll(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Board> searchForTopN(int N) {
		ArrayList<Board> list = new ArrayList<>();
		try {
			Class.forName(classname);
			Connection conn = DriverManager.getConnection(url, id, password);
			list = new BoardDao().selectAll(conn, N);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Board> selectDate(String dd) {
		
			 ArrayList<Board> list = null;
			 Connection conn = null;
			 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
				list = new BoardDao().selectDate(conn, dd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return list;
			}
		}

		