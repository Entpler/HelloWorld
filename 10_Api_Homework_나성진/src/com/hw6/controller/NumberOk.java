package com.hw6.controller;

import java.util.Scanner;

public class NumberOk {

	public void numberGame() {
		Scanner in = new Scanner(System.in);
		int count = 0;
		while (true) {
			System.out.println("1���� 100������ ������ �ϳ� �Է��ϼ���");

			int num = in.nextInt();

			int random = (int) (Math.random() * 100) + 1;
			count++;
			if ((1 <= num) && (num <= 100)) {

				if (num > random) {
					System.out.println(String.valueOf(random) + "���� Ů�ϴ�" + count + "��°����!");

				} else if (num < random) {
					System.out.println(String.valueOf(random) + "���� �۽��ϴ�" + count + "��°����!");

				} else {
					System.out.println(count + "������ ������ϴ�!");

					while (true) {
						System.out.println("��� �Ͻðڽ��ϱ�? y/n");
						String answer = in.nextLine();
						answer = answer.toLowerCase();

						if (answer.equals("y")) {

							System.out.println("���ο� ������ �����մϴ�!");
							break;
						} else if (answer.equals("n")) {
							System.out.println("������ �����մϴ�.");
							return;
						} else {
							System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						}
					}
				}
			} else {
				System.out.println("1���� 100������ ������ �Է��ϼ���");
			}
		}
	}
}
