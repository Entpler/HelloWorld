package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Car;

public class ParkingTowerController {
	
	ArrayList<Car> carlist = new ArrayList<>();
	ArrayList<Car> searched = new ArrayList<>();
	
	public int insertCar(Car car) {
		int lastNo =0;
		int result = 0;
		try {
			lastNo=carlist.get(carlist.size()-1).getParkingNum()+1;
		}catch(ArrayIndexOutOfBoundsException e) {
			lastNo = 1;
		}
		
		car.setParkingNum(lastNo);
		carlist.add(car);
		result ++;
		
		return result;
		
		
		
	}
	
	public int deleteCar(int carNum) {
			
		int result = 0;
		for(int i = 0; i<carlist.size();i++) {
			if(carlist.get(i).getCarNum()==carNum) {
				carlist.remove(i--);
				result++;
			}
		}
		return result;
	}
	
	public ArrayList<Car> searchCar(String owner){
		ArrayList<Car>searched = new ArrayList<>();
		
		for(int i = 0; i<carlist.size(); i++) {
			if(carlist.get(i).getOwner().equals(owner)) {
			searched.add(carlist.get(i));
			}
		}
		return searched;
		
		
		
	}

	public ArrayList<Car> selectList() {
		
		return carlist;
	}

}
