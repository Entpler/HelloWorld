package student.view;

import java.util.ArrayList;
import java.util.Scanner;

import student.vo.Student;
import studentController.StudentController;

public class StudentView {
	Scanner in = new Scanner(System.in);
	StudentController sc = new StudentController();

	public void mainMenu() {
		while (true) {
			System.out.println(" ***�л��������α׷�*** ");
			System.out.println("1.�л���ü��ȸ");
			System.out.println("2.Ư���л���ȸ");
			System.out.println("3.�л��߰�");
			System.out.println("4.�л���������");
			System.out.println("5.�л���������");

			System.out.println("=========================");
			System.out.print("�޴��Է�:");
			
			int num = in.nextInt();
			switch (num) {
			case 1:
				selectAll();
				break;

			case 2:
				
				selectOne();
				break;

			case 3:
				insertStudent();
				break;

			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}
	}

	public void selectAll() {
		System.out.println("�л���ü ��ȸ");
		sc.selectAll();
		
			
	}
	public void selectOne() {
		System.out.print("��ȸ�� �л� ��ȣ�� �Է��ϼ���:");
		int classNumber = in.nextInt();
		in.nextLine();
		ArrayList<Student>searched = sc.selectOne(classNumber);
		for(Student x : searched) {
			System.out.println(x);
		}
	}

	public void insertStudent() {
		
		System.out.print("�л���ȣ �Է�:");
		int classNumber = in.nextInt();
		in.nextLine();
		System.out.print("�л��̸� �Է�:");
		String name = in.nextLine();
		System.out.print("�л��̳��� �Է�:");
		int age = in.nextInt();
		in.nextLine();
		System.out.print("�л��ּ� �Է�:");
		String address = in.nextLine();
		System.out.println("�л����� �Է�:");
		double grade = in.nextDouble();
		
		Student s = new Student(classNumber,name,age,address,grade);
		int result = sc.insertStudent(s);
		if(result>0) {
			System.out.println("�л��� �߰��Ǿ����ϴ�.");
		}else {
			System.out.println("�л��� �߰����� ���߽��ϴ�.");
		}
	}

	public void updateStudent() {
		System.out.println("�л� ���� ������Ʈ");
		System.out.print("�����л���");
		String name = in.nextLine();
		System.out.println("���� ������Ʈ");
		//����,����,����,�ּ�, ������Ʈ
		//������ ����
		double upgrade = in.nextDouble();
		in.nextLine();
		//������ �ּ�
		System.out.println("�ּҾ�����Ʈ");
		String upaddress= in.nextLine();
		System.out.println("�� ������Ʈ");
		int NewclassNumber = in.nextInt();
		in.nextLine();
		System.out.println("���̾�����Ʈ");
		int upage = in.nextInt();
		
		Student oldStudent = new Student();
		Student NewStudent = new Student(NewclassNumber,name,upage,upaddress,upgrade);
		
		int result = sc.updateStudent(oldStudent, NewStudent);
		if(result>0) {
			System.out.println("�л������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("�л������� �������� �ʾҽ��ϴ�.");
		}
	
		
	}
	
	public void deleteStudent() {
		System.out.println("�л� ����");
		System.out.print("������ �л��ڵ�:");
		int classNumber = in.nextInt();
		in.nextLine();
		
		int result = sc.deleteStudent(classNumber);
		if(result>0) {
			System.out.println("�л��ڵ尡 �����Ǿ����ϴ�.");
		}else {
			System.out.println("������ �л��ڵ尡 �����ϴ�.");
		}
	}
}
