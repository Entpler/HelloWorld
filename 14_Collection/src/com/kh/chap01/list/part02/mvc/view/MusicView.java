package com.kh.chap01.list.part02.mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01.list.part02.mvc.comtroller.MusicController;
import com.kh.chap01.list.part02.mvc.model.vo.Music;

//View : 시각적인 요소(사용자가 보게 될 화면)
//       출력문과 입력문을 사용
public class MusicView {
//사용자가 프로그램 시작시 가장 처음 보여지는 화면 
//=>메인화면 

	// 전역변수 //스캐너 어디서든지 쓰게끔

	private Scanner in = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {
		while (true) {
			System.out.println("*** Welcom 별밤 ***");
			System.out.println("1. 새로운 곡 추가");
			System.out.println("2. 곡 전체 조회");
			System.out.println("3. 특정 곡 검색");
			System.out.println("4. 특정 곡 삭제"); // remove
			System.out.println("5. 특정곡 수정");
			System.out.println("0. 프로그램 종료");

			System.out.println("----------------------------");

			System.out.print("메뉴 입력: ");
			int menu = in.nextInt();
			in.nextLine();

			switch (menu) {

			case 1:
				inserMusic(); // 같은 클래스의 메소드는 그냥 호출 되면됨.
				break;
			case 2:
				selecMusicList();
				break;
			case 3:
				searchMusic();
				break;
			case 4:
				deleteMusic();
				break;
			case 5:
				updateMusic();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 메뉴입니다.다시 입력해주세요");
			}
		}

	}

	// 1. 새로운 곡을 추가시킬 수 있는 화면 담당하는 메소드.
	public void inserMusic() {

		System.out.println("==새로운 곡 추가==");
		System.out.print("곡명 입력: ");
		String title = in.nextLine();
		System.out.print("가수명 입력 : ");
		String artist = in.nextLine(); // 출력문과 입력문이니까 메소드로 뺀다.
		// 추가해주세요 요청 => controller 클래스에 메소드를 호출해서 요청을 처리하도록

		mc.inserMusic(title, artist);
		System.out.println("성공적으로 추가되었습니다.");

	}

	public void selecMusicList() {
		// 전체시스트를 조회해 주세요 요청=>Controller 클래스의 메소드 호출

		System.out.println("==곡 전체 조회==");
		ArrayList<Music> list = mc.selectMusicList();
		if (list.isEmpty()) {
			System.out.println("현재 존재하는 곡이 없습니다.");

		} else {// 리스트가 비어있지 않을 경우
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}

	// 3.특정 곡을 검색할 수 있는 화면
	public void searchMusic() {
		System.out.println("==특정 곡 검색==");
		System.out.print("검색할 곡명 키워드:");
		String keyword = in.nextLine();

		// 검색해주세요 =>Controller 클래스의 메소드 호출
		ArrayList<Music> searched = mc.searchMusic(keyword);

		// 검색결과 출력

		System.out.println("검색결과: ");

		if (searched.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		} else {

			for (Music m : searched) {
				System.out.println(m);
			}

		}
	}

	// 4.특정 곡을 삭제할 수 있는 화면

	public void deleteMusic() {
		System.out.println("==특정 곡 삭제==");
		System.out.print("삭제할 곡명:");
		String title = in.nextLine();
		// 삭제해 주세요 요청 => Contoller클래스의 메소드

		int result = mc.deleteMusic(title);

		if (result > 0) {// 양수값= 삭제가 진행됨
			System.out.println("성공적으로 삭제되었습니다.");

		} else {// 삭제할 곡을 찾지못함.
			System.out.println("삭제할 곡을 찾지 못했습니다.");

		}
	}

	// 5.
	public void updateMusic() {
		System.out.println("==특정 곡 수정==");
		//뭐를 어떻게 수정해야하는지 언급
		//기존곡명,수정할곡명,수정할 가수명 입력받기
		System.out.print("기존 곡명 :");
		String title =in.nextLine();
		
		System.out.print("수정내용(곡명):");
		String upTitle = in.nextLine();
		
		System.out.print("수정내용(가수명):");
		String upArtist = in.nextLine();
		
		//수정해주세요 요청 - >Controller 클래스의 메소드 호출
		//수정여부를 리턴받기(int)
		int result = mc.updateMusic(title, upTitle, upArtist);
		if(result>0) { //수정이 진행됨
			System.out.println("성공적으로 수정되었습니다.");
			
		}else { //수정할 곡을 찾지 못함
			System.out.println("수정할 곡을 찾지 못했습니다.");
			
		}
	}

}
