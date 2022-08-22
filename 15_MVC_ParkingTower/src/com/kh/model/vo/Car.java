package com.kh.model.vo;

public class Car {

	private int parkingNum;

	private int carNum;

	private int carType;

	private String owner;

	public Car() {

	}

	public Car(int carNum, int carType, String owner) {
		this.carNum = carNum;
		this.carType = carType;
		this.owner = owner;
	}

	public int getParkingNum() {
		return parkingNum;
	}

	public void setParkingNum(int parkingNum) {
		this.parkingNum = parkingNum;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getCarType() {
		return carType;
	}

	public void setCarType(int carType) {
		this.carType = carType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	String carName = "";
	{

		if (this.carType == 1)
			;
		carName = "경차";
		if (this.carType == 2)
			;
		carName = "세단";
		if (this.carType == 3)
			;
		carName = "SUV";
		if (this.carType == 4)
			;
		carName = "트럭";
	}

	@Override
	public String toString() {
		return "Car [parkingNum=" + parkingNum + ", carNum=" + carNum + ", carType=" + carName + ", owner=" + owner
				+ "]";
	}

}
