package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberView;

/*
 * * Controller 
 * View 를 통해서 요청한 기능을 처리하는 담당
 * 해당 메소드로 전달된 데이터를  VO 객체로 가공처리 한 후 Dao 메소드 호출 시 전달 
 * Dao 로 부터 반환받은 결과에 따라 사용자가 보게될 View (응답화면) 을 결정(View 의 메소드 호출)
 * 
 */
/**
 * @author User
 *
 */
public class MemberController {
//alt+shift+z
	/**
	 * @param userId~ hobby: 회원가입 요청 시 사용자가 입력한 값들
	 */
	public void insertMember(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {
		// 1.전달된 데이터들을 VO 객체로 주섬주섬 담기(=가공하겠다)
		// => 기본생성자로 생성 후 setter 메소드로 필드 채우기 / 매개변수 생성자로 생성하기
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);// userNo, 이랑
																									// enrolldate 없음.

		// 2.VO 객체 Dao 메소드로 넘겨주기(==메소드 호출)
		int result = new MemberDao().insertMember(m);
		// => 성공이면 1, 실패면 0

		// 3. 결과 받기

		// 4. 결과에 따른 응담화면 지정(==View 단의 메소드 호출)
		if (result > 0) {
			new MemberView().displaySuccess("회원이 추가되었습니다.");

		} else {
			// 실패했을 경우
			new MemberView().displayFail("회원이 추가되지 못했습니다.");
		}

	}

	public void selectAll() {
		ArrayList<Member> list = new MemberDao().selectAll();
		if (list.isEmpty()) {
			new MemberView().displayNodata("전체 조회된 데이터가 없습니다.");
		} else {
			new MemberView().displayList(list);

		}
	}

	public void selectByUserId(String userId) {
		// 1) 전달받은 값들을 VO로 가공하기
		// =>어자피 전달받은 값이 단 한개이기 때문에 이 경우에는 패스
		// 2전달값을 DAO 로 넘기면서 메소드 호출
		// 3. 결과값 받기
		// -=> DAo 메소드를 호출 할때 고려해야 할것 (매개변수 : userId 리턴갑싀 타입: Member)
		Member m = new MemberDao().slectByUserId(userId);
		if(m==null) {
			new MemberView().displayNodata(userId + "에 해당하는 검색결과가 없습니다.");
			
		}else {
			new MemberView().displayOne(m);
		}
	}

	public void selectByUserName(String keyword) {
		ArrayList<Member> list = new MemberDao().sselectByUserName(keyword);
		// 4.결과에 따른 응답 화면을 지정.
		if (list.isEmpty()) {
			new MemberView().displayNodata(keyword + "에 대한 검색 결과가 없습니다.");
		} else {
			new MemberView().displayList(list);

		}

	}

	/**
	 * 사용자의 회원 정보 변경 요청 시 처리해주는 메소드
	 * 
	 * @param userId     : 변경하고자 하는 회원의 아이디 (구분용)
	 * @param newPwd     : 변경할 정보들
	 * @param newEmail   : 변경할 정보들
	 * @param newPhone   :변경할 정보들
	 * @param newAddress :변경할 정보들
	 */
	public void updateMember(String userId, String newPwd, String newEmail, String newPhone, String newAddress) {

		// 1.요청시 전달 값들을 VO 객체로 가공하기
		// 2. 전달 값을 Dao 의 메소드로 넘기기
		// 3. 결과 받기
		// 4. 결과에 따른 응답화면을 지정

		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(newPwd);
		m.setEmail(newEmail);
		m.setAddress(newAddress);
		m.setPhone(newPhone);
		int result = new MemberDao().updateMember(m);
		
		
		if(result>0) {//수정 성공한 경우
			new MemberView().displaySuccess("회원정보번경성공");
			
		}else {
			new MemberView().displayFail("회원정보 변경 실패");
			
		}
		
		
		

	}

	public void deleteMember(String userId) {
		
		int result = new MemberDao().deletMember(userId);
		
		if(result>0) {
			new MemberView().SuccessDelete("회원정보삭제 성공");
			
		}else {
			new MemberView().SuccessDelete("회원정보삭제 실패");
		}
		
		
		
		
		
	}

}
