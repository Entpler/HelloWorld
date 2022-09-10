package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BoardController;
import model.vo.Board;

public class BoardView {

	Scanner in = new Scanner(System.in);
	BoardController bc = new BoardController();

	public void mainmenu() {

		while (true) {

			System.out.println("*****자유게시판****");
			System.out.println("1.게시글 작성하기");
			System.out.println("2.게시글 수정하기");
			System.out.println("3.게시글 삭제하기");
			System.out.println("4.게시글 제목 키워드 검색");
			System.out.println("5.게시글 작성자 검색");
			System.out.println("6.게시글 전체 검색");
			System.out.println("0.자유 게시판 종료");
			System.out.print("이용할 메뉴 선택:");
			int menu = in.nextInt();
			in.nextLine();

			switch (menu) {
			case 1:
				createPost(); // 게시글 작성하기 메소드
				break;

			case 2:
				modifyPost(); // 게시글 수정하기 메소드
				break;
			case 3:
				deletePost(); // 게시글삭제하기 메소드
				break;
			case 4:
				searchForTitle(); // 게시글 키워드 검색
				break;
			case 5:
				searchForUser(); // 게시글 작성자로 검색
				break;
			case 6:
				selectAll();// 게시글 전체 검색
				break;

			case 0:
				System.out.println("자유게시판 종료");
				return;

			}

		}

	}

	private void searchForUser() {
		System.out.println("-----작성자로  찾기------");
		System.out.print("작성자를 입력해주세요:");
		int writer = in.nextInt();
		in.nextLine();
		bc.serchForUser(writer);		

	}

	private void searchForTitle() {
		System.out.println("--------게시판 키워드로 검색-------");
		System.out.print("제목 키워드를 입력해주세요:");

		String keyword = in.nextLine();

		bc.searchForTitle(keyword);

	}

	private void selectAll() {

		bc.selectAll();

	}

	private void deletePost() {
		System.out.println("----게시글 삭제하기----");

		System.out.print("게시글 번호 입력:");
		int bno = in.nextInt();

		bc.deletePost(bno);

	}

	private void modifyPost() {
		System.out.println("----게시글 수정하기----");
		System.out.print("게시글번호 입력:");
		int bno = in.nextInt();
		in.nextLine();

		System.out.print("수정할내용:");
		String newContent = in.nextLine();// 수정할 내용

		bc.modifyPost(bno, newContent);
	}

	/**
	 * 게시글을 작성하는 메소드
	 */
	private void createPost() {
		System.out.println("-----게시글추가-------");

		System.out.print("게시글 제목 :");
		String bno = in.nextLine();// 게시글 제목

		System.out.print("게시글 내용:");
		String content = in.nextLine();// 게시글 내용

		System.out.print("작성자번호:");
		int writer = in.nextInt(); // 작성자 번호 입력
		in.nextLine();
		bc.createPost(bno, content, writer);

	}

	// 글 올리는걸 성공했을 때 보이게될 메소드
	public void serviceSuccess(String message) {
		System.out.println("서비스요청성공:" + message);

	}

	public void serviceFail(String message) {
		System.out.println("서비스요청 실패:" + message);

	}
	
	//오버로딩
	public void showList(ArrayList<Board> list, int writer) {
		System.out.println(writer+ "님이 작성한 글 결과입니다.");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	/**
	 * 찾는 글을 보여주는 메소드. 여러행이 나올 수 있으므로 ArrayList로 받음
	 */

	public void keywordShow(ArrayList<Board> list, String keword) {
		System.out.println(keword + "에 대한 검색 결과입니다.");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public void showListall(ArrayList<Board> list) {
		System.out.println("****자유게시판******");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		
		
	}

}
}
