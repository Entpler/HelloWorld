package com.hw6.controller;

import java.util.Scanner;

public class filter {

	public void method1() {
		Scanner in = new Scanner(System.in);
		System.out.print("�Է�:");
		String str = in.nextLine();

		// ���͸��� �迭
		String[] filter = { "�Ź߲�", "������", "���ھ�", "ȣ����", "�ú�����", "�����", "��ī", "�ֿ�", "�ֹֽ�", "���ڼ�", "�Ļ�" };

		// ���͸� �۾�

		for (int i = 0; i < filter.length; i++) {
			// �� �ε����� ���� ���͸��� ���ڿ� �������� *�� ġȯ�� ���ڿ��� ���� ����
			String star = "" + filter[i].charAt(0);
			int size = filter[i].length(); //�ش� ������ ���ڼ��� ����
			for (int j = 0; j < size -1 ; j++) {
				star += "*";
			}

			str = str.replace(filter[i], star);
		}
		System.out.println(str);

	}
}
