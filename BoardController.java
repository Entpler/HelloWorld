package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.kh.BoardView;
import com.kh.common.BoardTemplate;
import com.kh.model.Board;
import com.kh.model.BoardDao;
import com.kh.model.BoardService;

public class BoardController {
	
	/**
	 * 
	 * @param title 게시판의 제목
	 * @param content 게시판의 내용
	 * @param writer 작성자 
	 */
	public int createPost(String title, String content, String writer) {
		//입력받은 값 가공 해서 board 리턴
		int result = 0;
		Board b = new Board();
		b.setTitle(title);
		b.setContent(content);
		b.setWriter(writer);
		
		result= new BoardService().createPost(b);
		
		if(result>0) {
		new BoardView().processSucess("새로운 게시글이 등록되었습니다.");
		
		}else {
			 new BoardView().processFail("글 올리기에 실패하였습니다.");
		}
		return result;
		
	}
	
	public ArrayList<Board> selectAll() {
		
	ArrayList<Board> list = new ArrayList<>();
	list = new BoardService().selectAll();
	if(list.isEmpty()) {
		new BoardView().processFail("게시판이 비어있습니다.");
	}else {
		new BoardView().showList(list);
	}
	return list;
	
		
	}

	/**
	 * 입력받은 글 갯수로 글 보여주기
	 */
	public ArrayList<Board> searchForTopN(int N) {
		ArrayList<Board> list = new ArrayList<>();
		list=new BoardService().searchForTopN(N);
		if(list.isEmpty()) {
			new BoardView().processFail("최근 올라온 글이 없습니다.");
		}else {
			new BoardView().showList(list);
		}
		return list; 
	}

	public ArrayList<Board> selectDate(String dd) {
		ArrayList <Board> list= new ArrayList<>();
		  
		  String datePattern = "yyyy-MM"; SimpleDateFormat sdf = new
		  SimpleDateFormat(datePattern); Date day = null; try { day =
		  (Date)sdf.parse("2022-09"); } catch (ParseException e) { e.printStackTrace();
		  }
		 
		list = new BoardService().selectDate(dd);
		if (list.isEmpty()) {
			new BoardView().processFail(sdf.format(day)+dd+"에 작성된 글이 없습니다.");
		} else {
			new BoardView().showDate(list,dd);
		}
		return list;
	}

}


	