package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {

	
	public static void main(String[] args) {

		
		// Student ��ü ����
		/*
		 * Student[] student = new Student[3];
		 * 
		 * student[0] = new Student("ȫ�浿", 20, 178.2, 70.0, 1, "�����ý��۰��а�"); student[1] =
		 * new Student("�踻��", 21, 187.3, 80.0, 2, "�濵�а�"); student[2] = new
		 * Student("������", 23, 167.0, 45.0, 4, "������Ű��а�");
		 * 
		 * for (int i = 0; i < student.length; i++) {
		 * System.out.println(student[i].toString()); }
		 */

		// Employee ��ü ����
		
		int count = 0;
		
		Employee[] employee = new Employee[10];

		Scanner in = new Scanner(System.in);

		while (true) {

			String str = " ";
			
			System.out.print("����̸�:");
			String name = in.nextLine();

			System.out.print("�������:");

			int age = in.nextInt();
			in.nextLine();

			System.out.print("���Ű:");
			double height = in.nextDouble();
			in.nextLine();

			System.out.print("������:");
			double weight = in.nextDouble();
			in.nextLine();

			System.out.print("�޿�:");
			int salary = in.nextInt();
			in.nextLine();

			System.out.print("�μ�:");
			String dept = in.nextLine();

			employee[count] = new Employee(name, age, height, weight, salary, dept);

		

			System.out.print("��� �߰��Ͻðڽ��ϱ�?");
			str = in.nextLine();

			if (str.equals("n") || str.equals("N")) {

				break;

			} else if (str.equals("y") || str.equals("Y")) {

				count++;
			}
		}
		for (int i = 0; i <count; i++) {
			System.out.println(employee[i].toString());
		}

	}
}
