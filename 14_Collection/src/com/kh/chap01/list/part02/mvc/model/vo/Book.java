package com.kh.chap01.list.part02.mvc.model.vo;
public class Book {

	private int bNo;
	private String title;
	private int category;
	private String author;

	public Book() {

	}

	public Book(String title, int category, String author) {
		this.title = title;
		this.category = category;
		this.author = author;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {

		String cate = null; // 변수활용

		switch (category) {
		case 1:
			cate = "1.인문";
			break;
		case 2:
			cate = "2.사회";
			break;
		case 3:
			cate = "3.의료";
			break;
		case 4:
			cate = "4.기타";
			break;
	}

	return "도서번호 : " + bNo + ", 도서명 : " + title + " , category : " + cate + ", 작가 : " + author;

	}
}
