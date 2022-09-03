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
			System.out.print("���̵� �Է��ϼ���:");
			String id = in.nextLine();
			System.out.print("��и�ȣ�� �Է��ϼ���:");
			String pwd = in.nextLine();

			if (id.equals(member.getUserId()) && pwd.equals(member.getUserPwd())) {
				System.out.println("�α��ο� �����Ͽ����ϴ�.");

				while (true) {
					System.out.println("1.ȸ���߰�");
					System.out.println("2.ȸ�� ��ü ��ȸ");
					System.out.println("3.ȸ�� �̸� Ű���� �˻�");
					System.out.println("4.ȸ�� ��й�ȣ �ʱ�ȭ");
					System.out.println("5.ȸ������");
					System.out.println("0.���α׷��α׾ƿ�");
					System.out.print("�޴��ѹ��� �Է��ϼ���:");

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
				System.out.println("�α��ο� �����Ͽ����ϴ�.");

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
			System.out.println("ȸ���� �������� �ʽ��ϴ�.");
		} else {
			for (Member m : memberlist) {
				System.out.println(m);
			}
		}

	}

	public void insertMember() {

		System.out.print("ȸ�����̵�:");
		String userId = in.nextLine();
		System.out.print("ȸ����й�ȣ:");
		String userPwd = in.nextLine();
		System.out.print("ȸ���̸�:");
		String userName = in.nextLine();
		System.out.print("����:");
		int age = in.nextInt();
		in.nextLine();
		System.out.print("����(��/��):");
		char gender = in.nextLine().charAt(0);
		System.out.print("ȸ���̸���:");
		String email = in.nextLine();
		System.out.print("ȸ����ȭ��ȣ:");
		String phone = in.nextLine();

		Member member = new Member(userId, userPwd, userName, age, gender, email, phone);
		int result = mc.insertMember(member);
		if (result > 0) {
			System.out.println("ȸ���� �߰��Ǿ����ϴ�.");
		}

	}

}
