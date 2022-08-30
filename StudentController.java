package studentController;

import java.util.ArrayList;

import student.vo.Student;

public class StudentController {

	Student student = new Student();

	ArrayList<Student> studentlist = new ArrayList<>();

	{
		studentlist.add(new Student(1, "홍길동", 16, "신림동", 97));
		studentlist.add(new Student(2, "이순신", 17, "신사동", 56));
		// 초기화 블록

	}

	// 학생 전체 조회
	public ArrayList<Student> selectAll() {
		return studentlist;

	}

	// 학생 한명 조회
	public ArrayList<Student> selectOne(int classNumber) {
		ArrayList<Student> searched = new ArrayList<>();
		for (int i = 0; i < searched.size(); i++) {
			if (studentlist.get(i).getClassNumber() == classNumber) {
				searched.add(studentlist.get(i));
			}
		}
		return searched;
	}

	// 학생 입력
	public int insertStudent(Student s) {
		int result = 0;
		ArrayList<Student> sinfo = new ArrayList<>();
		sinfo.add(s);
		result++;

		return result;

	}

	// 학생 정보 변경
	public int updateStudent(Student oldStudent, Student NewStudent) {
	
		
		int result = 0;
		ArrayList<Student> studentlist = new ArrayList<>();
		for (int i = 0; i <studentlist.size(); i++) {
			if (studentlist.get(i).getName().equals(oldStudent.getName())){
				studentlist.set(i,new Student());
				result++;
			}

		}
		return result;

	}

	// 학생 정보 삭제
	public int deleteStudent(int classNumber) {
		
		int result = 0;
		for(int i =0 ; i<studentlist.size(); i++) {
			if(studentlist.get(i).getClassNumber()==classNumber) {
				studentlist.remove(i);
				result++;
			}
		}
		return result;
		

	}

}
