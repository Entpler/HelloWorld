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
			System.out.println("1.��������");
			System.out.println("2.���� ����");
			System.out.println("3.������ ���� �˻�");
			System.out.println("4.��ü ���");
			System.out.println("5.���α׷� �����ϱ�");

			System.out.print("�޴�(����)�� �Է��ϼ���:");
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
				System.out.println("���α׷�����");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}

		}
	}

	public void insertCar() {
		System.out.print("������ȣ�� �Է��ϼ��� :");
		int carNum = in.nextInt();
		in.nextLine();
		System.out.print("���������� �Է��ϼ��� :");
		int carType = in.nextInt();
		in.nextLine();
		System.out.print("�������θ� �Է��ϼ���:");
		String owner = in.nextLine();

		Car car = new Car(carNum, carType, owner);
		int result = ptc.insertCar(car);

		if (result > 0) {
			System.out.println("������ �����Ͽ����ϴ�.");
		} else {
			System.out.println("������ �����Ͽ����ϴ�. ");
		}

	}

	public void deleteCar() {
		System.out.print("������ ������ȣ�� �Է��ϼ���.");
		int carNum = in.nextInt();
		in.nextLine();
		
		int result = ptc.deleteCar(carNum);
		if (result > 0) {
			System.out.println("������ �����Ͽ����ϴ�.");
		} else {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}

	public void searchCar() {
		System.out.print("������ ������ �Է��ϼ���: ");
		String owner = in.nextLine();

		ArrayList<Car> searched = ptc.searchCar(owner);

		/*
		 * if (searched.isEmpty()) { System.out.println("������ ������ �����ϴ�."); } else {
		 * System.out.println("�����Ͻ� �����Դϴ�."); System.out.println(searched);
		 */
		for(Car c : searched) {
			System.out.println(c);
		}
	}

	public void selectList() {
		System.out.println("��ü ������ ���� ��ȸ");
		carlist = ptc.selectList();
		if (carlist.isEmpty()) {
			System.out.println("������ ã�� ���߽��ϴ�.");
		} else {
			for (Car c : carlist) {
				System.out.println(c);
			}

		}

	}
}
