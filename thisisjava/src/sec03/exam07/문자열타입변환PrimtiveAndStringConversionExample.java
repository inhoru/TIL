package sec03.exam07;

import javax.management.StringValueExp;

import ch02.sec02.진수종류inteherLiteralExample;

public class 문자열타입변환PrimtiveAndStringConversionExample {

	public static void main(String[] args) {
		// 문자열(String)을 기본타입(int,long,short,float,double,boolean)으로 강제변환
		//parse 이용해서 바꾼후 사용
		//변수안넣어도 그냥저기에 문자열을넣어도 값은같다.
		//String str1 = "10";
		int value1 = Integer.parseInt("10");
		System.out.println(value1);
		
		double value2 = Double.parseDouble("3.14");
		System.out.println(value2);
	
		boolean value3 = Boolean.parseBoolean("tree");
		System.out.println(value3);		
		
		//기본형을 문자열로 바꾸고싶다.
		//String.valueOf()메소드를 사용하여 기본타입을 문자열로 변환
		//int value4  = 10; 생략가능
		
		String str1 = String.valueOf("10");
		System.out.println(str1);
		String str2 = String.valueOf("3.14");
		System.out.println(str2);
		String str3 = String.valueOf("true");
		System.out.println(str3);
		//또다른방벙 String str = "" + 3'="3" 도가능
		String str4= "" + 3;		
		System.out.println(str4);
	
	
	
	}
	
	

}
