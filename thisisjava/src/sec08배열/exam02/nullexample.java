package sec08배열.exam02;

public class nullexample {

	public static void main(String[] args) {
		
		String hobby = null;	//널인상태에서 객체의메소드사용불가능	
		
		String name = "홍자바";
		name = null; //홍자바라는걸지우기위해 네임에 널을 넣는다 그럼 메모리가 지워진다.
		
	}

}
