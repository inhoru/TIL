package sec04.exam5;

import java.util.Scanner;//스캐너 사용할반드시 넣어야함 자바안에잇는 걸사용하기떄문에


public class 스캐너 {

	public static void main(String[] args) {
		//read의단점 2개이상의 조합된 할글을 읽을수 없음(한)
		//키보드로입력된 내용응통문자열로 읽을수없음(우리나라)
		//scanner로해결 nextLine 엔터키이전까지 입력된문자를읽어줌
		
		Scanner scanner = new Scanner(System.in);
		//스캐너의 변수선언   시스템의입력장치로부터읽는 스캐너생성
		String inputData;
		//스프링 변수선언 문자열임그래서 스프링
		
		while(true) {
			
			inputData = scanner.nextLine();
			//           엔터키이전까지입력된문자열을읽음parsedouble


			System.out.println("입련된 문자열:" + inputData);
			
			if(inputData.equals ("q")) {//q를누루면멈춤
				break;
			//기본타입의 비교는 == 사용
			//int x =5;
			//boolean result = (x==5); //true
			//문자열 비교는 equals()메소드사용
			//boolean result = inputData, equals("비교문자열");
				
				
			}
		}
		
		System.out.println("종료");
		
	}

}
