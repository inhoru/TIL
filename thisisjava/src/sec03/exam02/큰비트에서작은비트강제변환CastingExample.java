package sec03.exam02;

public class 큰비트에서작은비트강제변환CastingExample {

	public static void main(String[] args) {
		//큰비트에서작은비트로강제변환 (   )이거붙여준다.
		int intValue = 44032;
		char charValue = (char) intValue;
		
		System.out.println(charValue);
		//큰비트에서 작은 비트 강제전환 (   )붙여주기
		long longValue = 500;
		intValue = (int) longValue;
		
		System.out.println(intValue);
		//큰비트에서 작은비트 소수점은 생략된다.
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		
		System.out.println(intValue);
		
		
		
		
	}

}
