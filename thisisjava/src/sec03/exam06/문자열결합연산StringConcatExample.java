package sec03.exam06;

public class 문자열결합연산StringConcatExample {

	public static void main(String[] args) {

		int value = 10 + 2 + 8;
		System.out.println("value:" + value);
		// 10+2=12+"8"=128
		String str = 10 + 2 + "8";
		System.out.println("str:" + str);
		// 10+문자열"2"="102"+8="1028"
		String str2 = 10 + "2" + 8;
		System.out.println("str2:" + str2);
		// 문자열 10+2="102"+8= "1028"
		String str3 = "10" + 2 + 8;
		System.out.println("str3:" + str3);
		// 괄호안에있는것부터 우선적으로 계산후 문자열과 덧셈
		String str4 = "10" + (2 + 8);
		System.out.println("str4:" + str4);

		// 문자열(String)을 기본타입(int,long,short,float,double,boolean)으로 강제변환
		//parse 이용해서 바꾼후 사용
		String qwe = "10";
		byte value1 = Byte.parseByte(qwe);
		System.out.println(value1);
		// 문자열에 숫자외요소포함된다면 위방법으로는 에러가난다. 그러면 아코드에 숫자가아닌다른게들어가있구나 깨닿기
		
		//String.valueOf()메소드를 사용하여 기본타입을 문자열로 변환
		//또다른방벙 String str = "" + 3'="3" 도가능
		
		
	}

}
