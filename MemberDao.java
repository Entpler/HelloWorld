package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

/* 
 *DAO (Data Access Object)
 *Controller 를 통해서 호출된 기능을 수행하기 위해
 *DB에 직접적으로 접근 한 후 해당 SQL 문 실행 및 결과를 받는 부분
 *=>JDBC 코드 작성
 */
public class MemberDao {
	

	/*
	 * *JDBC 용 객체 -Connection :DB의 연결정보를 담고 있는 객체 -(Prepared ) Statement : 해당 DB에
	 * SQL 문을 전달하고 실행한 결과를 받아내는 객체 -ResultSet :만일 실행한 SQL 문이 SELECT 문일 경우 조회된 결과들이
	 * 담겨있는 객체(select 문을 쓸 때만 씀) *JDBC 처리 순서 1) JDBC Driver 등록:해당 DBMS 가 제공하는 클래스 등록
	 * 2) Connection 객체 생성 : 접속하고자 하는 DB 정보를 기술해서 DB에 접속 3) Statement 객체 생성:
	 * Connection 객체를 이용해서 생성 4)SQL 문 전달하면서 실행 :Statement 객체에서 제공하는 메소드를 호출함으로써 실행
	 * >SElECT 문일 경우-executeQuery >나머지 DML 문일 경우-executeUpdate 메소드를 이용하여 실행 (INSERT<
	 * UPDATE< DELETE) 5) 결과 받기 : > SELECT 문일 경우 - ResultSet 객체로 받기 >나머지 DML 문일 경우-
	 * int(처리된 행의 갯수)로 받기
	 * 
	 * 6_1)ResultSet 에 담겨있는 데이터들을 하나씩 뽑아서 VO 객체에 담기 //한개의 행이 잘 변경됬다면.. 6_2) 트랜잭션
	 * 처리(성공이면 COMMIT, 실패면 ROLLBACK) 7)다 쓴 JDBC 용 객체들을 반드시 자원반납(close) => 생성된 순서의 역순
	 * 8) 결과반환(Controller 한테) > SELECT 문일 경우 - 6_1) 에서 만들어진 결과 리턴 -int(처리된 행의 갯수 ) 값
	 * 리턴 > 나머지 DML 문일 경우(INSERT, UPDATE< DELETE)
	 * 
	 * **Statement 특징: 완성된 SQL 문을 실행할 수 있는 객체
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	/**
	 * 
	 * 사용자가 회원 추가 요청 시 입력했던 값들을 가지고 INSERT 문을 실행하는 메소드
	 * 
	 * @param m : 사용자가 입력했던 아이디~ 취미까지이ㅡ 값들이 모두 담겨있는 Member 객체
	 * @return : Insert 문 실행후 처리된 행의 갯수(몇개의 행이 INSERT 되었는지)
	 */
	public int insertMember(Member m) {

		// INSERT 문 => 처리된 행이 갯수(int)=>테이블에 있는 내용물이 변경 => 트랜잭션 처리
		// 0 )필요한 변수들 먼저 셋팅 (선언 및 초기화)
		int result = 0; // 처리된 결과를 받을 수 있는 변수
		// 접속된 DB의 연결정보를 담을 수 있는 변수
		Connection conn = null;
		// SQL 문 실행 후 결과를 받기 위한 변수

		Statement stmt = null;
		// 실행할 SQL 문 (완성된 형태로 만들어 둘 것)
		// =>끝에 세미콜론이 있으면 안됨!!
		// INSERT INTO MEMBER
		// VALUES (SEQ_USERNO.NEXTVAL, 'xxx','xxx','xxx','x', xx,
		// 'xxxx','xxxxx','xxxxxxxxxxx','xxxx',
		// 1) JDBC 드라이버 등록

		String sql = "INSERT INTO MEMBER " + "VALUES(SEQ_USERNO.NEXTVAL," + "'" + m.getUserId() + "'," + "'"
				+ m.getUserPwd() + "'," + "'" + m.getUserName() + "'," + "'" + m.getGender() + "'," + m.getAge() + ","
				+ "'" + m.getEmail() + "'," + "'" + m.getPhone() + "'," + "'" + m.getAddress() + "'," + "'"
				+ m.getHobby() + "', DEFAULT)";

		// System.out.println(sql);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc6.jar 파일 내에 있는 oracle.jdbc.driver.OracleDriver 클래스를 등록
			// =>ojdbc6.jar 파일이 누락되었거나, 잘 추가되었지만 오타가 있는 경우
			// ClassNotFoundException 발생!!

			// 2) Connection 객체 생성(DB와 연결 -->url:DB 의 주소지,계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			// => 적어도 이 단계까지 완료가 되었다면 DB에 연결이 완료된 것
			// 3)Statement 객체 생성 Connection 객체로부터 생성
			stmt = conn.createStatement();
			// => 적어도 이 단계까지 완료가 되었다면 본격적으로 SQL 문을 실행시킬 수 있음

			// 4, 5 ) DB에 완성된 SQL 문을 전달하면서 실행 후 결과 받기 (처리된 행의 갯수) 받기
			result = stmt.executeUpdate(sql); // 매개변수로 실행할 쿼리문을 날리고 result 에는 처리된 행의 갯수가 들어있음.
			// 6_2 ) 트랜잭션 처리(Connection 객체가 제공하는 메소드)
			// => result 변수에 담긴 값 기준으로 조건 처리

			if (result > 0) { // 1개의 행이 insert => insert 가 아주 잘 되었음 =>commit

				conn.commit();

			} else {// 0개의 행 insert =>insert 에 실패했음
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 7 다 쓴 JDBC용 객체 자원 반납 => 반드시 작성해야 하는 코드이기 때문에 finally 블록 안에서 작성
			// =>생성된 순서의 역순으로 close
			// 생성순서 : Connection -> Statement
			// 닫는순서: Statement -> Connection
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		// 8) 결과 반환
		return result; // 처리된 행의 갯수(성공했을 경우 1, 실패했을 경우 0)

	}

	/**
	 * 사용자가 회원 전체 조회 요청 시 Select 문을 실행해주는 메소드
	 * 
	 * @return : 테이블로부터 조회된 전체 회원의 정보를 나타내는 ArrayList
	 */
	public ArrayList<Member> selectAll() {

		// ResultSet => 객체 = > 여러행조회(Member 1개당 회원 한명) : ArrayList 타입으로 묶기
		// 0) 필요한 변수들 먼저 셋팅(선언 및 초기화)

		ArrayList<Member> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM MEMBER";

		// 1) JDBC Driver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql); // rset 에는 조회된 결과물들이 다 담겨있을 것임.

			// resultset의 구조는 0번째 행에 대기타고 있다가 next.라는 메소드 호출할때마다 커서의 위치가 옮겨감.

			while (rset.next()) {// 커서를 한줄 아래로 움직여 주고 해당행이 존재할 경우 true/ 존재하지 않을경우 false반환
									// 적어도 이 중괄호 안에 들어와서 코드가 실행된다라는 거는 ResultSet 객체로부터 뽑아낼 데이터가 있다라는뜻

				// 현재 rset 의 커서가 가리키고 있는 해당 행의 데이터를 하나씩 뽑아서 Member 객체에 담기
				// 한 행의 데이터 ==회원 한명의 정보 ==Member VO 객체 한개

				Member m = new Member();
				// rest 으로부터 어떤 컬럼에 해당하는 값을 뽑을건지 제시
				// 각 컬럼에 들어있던 값들을 각 필들로 옮겨주기
				// reset.getInt()
				// rest.getString()
				// rest.getDate()

				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));

				list.add(m);
			}

