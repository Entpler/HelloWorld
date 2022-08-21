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
			System.out.println(" ***도서 관리 프로그램*** ");
			System.out.println("1.새 도서 추가");
			System.out.println("2.도서 삭제");
			System.out.println("3.도서 검색 출력");
			System.out.println("4.전체 도서검색");
			System.out.println("0.끝내기");

			System.out.println("=========================");
			System.out.print("메뉴입력:");

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
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 메뉴입니다.다시 입력하세요.");
			}
		}
	}

	public void insertBook() {
	
		System.out.print("도서명: ");
		String title = in.nextLine();
		
		System.out.println("카테고리 입력:\n1:인문/2:자연과학 \n3:의료/4:기타");
		int category = in.nextInt();
		in.nextLine();
		
		System.out.print("작가명:");
		String author = in.nextLine();
		
		Book book = new Book(title,category,author);
		
		int result = bm.insertBook(book);
		
		if(result > 0) { //추가성공
			System.out.println("추가 되었습니다(new)!");
		}else {
			System.out.println("실패 하였습니다!");
		}
	}
		

	public void deleteBook() {
		
		System.out.print("삭제할 도서 번호 입력하세요: ");
		int bNo = in.nextInt();
		int result = bm.deleteBook(bNo);
		
		if (result>0) {
			System.out.println("성공적으로 삭제");
		} else {
			System.out.println("삭제할 도서가 존재하지 않습니");
		}

	}

	public void searchBook() {
		
		System.out.print("검색할 도서명:");
		String title = in.nextLine();
		bookList = bm.searchBook(title);

		if (bookList.isEmpty()) {
			System.out.println("검색결과가 존재하지 않습니다.");
		} else {
			for(Book b : bookList) {
				System.out.println(b);
			}
		}

	}

	public void selectList() {
		
		System.out.println("전체 도서 조회");
		bookList = bm.selecList();
		
		if(bookList.isEmpty()) {
			System.out.println("도서목록이 존재하지 않습니다.");
		} else {
			for (Book b : bookList) {
				System.out.println(b);
			}

		}
	}
}
