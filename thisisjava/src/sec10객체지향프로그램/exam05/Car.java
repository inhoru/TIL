package sec10객체지향프로그램.exam05;

public class Car {
	//Field
	//Constructor
	Car(String color , int cc){ //이생성자는 외부로부터 자동차색상받고 자동차의배기량받는다.
		System.out.println(color);
		System.out.println(cc);
		System.out.println(color + "색의" + cc + "자동차가 생성됨");
		//생성자블록이정상적으로실행되야 비로서객체만들어지고 객체번지가 저장됨
	}
}
