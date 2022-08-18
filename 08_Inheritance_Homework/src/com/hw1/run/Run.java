package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {

	
	public static void main(String[] args) {

		
		// Student 객체 생성
		/*
		 * Student[] student = new Student[3];
		 * 
		 * student[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과"); student[1] =
		 * new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과"); student[2] = new
		 * Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
		 * 
		 * for (int i = 0; i < student.length; i++) {
		 * System.out.println(student[i].toString()); }
		 */

		// Employee 객체 생성
		
		int count = 0;
		
		Employee[] employee = new Employee[10];

		Scanner in = new Scanner(System.in);

		while (true) {

			String str = " ";
			
			System.out.print("사원이름:");
			String name = in.nextLine();

			System.out.print("사원나이:");

			int age = in.nextInt();
			in.nextLine();

			System.out.print("사원키:");
			double height = in.nextDouble();
			in.nextLine();

			System.out.print("몸무게:");
			double weight = in.nextDouble();
			in.nextLine();

			System.out.print("급여:");
			int salary = in.nextInt();
			in.nextLine();

			System.out.print("부서:");
			String dept = in.nextLine();

			employee[count] = new Employee(name, age, height, weight, salary, dept);

		

			System.out.print("계속 추가하시겠습니까?");
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
