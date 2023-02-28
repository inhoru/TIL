package sec10객체지향프로그램.exam01;

public class 객체란 {

	public static void main(String[] args) {
		 객체 속성(자동차속도,색깔) 동작(달린다,멈춘다)
	    
	    클래스(class):자바의설계도 설계도로만든게 객체(인스턴스)
	    클래스설계>설계된클래스로 사용할객체생성>객체 이용>
	    
	    객체 구상후 클래스 이름을 결정
	     -하나 이상의 문자로 이루어질것
	     -첫글자에는 숫자가올수없음
	     -$,_외의특수문자는 사용할수없음
	     -자바 키워드는 사용할수없음(for,if,int)등
	    
	     new 연산자;객체생성연산자이며 생성자를 호출하고 객체생성번지를 리턴
	     Student si = new Student(); si은 뉴스트던트에 번지를같게됨 번지를통해 객체참조
	   
	     
	     클래스 멤버
	     필드(field):객체의 데이터가저장되는곳 int fieldname;
	     생성자(Constructor):객체 생성시 초기화 역할 담당 Classname() {...}
	     매소드(Method):객체의 동작에 해당하는 실행 블록:void methodName() {...}
	     
	}

}
