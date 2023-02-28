package sec10객체지향프로그램.exam03;

public class carexample {

	public static void main(String[] args) {
		
		Car myCar = new Car(); //카라는클래스에서 필드선언한걸 카 바깥쪽에서 읽을려면 객체부터생성하라
		//위에께객체선언 이거해야만 위에 카라는 클래스꺼사용가능
		System.out.println("제작회사:" + myCar.company);//그래서 카라는 클래스에서 가져온컴퍼니가 뜬다
		System.out.println("모델명:" +myCar.model);
		System.out.println("색깔:" +myCar.color);
		System.out.println("최고속도:" +myCar.maxSpeed);
		System.out.println("현재속도:" +myCar.speed);
		
		myCar.speed = 60; // 60이라는값으로 대입연산자가바뀜
		System.out.println("현재속도:" +myCar.speed);
	
	}

}
