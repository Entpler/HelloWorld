package practice1.model.vo;

public class AnimalManager {

	public static void main(String[] args) {

		Animal[] animal = new Animal[5];
		
		
		animal[0] = new Cat("코코", "아비니시안", "에티오피아", "범무늬");
		animal[1] = new Cat("슈가", "브리티시롱헤어", "영국", "흰색");
		animal[2] = new Cat("치토스", "페르시안친칠라", "이란", "흰색");
		animal[3] = new Dog("진구", "진돗개", 35);
		animal[4] = new Dog("초코", "푸들", 30);

		
		
		
		for (int i = 0; i < animal.length; i++) {
			animal[i].speak();
		}

	}

}
