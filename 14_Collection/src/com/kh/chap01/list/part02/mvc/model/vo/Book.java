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

		String cate = null; // ����Ȱ��

		switch (category) {
		case 1:
			cate = "1.�ι�";
			break;
		case 2:
			cate = "2.��ȸ";
			break;
		case 3:
			cate = "3.�Ƿ�";
			break;
		case 4:
			cate = "4.��Ÿ";
			break;
	}

	return "������ȣ : " + bNo + ", ������ : " + title + " , category : " + cate + ", �۰� : " + author;

	}
}
