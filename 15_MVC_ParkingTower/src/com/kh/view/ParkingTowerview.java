package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ParkingTowerController;
import com.kh.model.vo.Car;

public class ParkingTowerview {

	private Scanner in = new Scanner(System.in);
	private int ParkingTowerController;
	ParkingTowerController ptc = new ParkingTowerController();
	ArrayList<Car> carlist = new ArrayList<>();

	public void mainMenu() {

		while (true) {
			System.out.println("1.차량주차");
			System.out.println("2.차량 출차");
			System.out.println("3.주차된 차량 검색");
			System.out.println("4.전체 출력");
			System.out.println("5.프로그램 종료하기");

			System.out.print("메뉴(숫자)를 입력하세요:");
			ParkingTowerController = in.nextInt();
			in.nextLine();
			switch (ParkingTowerController) {

			case 1:
				insertCar();
				break;
			case 2:
				deleteCar();
				break;
			case 3:
				searchCar();
				break;
			case 4:
				selectList();
				break;
			case 0:
				System.out.println("프로그램종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");

			}

		}
	}

	public void insertCar() {
		System.out.print("차량번호를 입력하세요 :");
		int carNum = in.nextInt();
		in.nextLine();
		System.out.print("차량종류를 입력하세요 :");
		int carType = in.nextInt();
		in.nextLine();
		System.out.print("차량주인를 입력하세요:");
		String owner = in.nextLine();

		Car car = new Car(carNum, carType, owner);
		int result = ptc.insertCar(car);

		if (result > 0) {
			System.out.println("주차에 성공하였습니다.");
		} else {
			System.out.println("주차에 실패하였습니다. ");
		}

	}

	public void deleteCar() {
		System.out.print("출차할 차량번호를 입력하세요.");
		int carNum = in.nextInt();
		in.nextLine();
		
		int result = ptc.deleteCar(carNum);
		if (result > 0) {
			System.out.println("출차에 성공하였습니다.");
		} else {
			System.out.println("출차에 실패하였습니다.");
		}
	}

	public void searchCar() {
		System.out.print("차주의 성함을 입력하세요: ");
		String owner = in.nextLine();

		ArrayList<Car> searched = ptc.searchCar(owner);

		/*
		 * if (searched.isEmpty()) { System.out.println("주차된 차량이 없습니다."); } else {
		 * System.out.println("주차하신 차량입니다."); System.out.println(searched);
		 */
		for(Car c : searched) {
			System.out.println(c);
		}
	}

	public void selectList() {
		System.out.println("전체 주차된 차량 조회");
		carlist = ptc.selectList();
		if (carlist.isEmpty()) {
			System.out.println("차량을 찾지 못했습니다.");
		} else {
			for (Car c : carlist) {
				System.out.println(c);
			}

		}

	}
}
