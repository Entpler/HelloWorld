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
			System.out.println(" ***학생관리프로그램*** ");
			System.out.println("1.학생전체조회");
			System.out.println("2.특정학생조회");
			System.out.println("3.학생추가");
			System.out.println("4.학생정보수정");
			System.out.println("5.학생정보삭제");

			System.out.println("=========================");
			System.out.print("메뉴입력:");
			
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
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	public void selectAll() {
		System.out.println("학생전체 조회");
		sc.selectAll();
		
			
	}
	public void selectOne() {
		System.out.print("조회할 학생 번호을 입력하세요:");
		int classNumber = in.nextInt();
		in.nextLine();
		ArrayList<Student>searched = sc.selectOne(classNumber);
		for(Student x : searched) {
			System.out.println(x);
		}
	}

	public void insertStudent() {
		
		System.out.print("학생번호 입력:");
		int classNumber = in.nextInt();
		in.nextLine();
		System.out.print("학생이름 입력:");
		String name = in.nextLine();
		System.out.print("학생이나이 입력:");
		int age = in.nextInt();
		in.nextLine();
		System.out.print("학생주소 입력:");
		String address = in.nextLine();
		System.out.println("학생점수 입력:");
		double grade = in.nextDouble();
		
		Student s = new Student(classNumber,name,age,address,grade);
		int result = sc.insertStudent(s);
		if(result>0) {
			System.out.println("학생이 추가되었습니다.");
		}else {
			System.out.println("학생이 추가되지 못했습니다.");
		}
	}

	public void updateStudent() {
		System.out.println("학생 정보 업데이트");
		System.out.print("기존학생명");
		String name = in.nextLine();
		System.out.println("성적 업데이트");
		//성적,나이,점수,주소, 업데이트
		//수정된 점수
		double upgrade = in.nextDouble();
		in.nextLine();
		//수정된 주소
		System.out.println("주소업데이트");
		String upaddress= in.nextLine();
		System.out.println("반 업데이트");
		int NewclassNumber = in.nextInt();
		in.nextLine();
		System.out.println("나이업데이트");
		int upage = in.nextInt();
		
		Student oldStudent = new Student();
		Student NewStudent = new Student(NewclassNumber,name,upage,upaddress,upgrade);
		
		int result = sc.updateStudent(oldStudent, NewStudent);
		if(result>0) {
			System.out.println("학생정보가 수정되었습니다.");
		}else {
			System.out.println("학생정보가 수정되지 않았습니다.");
		}
	
		
	}
	
	public void deleteStudent() {
		System.out.println("학생 삭제");
		System.out.print("삭제할 학생코드:");
		int classNumber = in.nextInt();
		in.nextLine();
		
		int result = sc.deleteStudent(classNumber);
		if(result>0) {
			System.out.println("학생코드가 삭제되었습니다.");
		}else {
			System.out.println("삭제할 학생코드가 없습니다.");
		}
	}
}
