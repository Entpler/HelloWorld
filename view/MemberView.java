package com.kh.view;
/*
 * 
 * 
 * View 
 * 사용자가 보게 될 시각적인 요소, 화면
 * -CLI : Command Line Interface(단순히 키모드만으로 컴퓨터와 소통할 수 있는 환경)(Scanner)
 * -GUI : Graphic User Interface (마우스, 키보드를 모두 이용해서 컴퓨터와 소통할 수 있는 환경)
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

/**
 * @author User
 *
 */
/**
 * @author User
 *
 */
/**
 * @author User
 *
 */
public class MemberView {

	// 전역으로 다 쓸 수 있게끔 Scanner 객체 생성
	private Scanner in = new Scanner(System.in);

	private MemberController mc = new MemberController();

	/**
	 * 사용자가 보게 될 첫 화면(메인화면)
	 */

	/**
	 * 
	 */
	public void mainMenu() {
		while (true) {
			System.out.println("*****회원 관리 프로그램*****");
			System.out.println("1.회원추가");
			System.out.println("2.회원 전체 조회");
			System.out.println("3.회원 아이디로 검색");
			System.out.println("4.회원 이름 키워드 검색");
			System.out.println("5.회원 정보 변경");
			System.out.println("6.회원 탈퇴");
			System.out.println("0.프로그램 종료");

			System.out.println("------------------------");
			System.out.print(">>이용할 메뉴 선택:");

			int menu = in.nextInt();
			in.nextLine();

			switch (menu) {

			case 1:
				insertmember();
				break;
			case 2: selectAll();
				break;
			case 3: selectByUserId();
				break;
			case 4:selectByUserName();
				break;
			case 5: updateMember();//회원정보 변경용 화면을 담당하는 메소드
				break;
			case 6: deleteMember(); 
				break;
			case 0:
				break;
			default: System.out.println("잘못된 번호입니다.다시 선택해 주세요. ");
				return;

			}
		}

	}
/**
 *탈퇴하고자 하는 회원의 아이디를 입력받아 삭제를 해주는 화면
 */
	private void deleteMember() {
		System.out.println("----회원탈퇴----");
		System.out.print("변경할 회원의 아이디:");
		String userId = in.nextLine();
		mc.deleteMember(userId);
		
	}
	
	
	
	
	
	
	

	/**
	 * 사용자에게 변경할 회원의 아이디, 변경할 정보(비밀번호,이메일,전화번호,주소) 들을 입력받은 후 
	 * 변경을 요청하는 화면
	 */
      private void updateMember() {
		System.out.println("----회원정보 변경----");
		//어느 데이터를 어떻게 변경할 건지 언급!!
		//어느 회원의 =>unique 제약조건이 걸린 회원의 아이디로 구분 
		//어떻게 변경할건지 => 비밀번호, 이메일, 전화번호, 주소
		System.out.print("변경할 회원의 아이디:");
		String userId = in.nextLine();
		
		//변경할 내용들 
		System.out.print("변경할 비밀번호: ");
		String newPwd = in.nextLine();
		System.out.print("변경할 이메일:");
		String newEmail = in.nextLine();
		
		System.out.print("변경할 전화번호(숫자만: ");
		String newPhone = in.nextLine();
		System.out.print("변경할 주소:");
		String newAddress= in.nextLine();
		//MemberController 의 어떤 메소드를 호출해서 회원 정보 수정 요청
		
		mc.updateMember(userId, newPwd,newEmail, newPhone, newAddress);
			}


	/**
       * 사용자 이름을 입력 받은 후 조회를 요청받는 화면
       * 
       */
	private void selectByUserName() {
		System.out.println("회원이름으로 검색");
		System.out.print("검색할 회원의 이름:");
		String keyword = in.nextLine();
		mc.selectByUserName(keyword);
		
	}



	/**사용자에게 검색할 회원의 아이디를 입력 받은 후 조회를 요청하는 화면
	 * 
	 */
	private void selectByUserId() {
		System.out.println("====회원아이디로 검색=====");
		//사용자로부터 검색하고자 하는 회원의 아이디를 입력받아야함.
		System.out.print("검색할 회원의 아이디:");
		String userId = in.nextLine();
		mc.selectByUserId(userId);
		
	}

	/**
	 * 회원 추가용 화면 추가하고자 하는 회원의 정보를 입력받아서 추가 요청을 할 수 있는 화면
	 * 
	 */
	private void insertmember() {
		System.out.println("---회원추가---");
		//회원추가->Member 테이블에 Insert 하겠다.
		//회원추가시 필요한 데이터들
		//아이디, 비밀번호,이름, 성별, 나이, 이메일, 휴대폰, 주소, 취미(9개) 
		System.out.print("아이디:");
		String userId = in.nextLine();
		
		
		System.out.print("비밀번호:");
		String userPwd = in.nextLine();
		
		System.out.print("이름:");
		String userName = in.nextLine();
		
		System.out.print("성별(M/F):");
		String gender = in.nextLine();
		
		System.out.print("나이:");
		int age= in.nextInt();
		in.nextLine();
		
		System.out.print("이메일:");
		String email = in.nextLine();
		
		System.out.print("전화번호:");
		String phone = in.nextLine();
		
		System.out.print("주소:");
		String address = in.nextLine();
		
		System.out.print("취미(,로 공백없이 나열):");
		String hobby = in.nextLine();
		
		System.out.println();
		
		mc.insertMember(userId,userPwd,userName,gender,age,email,phone,address,hobby);

	}
//--------------------------------------------------------
//------------서비스 요청 처리 후 사용자가 볼 응답화면에 대한 메소드들	
	public void displaySuccess(String message) {
		System.out.println("서비스 요청 성공: " + message);
		
	}

	/**서비스 요청 실패시 보게 될 화면		
	 * @param message :실패메시지
	 */
	public void displayFail(String message) {
		System.out.println("서비스 요청 실패 : " + message);
		
	}
	
	
	
	/**
	 * 
	 */
		private void selectAll() {
		System.out.println("-----회원 전체 조회--------");
		//회원 전체 조회 요청 => MemberController 클래스의 어느 메소드
		mc.selectAll();
	}



	/**
	 * 조회 서비스 요청시 조회결과 가 없을 때 보게될 화면
	 * 결과없음을 나타내는 메세지	 */
	public void displayNodata(String message) {
		System.out.println(message);
		
		
	}
	
	/**조회 서비스 요청 시 여러 행이 조회된 결과를 받아서 보게 될 화면
	 * @param list :여러 행이 조회된 결과면
	 */
	public void displayList(ArrayList<Member>list) {
		System.out.println("조회된 데이터는 다음과 같습니다.");
		for(int i =0 ; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	public void SuccessDelete(String message) {
	   System.out.println(message);
		
	}
	public void displayOne(Member m) {
	System.out.println("조회된 데이터는 다음과 같습니다.");
	System.out.println(m);
		
	}
}

// 필드부

// 생성자부
