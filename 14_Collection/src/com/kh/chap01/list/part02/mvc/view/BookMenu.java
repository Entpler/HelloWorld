package com.kh.chap01.list.part02.mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01.list.part02.mvc.comtroller.BookManager;
import com.kh.chap01.list.part02.mvc.model.vo.Book;

public class BookMenu {

	Scanner in = new Scanner(System.in);
	private BookManager bm = new BookManager();

	
	Book book = new Book();
	ArrayList<Book> bookList = new ArrayList<Book>();

	
	public void mainMenu() {
		
		while (true) {
			System.out.println(" ***���� ���� ���α׷�*** ");
			System.out.println("1.�� ���� �߰�");
			System.out.println("2.���� ����");
			System.out.println("3.���� �˻� ���");
			System.out.println("4.��ü �����˻�");
			System.out.println("0.������");

			System.out.println("=========================");
			System.out.print("�޴��Է�:");

			int num = in.nextInt();
			in.nextLine();
			switch (num) {
			case 1:
				insertBook();
				break;
			case 2:
				deleteBook();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				selectList();
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸��� �޴��Դϴ�.�ٽ� �Է��ϼ���.");
			}
		}
	}

	public void insertBook() {
	
		System.out.print("������: ");
		String title = in.nextLine();
		
		System.out.println("ī�װ� �Է�:\n1:�ι�/2:�ڿ����� \n3:�Ƿ�/4:��Ÿ");
		int category = in.nextInt();
		in.nextLine();
		
		System.out.print("�۰���:");
		String author = in.nextLine();
		
		Book book = new Book(title,category,author);
		
		int result = bm.insertBook(book);
		
		if(result > 0) { //�߰�����
			System.out.println("�߰� �Ǿ����ϴ�(new)!");
		}else {
			System.out.println("���� �Ͽ����ϴ�!");
		}
	}
		

	public void deleteBook() {
		
		System.out.print("������ ���� ��ȣ �Է��ϼ���: ");
		int bNo = in.nextInt();
		int result = bm.deleteBook(bNo);
		
		if (result>0) {
			System.out.println("���������� ����");
		} else {
			System.out.println("������ ������ �������� �ʽ���");
		}

	}

	public void searchBook() {
		
		System.out.print("�˻��� ������:");
		String title = in.nextLine();
		bookList = bm.searchBook(title);

		if (bookList.isEmpty()) {
			System.out.println("�˻������ �������� �ʽ��ϴ�.");
		} else {
			for(Book b : bookList) {
				System.out.println(b);
			}
		}

	}

	public void selectList() {
		
		System.out.println("��ü ���� ��ȸ");
		bookList = bm.selecList();
		
		if(bookList.isEmpty()) {
			System.out.println("��������� �������� �ʽ��ϴ�.");
		} else {
			for (Book b : bookList) {
				System.out.println(b);
			}

		}
	}
}
