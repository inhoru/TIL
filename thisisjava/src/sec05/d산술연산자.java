package sec05;

public class d산술연산자 {

	public static void main(String[] args) {
		//피연산자 타입이 동일하지않을경우 규칙에따라연산수행
		//피연산자가 int타입아래일경우 모두int로변환
		//피연산자가 모두 정수타입이고 long타입이 포함될경우 모두long타입으롭 변환
		//피연산자중실수 타입이 있을경우 허용범위큰실수타입변환ex)int % double 라면인트가 더블로변
		int v1 = 5;
		int v2 = 2;
		
		int result1 = v1 + v2;
		System.out.println(result1);
		
		int result2 = v1 - v2;
		System.out.println(result2);
	
		int result3 = v1 * v2;
		System.out.println(result3);

		int result4 = v1 / v2;//5를 2로나누면 2.5.이지만 int정수라서 2만나옴
		System.out.println(result4);
		
		int result5 = v1 % v2;//%는 나머지를구하는 연산식 ex)5를 2로나누면 나머지가 1이나옴 그래서 1임
		System.out.println(result5);
	
		double result6 = (double) v1 / v2;//소수를 얻고싶다면 v1이나v2를 실수로만든다 그래서v1을 강제타입변환으로 실수로 바꾼후 계산
		System.out.println(result6);  
		
	
	
	
	
	
	
	
	
	
	
	
	}

}