			// 현재 조회결과가 담긴 resultset에서 한 행씩 뽑아서 vo객체에 담기
			// ==>
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2)Connection 객체 생성(url, 계정명, 비밀번호)
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list; // 회원들의 정보가 담겨있음
		// 만약 아무도 조회되지 않다면
	}

	/**
	 * @return 사용자의 아이디 검색 조회를 위한 SELECT문을 실행할 메소드 userId : 검색하고자하는 조건에 해당하는 아이디값
	 *         검색된 회원 한명의 정보
	 */
	public Member slectByUserId(String userId) {
		// SELECT 문= > ResultSet 객체 => 한행 조회(Member 하나로 결과받기)
		// 0 필요한 변수들먼저 셋팅

		Member m = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM MEMBER WHERE USERID = '" + userId + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			stmt = conn.createStatement();

			stmt.executeQuery(sql);
			rset = stmt.executeQuery(sql);

			// 6_1) 현재 조회결과가 담긴 ResultSet에서 한행씩 뽑아서 VO 객체에 담기
			// while(rest.next()) { 여러행 조회일 경우 더이상 뽑아낼 데이터가 없을 때 까지 돌리기
			// 한개의 행에 대해서 각 컬럼마다 값을 매번 뽑아서 VO객체의 필드로 가공
			// 조회된 한 행에 대한 데이터값들을 뽑아서 하나의 Member 객체에 담기 .ㅁ개변수 생성자로 만들기

			if (rset.next()) {
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPWD"),
						rset.getString("USERNAME"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
			}

			// 이 시점 기준으로 봤을 때
			// 만약 조회된 회원이 있다면 m 이라는 변수에 Member 타입의 객체가 담겨있음
			// 만약 조회된 회원이 없다면 m 이라는 변수에 null 값이 담겨있음
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				// 7) 다 쓴 JDBC용 객체 반납 (생성된 역순)
				// ResultSet -> Statement -> Connection
				rset.close();
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 8)
		return m;
	}

	public ArrayList<Member> sselectByUserName(String keyword) {

		ArrayList<Member> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%" + keyword + "%'";
		try {

			// 1) JDBC Driver 등록
			// 2) Connection 객체 생성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) { // 한 행에 담긴 데이터들을 한 Member 타입의 객체에 옮겨담기 -> 그 Member 를 list 에 담기
				Member m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPWD"),
						rset.getString("USERNAME"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
				list.add(new Member());

			}

			// 이 시점 기준으로 봤을 떄
			// 조회된 회원이 없다면 list.size() ==0 또는 list.isEmpty== true

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// 7) 다 쓴 JDBC 자원 반납(생성 순서의 역순)

			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
				conn.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list;

		// 조회 결과가 없다면 list.size() == 0 또는 list.isEmpty() ==true
	}

	/**
	 * 
	 * 회원 정보 수정을 위한 UPDATE 구문을 실행하는 메소드
	 * 
	 * @param m : 회원정보 수정을 위한 데이터
	 * @return : 테이블에 UPDATE 되는 행의 갯수 ==> 아이디는 중복되는 값이 아니니까 한개의 행만 리턴
	 */
	public int updateMember(Member m) {

		int result = 0; // 처리된 행의 갯수를 받을 수 있는 뱐수
		Connection conn = null;
		// Sql 문 (UPDATE) 실행 후 결과를 받을 수 있는 변수
		Statement stmt = null; // resultset 은 select문만

		// 실행할 SQL 문(완성된 형태, 세미콜론 X)

		/*
		 * UPDATE MEMBER SET USERPWD ='XXXX', EMAIL = 'XXXX', PHONE = 'XXXXXX', ADDRESS
		 * = 'XXXXXXXX' WHERE USERID= 'XXXX';
		 */

		String sql = "UPDATE MEMBER " // 스페이스 바 안넣으면 바로 SET이 붙음
				+ "SET USERPWD = '" + m.getUserPwd() + "'" + ",EMAIL = '" + m.getEmail() + "'" + ", PHONE = '"
				+ m.getPhone() + "'" + ", ADDRESS = '" + m.getAddress() + "' " + "WHERE USERID = '" + m.getUserId()
				+ "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1) jdbc 드라이버 등록
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			// 2)connection 객체 생성
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			if (result > 0) {
				conn.commit();

			} else {
				conn.rollback();
			}
			// 3 statement 객체 생성

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7)자원반납(생성순서 역순)
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deletMember(String userId) {
		int result= 0;
		Connection conn = null;
		Statement stmt = null;
		String sql = "DELETE "
					+ "FROM MEMBER " 
					+ "WHERE USERID='"+ userId +"'";
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");		
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
	stmt = conn.createStatement();	
    result = stmt.executeUpdate(sql);
    
    if(result>0) {
		conn.commit();
	}else {
		conn.rollback();
	}
}
	catch (SQLException e) {
	e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		
	}finally {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		return result;
	}
}
