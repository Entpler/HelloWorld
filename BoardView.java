package com.kh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.kh.controller.BoardController;
import com.kh.model.Board;

public class BoardView {

	Scanner in = new Scanner(System.in);
	BoardController bc = new BoardController();

	public void mainmenu() {

		while (true) {

			System.out.println("──────────사내게시판──────────");
		
			System.out.println("-----------   접속       -----------");
			
			System.out.println("1─────────●최신글보기─────────");
			System.out.println("2─────────●게시글작성──────────");
			System.out.println("3─────────●게시글수정──────────");
			System.out.println("4─────────●게시글삭제──────────");
			System.out.println("5─────────●제목검색────────────");
			System.out.println("6─────────●작성자로 검색────────");
			System.out.println("7─────────●날짜로 검색──────────");
			System.out.println("8─────────●전체글보기──────────");
			System.out.println("9─────────●게시판나가기────────");
			System.out.print("이용할 메뉴 선택:");
			int menu = in.nextInt();
			in.nextLine();
			switch (menu) {
			case 1:
				searchFortopN(); // 게시글 작성하기 메소드
				break;
				
			case 2:
				createPost();
				break;// 최신글보기
			// case 3:
			// modifyPost(); // 게시글 수정하기 메소드
			// break;
			// case 4:
			// deletePost(); // 게시글삭제하기 메소드
			// break;
			// case 5:
			// searchForTitle(); // 게시글 키워드 검색
			// break;
			// case 6:
			// searchForUser(); // 게시글 작성자로 검색
			// break;

			case 7:
				selectDate(); // 게시글 날짜로 검색
				break;

			case 8:
				selectAll();// 게시글 전체 검색
				break;

			}
		}
	}

	/**
	 * 게시글을 작성하는 메소드
	 */
	private void createPost() {
		System.out.println("새로운 게시글 올리기");
		System.out.print("게시글 제목:");
		String title = in.nextLine();

		System.out.print("게시글 내용:");
		String content = in.nextLine();

		System.out.print("작성자 아이디:");
		String writer = in.nextLine();
		// null 값 아닌애들만 입력

		bc.createPost(title, content, writer);
	}

	/**
	 * 전체 게시글을 보여주는 메소드
	 */
	private void selectAll() {
		System.out.println("전체 게시판 보여주기");
		bc.selectAll();

	}

	/**
	 * 전체 글중에 최근에 올라은글 수를 입력받아 보여주는 메소드
	 */
	private void searchFortopN() {
		System.out.println("최신글 모음_글 갯수를 입력하면 가장 최근 올라온 글 n개를 보여드립니다.");
		System.out.print("글 갯수를 입력하세요=>n으로 입력):");
		int N = in.nextInt();
		in.nextLine();

		bc.searchForTopN(N);
	}

	/**
	 * * 특정기간에 올려진 글들만 검색하는 메소드
	 */

	String dd = " ";

	private void selectDate() {
		System.out.println("----22년 9월 xx일에 입력된 글 검색---");
		System.out.print("일자를 입력해주세요 (xx로 입력) :");
		String dd = in.nextLine();
		// String create_date= in.nextLine();
		bc.selectDate(dd);

	}

	/**
	 * 서비스가 실패했을 때 실행되는 메소드
	 */
	public void processFail(String message) {
		System.out.println("서비스요청실패!:" + message);

		/**
		 * 서비스가 성공했을 때 실행되는 메소드
		 */
	}

	public void processSucess(String message) {
		System.out.println("서비스요청성공!:" + message);

	}

	/**
	 * 요청한 리스트를 보여주는 메소드
	 */
	public void showList(ArrayList<Board> list) {
		System.out.println("전체 게시글이 검색되었습니다.");
		for (Board x : list) {
			System.out.println(x);
		}
	}

	public void showDate(ArrayList<Board> list, String dd) {
		String datePattern = "yyyy-MM";
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		Date day = null;
		try {
			day = (Date) sdf.parse("2022-09");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(sdf.format(day) + "-" + dd + "에 작성된 결과입니다.");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
