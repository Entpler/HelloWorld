package studentController;

import java.util.ArrayList;

import student.vo.Student;

public class StudentController {

	Student student = new Student();

	ArrayList<Student> studentlist = new ArrayList<>();

	{
		studentlist.add(new Student(1, "ȫ�浿", 16, "�Ÿ���", 97));
		studentlist.add(new Student(2, "�̼���", 17, "�Ż絿", 56));
		// �ʱ�ȭ ���

	}

	// �л� ��ü ��ȸ
	public ArrayList<Student> selectAll() {
		return studentlist;

	}

	// �л� �Ѹ� ��ȸ
	public ArrayList<Student> selectOne(int classNumber) {
		ArrayList<Student> searched = new ArrayList<>();
		for (int i = 0; i < searched.size(); i++) {
			if (studentlist.get(i).getClassNumber() == classNumber) {
				searched.add(studentlist.get(i));
			}
		}
		return searched;
	}

	// �л� �Է�
	public int insertStudent(Student s) {
		int result = 0;
		ArrayList<Student> sinfo = new ArrayList<>();
		sinfo.add(s);
		result++;

		return result;

	}

	// �л� ���� ����
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

	// �л� ���� ����
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
