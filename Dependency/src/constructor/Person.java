package di.constructor;

import di.tire.GoldTire;

public class Person {
	public static void main(String[] args) {
		
		//생성자 의존성 주입
		Car car = new Car( new GoldTire());
		
		System.out.println(car.getTire());
		
		
		
	}
}
