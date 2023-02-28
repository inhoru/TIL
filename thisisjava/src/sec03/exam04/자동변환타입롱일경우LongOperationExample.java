package sec03.exam04;

public class 자동변환타입롱일경우LongOperationExample {

	public static void main(String[] args) {

		byte value1 = 10;
		int value2 = 100;
		long value3 = 1000L;  //리터럴뒤에L은 롱이라는걸알려주는것 
				
		long result = value1 + value2 + value3;
		//long가들어가있으니 전체연산 값은 롱이나온다.
		System.out.println(result);
	
	}
	
	

}
