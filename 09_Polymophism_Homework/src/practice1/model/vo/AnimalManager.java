package practice1.model.vo;

public class AnimalManager {

	public static void main(String[] args) {

		Animal[] animal = new Animal[5];
		
		
		animal[0] = new Cat("����", "�ƺ�Ͻþ�", "��Ƽ���Ǿ�", "������");
		animal[1] = new Cat("����", "�긮Ƽ�÷����", "����", "���");
		animal[2] = new Cat("ġ�佺", "�丣�þ�ģĥ��", "�̶�", "���");
		animal[3] = new Dog("����", "������", 35);
		animal[4] = new Dog("����", "Ǫ��", 30);

		
		
		
		for (int i = 0; i < animal.length; i++) {
			animal[i].speak();
		}

	}

}
