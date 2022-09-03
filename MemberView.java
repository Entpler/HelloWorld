package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.model.vo.Member;

public class MemberView {

	Scanner in = new Scanner(System.in);

	MemberController mc = new MemberController();
	ArrayList<Member> memberlist = new ArrayList<>();

	Member member = new Member();

	public void mainMenu() {

		while (true) {
			System.out.print("아이디를 입력하세요:");
			String id = in.nextLine();
			System.out.print("비밀먼호를 입력하세요:");
			String pwd = in.nextLine();

			if (id.equals(member.getUserId()) && pwd.equals(member.getUserPwd())) {
				System.out.println("로그인에 성공하였습니다.");

				while (true) {
					System.out.println("1.회원추가");
					System.out.println("2.회원 전체 조회");
					System.out.println("3.회원 이름 키워드 검색");
					System.out.println("4.회원 비밀번호 초기화");
					System.out.println("5.회원삭제");
					System.out.println("0.프로그램로그아웃");
					System.out.print("메뉴넘버를 입력하세요:");

					int num = in.nextInt();
					in.nextLine();
					switch (num) {

					case 1:
						insertMember();

					case 2:
						selectMemberList();

					case 3:
						searchMemberById();

					case 4:
						searchMemberByName();

					case 5:
						initMemberPwd();

					case 6:
						deleteMember();
					}

				}
			} else
				System.out.println("로그인에 실패하였습니다.");

		}

	}

	public void deleteMember() {

	}

	public void initMemberPwd() {

	}

	public void searchMemberByName() {

	}

	public void searchMemberById() {

	}

	public void selectMemberList() {
		memberlist = mc.selectlist();
		if (memberlist.isEmpty()) {
			System.out.println("회원이 존재하지 않습니다.");
		} else {
			for (Member m : memberlist) {
				System.out.println(m);
			}
		}

	}

	public void insertMember() {

		System.out.print("회원아이디:");
		String userId = in.nextLine();
		System.out.print("회원비밀번호:");
		String userPwd = in.nextLine();
		System.out.print("회원이름:");
		String userName = in.nextLine();
		System.out.print("나이:");
		int age = in.nextInt();
		in.nextLine();
		System.out.print("성별(여/남):");
		char gender = in.nextLine().charAt(0);
		System.out.print("회원이메일:");
		String email = in.nextLine();
		System.out.print("회원전화번호:");
		String phone = in.nextLine();

		Member member = new Member(userId, userPwd, userName, age, gender, email, phone);
		int result = mc.insertMember(member);
		if (result > 0) {
			System.out.println("회원이 추가되었습니다.");
		}

	}

}
