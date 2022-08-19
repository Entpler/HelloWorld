package com.kh.chap01.practice.example;

import java.util.Scanner;

public class ConditionPractice {
	public void practice1() {
		Scanner in = new Scanner(System.in);

		System.out.println("1.입력");
		System.out.println("2.수정");
		System.out.println("3.조회");
		System.out.println("4.삭제");
		System.out.println("5.종료");

		System.out.print("메뉴 번호를 입력하세요: ");
		int menuNum = in.nextInt();

		switch (menuNum) {

		case 1:
			System.out.println("입력메뉴입니다.");
			break;
		case 2:
			System.out.println("수정메뉴입니다.");
			break;
		case 3:
			System.out.println("조회메뉴입니다.");
			break;
		case 4:
			System.out.println("삭제메뉴입니다.");
			break;
		case 9:
			System.out.println("프로그램이 종료됩니다.");
			break;

		}

	}

	public void practice2() {

		Scanner in = new Scanner(System.in);
		System.out.print("숫자를 한개 입력하세요:");

		int num = in.nextInt();
		if (num > 0 && num % 2 == 0) {
			System.out.println("짝수다");
		} else if (num > 0 && num % 2 != 0) {
			System.out.println("홀수다");
		} else {
			System.out.println("양수만 입력해주세요.");
		}

	}

	public void practice5() {
		Scanner in = new Scanner(System.in);

		String Id = "sugalove";
		String pw = "1234";

		System.out.print("아이디를 입력하세요:");
		String userId = in.nextLine();
		System.out.print("비밀번호를 입력하세요:");
		String userPw = in.nextLine();

		if (userId.equals(Id)) {
			if (userPw.equals(pw)) {
				System.out.println("로그인성공");
			} else {
				System.out.println("비밀번호가 틀렸습니다.");

			}

		} else {
			System.out.println("아이디가 틀렸습니다.");
		}
	}

	public void practice6() {

		Scanner in = new Scanner(System.in);
		System.out.print("등급을 입력하세요: ");
		String grade = in.nextLine();

		if (grade.equals("관리자") || grade.equals("회원") || grade.equals("비회원")) {
			switch (grade) {
			case "관리자":
				System.out.println("회원관리,게시글관리");
			case "회원":
				System.out.println("게시글작성,댓글작성");
			case "비회원":
				System.out.println("게시글조회");
				return;
			}
		} else {
			System.out.println("잘못 입력했습니다.");
		}

	}

	public void practice7() {
		Scanner in = new Scanner(System.in);

		System.out.print("키(cm)를 입력해주세요:");

		double height = in.nextDouble();

		System.out.print("몸무게(kg)을 입력해주세요:");

		double gram = in.nextDouble();
		double BMI = gram / (height * 2);
		System.out.println("BIM 지수:" + BMI);
		if (BMI < 18.5) {
			System.out.println("저체중");
		} else if (BMI < 23) {
			System.out.println("정상체중");
		} else if (BMI < 25) {
			System.out.println("과체중");
		} else if (BMI < 30) {
			System.out.println("비만");
		} else {
			System.out.println("고도비만");
		}

	}

	public void practice8() {

		Scanner in = new Scanner(System.in);
		System.out.print("양수를 입력하세요 : ");
		int a = in.nextInt();
		System.out.print("양수를 입력하세요: ");
		int b = in.nextInt();
		in.nextLine();
		System.out.print("연산기호를 입력하세요: ");
		String op = in.nextLine();

		if(a > 0 && b > 0) {
			switch (op) {
			case "+":
				System.out.println(a + b);
				break;
			case "-":
				System.out.println(a - b);
				break;
			case "*":
				System.out.println(a * b);
				break;
			case "/":
				System.out.println(a / b);
				break;
			case "%":
				System.out.println(a % b);
				break;
			}
		System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		} else {
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}
	}
	
	public void practice9() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("중간고사점수(20):");
		double middle = in.nextDouble();
		in.nextLine();
		
		System.out.print("기말고사점수(30):");
		double fin = in.nextDouble();
		in.nextLine();
		
		System.out.print("과제점수 (30) :");
		double project = in.nextDouble();
		in.nextLine();
		
		System.out.print("출석횟수 (20) :");
		double num = in.nextDouble();
		in.nextLine();
		
		String pass = " ";
		
		double result = (middle*0.2) + (fin*0.3) + (project*0.3) + (num);
		
		if(result>=70 && num>=14) {
			pass = "PASS";
			System.out.println("======결과=====");
			System.out.println("중간고사점수 : " +middle * 0.2);
			System.out.println("기말고사점수: " +fin *0.3);
			System.out.println("과제점수: " + project *0.3);
			System.out.println("출석점수:" + num);
			System.out.println("총점 : " + result);
			System.out.println(pass);
		}else if(result<70 && num>=14){
			pass = "FAIL";
			System.out.println("======결과=====");
			System.out.println(pass + "[점수미달]"+"총점("+result+")");
			
		}else if(result<70 && num<14) {
			pass = "FAIL";
			System.out.println("======결과=====");
			System.out.println(pass + "[출석횟수부족]"+"("+num+"/20)");
			System.out.println(pass + "[점수미달]"+"총점("+result+")");
		}else if(result>=70 &&num<14){
			pass = "FAIL";
			System.out.println(pass + "[출석횟수부족]"+"("+num+"/20)");
		}
	}
}
