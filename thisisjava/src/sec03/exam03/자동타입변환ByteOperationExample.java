package sec03.exam03;

public class 자동타입변환ByteOperationExample {

	public static void main(String[] args) {
		//연산에서 인트이하인경우 인트로 자동변환
		byte x = 10;
		byte y = 20;
		int result = x+y;
		//2개중하나가 long이면 모두long로 변환
		byte x2 = 30;
		long y2 = 40;
		long result2 = x2 + y2;
		
		//변수가사용된다면 변환 아니라면 변환x
		byte result1 =10 + 20;
		
	   

	}

}
