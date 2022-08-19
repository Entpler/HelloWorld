package com.kh.chap01.practice.example;

import java.util.Scanner;

public class ConditionPractice {
	public void practice1() {
		Scanner in = new Scanner(System.in);

		System.out.println("1.�Է�");
		System.out.println("2.����");
		System.out.println("3.��ȸ");
		System.out.println("4.����");
		System.out.println("5.����");

		System.out.print("�޴� ��ȣ�� �Է��ϼ���: ");
		int menuNum = in.nextInt();

		switch (menuNum) {

		case 1:
			System.out.println("�Է¸޴��Դϴ�.");
			break;
		case 2:
			System.out.println("�����޴��Դϴ�.");
			break;
		case 3:
			System.out.println("��ȸ�޴��Դϴ�.");
			break;
		case 4:
			System.out.println("�����޴��Դϴ�.");
			break;
		case 9:
			System.out.println("���α׷��� ����˴ϴ�.");
			break;

		}

	}

	public void practice2() {

		Scanner in = new Scanner(System.in);
		System.out.print("���ڸ� �Ѱ� �Է��ϼ���:");

		int num = in.nextInt();
		if (num > 0 && num % 2 == 0) {
			System.out.println("¦����");
		} else if (num > 0 && num % 2 != 0) {
			System.out.println("Ȧ����");
		} else {
			System.out.println("����� �Է����ּ���.");
		}

	}

	public void practice5() {
		Scanner in = new Scanner(System.in);

		String Id = "sugalove";
		String pw = "1234";

		System.out.print("���̵� �Է��ϼ���:");
		String userId = in.nextLine();
		System.out.print("��й�ȣ�� �Է��ϼ���:");
		String userPw = in.nextLine();

		if (userId.equals(Id)) {
			if (userPw.equals(pw)) {
				System.out.println("�α��μ���");
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");

			}

		} else {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
		}
	}

	public void practice6() {

		Scanner in = new Scanner(System.in);
		System.out.print("����� �Է��ϼ���: ");
		String grade = in.nextLine();

		if (grade.equals("������") || grade.equals("ȸ��") || grade.equals("��ȸ��")) {
			switch (grade) {
			case "������":
				System.out.println("ȸ������,�Խñ۰���");
			case "ȸ��":
				System.out.println("�Խñ��ۼ�,����ۼ�");
			case "��ȸ��":
				System.out.println("�Խñ���ȸ");
				return;
			}
		} else {
			System.out.println("�߸� �Է��߽��ϴ�.");
		}

	}

	public void practice7() {
		Scanner in = new Scanner(System.in);

		System.out.print("Ű(cm)�� �Է����ּ���:");

		double height = in.nextDouble();

		System.out.print("������(kg)�� �Է����ּ���:");

		double gram = in.nextDouble();
		double BMI = gram / (height * 2);
		System.out.println("BIM ����:" + BMI);
		if (BMI < 18.5) {
			System.out.println("��ü��");
		} else if (BMI < 23) {
			System.out.println("����ü��");
		} else if (BMI < 25) {
			System.out.println("��ü��");
		} else if (BMI < 30) {
			System.out.println("��");
		} else {
			System.out.println("����");
		}

	}

	public void practice8() {

		Scanner in = new Scanner(System.in);
		System.out.print("����� �Է��ϼ��� : ");
		int a = in.nextInt();
		System.out.print("����� �Է��ϼ���: ");
		int b = in.nextInt();
		in.nextLine();
		System.out.print("�����ȣ�� �Է��ϼ���: ");
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
		System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
		}
	}
	
	public void practice9() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("�߰��������(20):");
		double middle = in.nextDouble();
		in.nextLine();
		
		System.out.print("�⸻�������(30):");
		double fin = in.nextDouble();
		in.nextLine();
		
		System.out.print("�������� (30) :");
		double project = in.nextDouble();
		in.nextLine();
		
		System.out.print("�⼮Ƚ�� (20) :");
		double num = in.nextDouble();
		in.nextLine();
		
		String pass = " ";
		
		double result = (middle*0.2) + (fin*0.3) + (project*0.3) + (num);
		
		if(result>=70 && num>=14) {
			pass = "PASS";
			System.out.println("======���=====");
			System.out.println("�߰�������� : " +middle * 0.2);
			System.out.println("�⸻�������: " +fin *0.3);
			System.out.println("��������: " + project *0.3);
			System.out.println("�⼮����:" + num);
			System.out.println("���� : " + result);
			System.out.println(pass);
		}else if(result<70 && num>=14){
			pass = "FAIL";
			System.out.println("======���=====");
			System.out.println(pass + "[�����̴�]"+"����("+result+")");
			
		}else if(result<70 && num<14) {
			pass = "FAIL";
			System.out.println("======���=====");
			System.out.println(pass + "[�⼮Ƚ������]"+"("+num+"/20)");
			System.out.println(pass + "[�����̴�]"+"����("+result+")");
		}else if(result>=70 &&num<14){
			pass = "FAIL";
			System.out.println(pass + "[�⼮Ƚ������]"+"("+num+"/20)");
		}
	}
}
