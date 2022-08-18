package com.hw6.controller;

import java.util.Scanner;

public class filter {

	public void method1() {
		Scanner in = new Scanner(System.in);
		System.out.print("입력:");
		String str = in.nextLine();

		// 필터링용 배열
		String[] filter = { "신발끈", "개나리", "수박씨", "호루라기", "시베리아", "십장생", "조카", "주옥", "쌍쌍바", "십자수", "식빵" };

		// 필터링 작업

		for (int i = 0; i < filter.length; i++) {
			// 각 인덱스에 들은 필터링을 문자열 기준으로 *로 치환할 문자열을 새로 생성
			String star = "" + filter[i].charAt(0);
			int size = filter[i].length(); //해당 글자의 글자수를 추출
			for (int j = 0; j < size -1 ; j++) {
				star += "*";
			}

			str = str.replace(filter[i], star);
		}
		System.out.println(str);

	}
}
