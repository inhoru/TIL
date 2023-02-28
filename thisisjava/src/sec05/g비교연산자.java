package sec05;

public class g비교연산자 {

	public static void main(String[] args) {
		/* 피연산자의 대소 비교를 하여 true/false 산출 : 조건문이나 반복문에서 실행흐름제어
		 * ==(두연산자의값이 같은지를검사)
		 * !=(두연산자의 값이 다른지를 검사)
		 * 위에 2개는 모든 타입에 사용가능 (동등비교)
		 * 크기비교연산자는 boolean 외 모든 기본타입 사용가능
		 * >(1보다 큰지를검사)
		 * >=(1보다크거나 같은지를검사)
		 * <(1보다 작은지를검사)
		 * <=(1보다 작거나 같은지를 검사)*/
		
		
		int num1 = 10;
		int num2 = 10;
		boolean result1 = (num1 == num2);//1이랑 2가 같냐고 물어보는중
		boolean result2 = (num1 != num2);//1이랑 2가 다르냐고 물어보는중 
		boolean result3 = (num1 <= num2);//1이 작거나 같은지 검사한다.
		
		System.out.println("result1=" + result1);
		System.out.println("result1=" + result2);
		System.out.println("result1=" + result3);
	
		char char1 = 'A';//유니코드 65
		char char2 = 'B';//유니코드 66
		boolean result4 = (char1 < char2);
		System.out.println("result4=" + result4);
	
	}

}
