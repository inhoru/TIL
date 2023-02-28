package sec03.exam05;

public class 강제타입변환OperationPromotionExample {

	public static void main(String[] args) {
		//바이트도 변수 연산시 인트로 바뀐다.
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		int intValue1 =byteValue1 + byteValue2; 
		System.out.println(intValue1);
		// 차타입도 유니코드도 인트코드로바뀐다.
		char charValue1 = 'A';
		char charValue2 = 1;
		int intValue2 = charValue1 + charValue2;

		System.out.println("유니코드=" + intValue2);
		//문자를 출력하고싶다면?강제타입변환으로 차타입으로바꾼다
		System.out.println("출력문자:" + (char) intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4; /*10/4=2.5 이나와야 하는데 정수나누기정수라
		정수밖에안나온다.*/
		System.out.println(intValue4);
		
		//double로 변수를 선언한후 나누기를해준다. 이때 4.0으로써서 intValue3도실수로변환된다.
		double doubleValue = intValue3 / 4.0;
		System.out.println(doubleValue);
		
		//실수 결과를 얻을려면 실수연산으로 변환하자
		//이런느낌으로 x쪽을바꾸든 y쪽을 바꾸든 둘다 실수로 바뀐 실수연산이 가능하다.
		int x = 1;
		int y = 2;
		double result = (double) x / y;
		System.out.println(result);
		
		int q = 10;
		//int w = q / 4; 
		double r = q / 4.0;
		System.out.println(r);
		
		
		

	
	
	}

}
