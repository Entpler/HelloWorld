package com.hw6.controller;

import java.util.Scanner;

public class NumberOk {

	public void numberGame() {
		Scanner in = new Scanner(System.in);
		int count = 0;
		while (true) {
			System.out.println("1부터 100사이의 정수를 하나 입력하세요");

			int num = in.nextInt();

			int random = (int) (Math.random() * 100) + 1;
			count++;
			if ((1 <= num) && (num <= 100)) {

				if (num > random) {
					System.out.println(String.valueOf(random) + "보다 큽니다" + count + "번째실패!");

				} else if (num < random) {
					System.out.println(String.valueOf(random) + "보다 작습니다" + count + "번째실패!");

				} else {
					System.out.println(count + "번만에 맞췄습니다!");

					while (true) {
						System.out.println("계속 하시겠습니까? y/n");
						String answer = in.nextLine();
						answer = answer.toLowerCase();

						if (answer.equals("y")) {

							System.out.println("새로운 게임을 시작합니다!");
							break;
						} else if (answer.equals("n")) {
							System.out.println("게임을 종료합니다.");
							return;
						} else {
							System.out.println("잘못 입력하셨습니다.");
						}
					}
				}
			} else {
				System.out.println("1부터 100까지의 정수를 입력하세요");
			}
		}
	}
}
