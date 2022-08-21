package com.kh.chap01.list.part02.mvc.comtroller;

import java.util.ArrayList;

import com.kh.chap01.list.part02.mvc.model.vo.Music;

public class MusicController {
//새로운 곡 추가 요청 시 실행 될 메소드
	ArrayList<Music> list = new ArrayList<>();
	{
		// 초기화 블록 //메소드는 아니고 원하는 값을 셋팅 하고 싶을때.

		list.add(new Music("that,taht", "싸이"));
		list.add(new Music("불타오르네", "BTS"));

	}

//음악을 보관할 수 있는 저장소를 전역변수로 빼둠.
	public void inserMusic(String title, String artist) {
		list.add(new Music(title, artist));
	}

	// 전체 곡 조회 요청 시 실행될 메소드

	public ArrayList<Music> selectMusicList() {// 리스트가 비어있을 경우
		return list;
	}

	// 특정 곡 검색 요청시 실행될 메소드

	public ArrayList<Music> searchMusic(String keyword) {

		// 검색기능 :해당 키워드가 포함된 것들은 모두 조회

		// 1.검색된 결과물을 담을 변수 셋팅
		// (결과가 0개일 수도 있고, 1개일 수도 있고, 2개, 여러개 일수도 있음)

		ArrayList<Music> searched = new ArrayList<>(); // 현재 빈 상태
		// 반복문을 돌려가며 일치하는것이 아니라 포함된 것이 있는지 검사해야함.
		for (int i = 0; i < list.size(); i++) {
			// 문자열의 일치관계를 검사할 수 있는 메소드 :equals()
			// 문자열의 포함관계를 검사할 수 있는 메소드:문자열.contains(검사할 문자열)
			// =>문자열 안에 검사할 문자열이 포함되어있다면 true, 아니라면 false리턴
			if (list.get(i).getTitle().contains(keyword)) {
				searched.add(list.get(i));

			}
		}
		return searched;
	}
	// =>포함된 내용물이라면 검색된 결과문을 담을 수 있는 변수에 담아두기

	// 3.검색된 결과를 View단으로 리턴하기

	// 4.특정 곡 삭제시 실행될 메소드
	public int deleteMusic(String title) {
		int result = 0; // 삭제가 진행된 갯수를 나타내는 변수

		// 반복문을 통해 곡 제목이 정확히 일치하는지 검사
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getTitle().equals(title)) { // 곡 제목이 일치한ㄷ면
				list.remove(i--); // 앞으로 한칸씩 떙겨올것을 대비하여 후위연산자 추가
				result++;

			}
		}
		// result return
		return result; // 0일수도 있고(삭제된게 없을 경우), 양수값(삭제된게 뭐라도 있을경우) 일수도 있음.
	}
	// 특정 곡 수정시 요청시 실행할 메소드

	public int updateMusic(String title, String upTitle, String upArtist) {

		// 1. 수정된 곡 갯수를 받아낼 수 있는 변수를 셋팅
		int result = 0;

		// 2. 반복문을 통해 제목이 일치하는지 검사 후 일치한다면 곡 정보를 수정
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) { // 제목이 일치한다면

				/*
				 * //수정하는 방법 2가지 //비교적 효율적->필드값만 바꿔치기. list.get(i).setTitle(upTitle);
				 * list.get(i).setArtist(upArtist);
				 */
				// 2.비교적 효율적인 방법은 아니지만 오늘 배운 내용을 활용할 수 있음.
				// set: 몇번째를 어떻게 바꿔치기 할것인가
				list.set(i, new Music(upTitle, upArtist)); // new 쓰는 순간 heap 영역에 또 메모리에 할당되긴 함.

				result++;

			}
		}

		return result;
		// 3. 결과 반환

	}

}
