package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.vo.Board;
import service.BoardService;
import view.BoardView;

public class BoardController {

	public int createPost(String title, String content, String writer) {

		int result = 0;

		Board b = new Board();

		b.setTitle(title);
		b.setContent(content);
		b.setWriter(writer);

		// 데이터 가공 후 Service쪽으로 넘겨주기
		result = new BoardService().createPost(b);

		if (result > 0) {
			new BoardView().serviceSuccess("게시글이 입력되었습니다(new)!");
		} else {
			new BoardView().serviceFail("게시글이 입력에 실패하였습니다.");
		}
		return result;
	}

	public void modifyPost(int bno, String newContent) {

		Board b = new Board();
		b.setBno(bno);
		b.setContent(newContent);

		int result = new BoardService().modifyPost(b);
		if (result > 0) {
			new BoardView().serviceSuccess("게시글이 수정되었습니다.");
		} else {
			new BoardView().serviceFail("게시글 수정에 실패하였습니다.");
		}

	}

	// SELECT 문. arraylist 로 전체 게시글 보여주기
	public void selectAll() {

		ArrayList<Board> list = new BoardService().selectAll();
		if (list.isEmpty()) {
			new BoardView().serviceFail("게시판이 비어있습니다. 글을 올려주세요.");
		} else {
			new BoardView().showListall(list);
		}

	}

	public void deletePost(int bno) {
		int result = new BoardService().deltePost(bno);
		if (result > 0) {
			new BoardView().serviceSuccess("게시글이 삭제되었습니다.");
		} else {
			new BoardView().serviceFail("게시글이 삭제에 실패하였습니다. 다시 시도해주세요");
		}

	}
	
	/**
	 * 게시판 글 중에 키워드로 검색하는 메소드 ->select문
	 */
	public ArrayList<Board> searchForTitle(String keyword) {
		ArrayList<Board> list = new ArrayList<>();
	list = new BoardService().searchForTitle(keyword);
		if(list.isEmpty()) {
		  new BoardView().serviceFail("찾으시는 글이 없습니다.");
		}else {
			new BoardView().keywordShow(list, keyword);
		}
		return list;
	}

	public ArrayList<Board> searchForUser(String userId) {
		ArrayList<Board> list = new ArrayList<>();
		
		list = new BoardService().searchForUser(userId);
		
		
		if(list.isEmpty()) {
			new BoardView().serviceFail(userId + "가 작성한 글이 없습니다.");	
		}else {
			System.out.println(userId +"가 작성한 글입니다.");
		    new BoardView().showListall(list);
		}
		
		
		return list;
	}

	public ArrayList<Board >selectDate(int writed_date) {
		ArrayList <Board> list= new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yy" + "/" + "MM" + "/" + writed_date);
		
		list= new BoardService().selectDate(writed_date);
		if(list.isEmpty()) {
			new BoardView().serviceFail(sdf + "에 작성된 글이 없습니다.");
			
		}else {
			new BoardView().showDate(list);
		}
		return list;
	}

}
