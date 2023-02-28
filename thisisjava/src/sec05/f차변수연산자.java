package sec05;

public class f차변수연산자 {

	public static void main(String[] args) {
		
		char c1 = 'A' + 1;//자바컴파일러가 a랑1을연산한다 a는65이니간 66이저장된다
		char c2 = 'A';
		int c3 =  c2 + 1;// 변수가 산술연산에 사용된다면 자바컴파일러가 연산하지않는다 이대로 바이트코드로만들고 자바가상머신이 이연산을하는데
		//무조건정수는 인트로변해서 스윙한다 그래서 연산결과도 인트가나온다 그래서char대신 int를넣어야한다.
		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		
		
		
		
		
		
		
	}

}
