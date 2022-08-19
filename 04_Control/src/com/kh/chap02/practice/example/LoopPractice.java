package com.kh.chap02.practice.example;

import java.util.Scanner;

public class LoopPractice {

	public void practice11() {

		Scanner in = new Scanner(System.in);
		System.out.print("숫자를 입력하세요:");
		int start = in.nextInt();
		in.nextLine();

		System.out.print("공차를 입력하세요:");
		int g = in.nextInt();
		in.nextLine();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.println(start + " ");
				start += g;
			}

		}

	}

	public void practice2() {

		Scanner in = new Scanner(System.in);

		int sum = 0;

		while (true) {
			int num = in.nextInt();
			if (num >= 1) {
				for (int i = 1; i <= num; i++) {
					sum += i;
				}
				System.out.println(sum);
				return;
			} else {

			}
			System.out.println("잘못 입력하셨습니다.다시 입력해주세요");
		}
	}

	public void practice3() {
		Scanner in = new Scanner(System.in);

		while (true) {
			int N = in.nextInt();
			if (N >= 1) {
				for (int i = N; i >= 1; i--) {
					System.out.print(i + " ");
				}
				return;
			} else {
			}
			System.out.println("잘못 입력하셨습니다.다시 입력해주세요.");
		}
	}

	public void practice5() {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += i;
			System.out.print(i + " " + "+ ");
		}
		System.out.print("=" + sum);
	}

	public void practice6() {

		Scanner in = new Scanner(System.in);

		while (true) {
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			if (num1 >= 1 && num2 >= 1) {
				if (num2 > num1) {
					for (int i = num1; i <= num2; i++) {
						System.out.print(i + " ");
					}
				} else if (num2 < num1) {
					for (int i = num2; i <= num1; i++) {
						System.out.print(i + " ");
					}
				}
				return;
			} else {

			}
			System.out.println("1이상의 숫자만을 입력해주세요.");
		}
	}

	public void practice10() {

		Scanner in = new Scanner(System.in);

		while (true) {
			int N = in.nextInt();
			if (N >= 2 && N <= 9) {
				for (int i = 2; i <= N; i++) {
					System.out.println("====" + i + "단====");
					for (int j = 1; j <= 9; j++) {
						System.out.println(j + "x" + i + "=" + i * j);
					}
				}
				return;
			} else {
				System.out.println("2~9사이의 숫자를 입력해 주세요.");
			}
		}
	}

	public void practice12() {

		Scanner in = new Scanner(System.in);

		while (true) {

			String operator = in.nextLine();

			if (operator.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
				
			} else {
				int num1 = in.nextInt();
				in.nextLine();
				int num2 = in.nextInt();
				in.nextLine();
				
				if (operator.equals("/") && num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해 주세요.");
				} else {
					switch (operator) {
					case "+":
						System.out.println(num1 + num2);
						break;
					case "-":
						System.out.println(num1 - num2);
						break;
					case "*":
						System.out.println(num1 * num2);
						break;
					case "/":
						System.out.println(num1 / num2);
						break;
					case "%":
						System.out.println(num1 % num2);
						break;
					default:
						System.out.println("없는 연산자입니다. 다시 입력해주세요.");
					}
				}

			}
		}
	}
}
