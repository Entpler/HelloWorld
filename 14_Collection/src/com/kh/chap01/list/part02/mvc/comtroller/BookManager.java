package com.kh.chap01.list.part02.mvc.comtroller;

import java.util.ArrayList;

import com.kh.chap01.list.part02.mvc.model.vo.Book;

public class BookManager {

	ArrayList<Book> bookList = new ArrayList<Book>();
	ArrayList<Book> searchList = new ArrayList<Book>();

	// �⺻������
	public BookManager() {

	}

	public int insertBook(Book book) {
		int result = 0;
		int lastNo = 0;
		// ���޹��� ���� ��ȣ 0��ä�� �����µ�
		// ���ο� ������ �߰��� ������ �߰��Ǵ� ������ ������ȣ�� ������ ������ ������ȣ�� �ο��Ǿ����.
		try {
			lastNo = bookList.get(bookList.size()-1).getbNo() + 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			lastNo = 1;
		}finally {
			result++;
		}
		book.setbNo(lastNo);
		bookList.add(book);
		
		return result;

	}

	public int deleteBook(int bNo) {

		int result = 0; // ���� �����������
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getbNo() == bNo) {
				bookList.remove(i--);
				result++;
			}

		}
		return result;

	}

	public ArrayList<Book> searchBook(String title) {
		
		for (int i = 0; i < bookList.size(); i++) {
			
			if (bookList.get(i).getTitle().contains(title)) {
				searchList.add(bookList.get(i));

			}

		}
		return searchList;
	}

	public ArrayList<Book> selecList() {
		return bookList;

	}

}
