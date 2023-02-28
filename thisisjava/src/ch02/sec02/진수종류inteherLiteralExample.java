package ch02.sec02;

public class 진수종류inteherLiteralExample {
	public static void main(String[] args) {
		/*
		 * 2진수:0b로시작 0b1011=11 1곱하기2의 몇승으로 시작 뒤에서부터 2에0승부터시작
		 * 
		 * 8진수:0으로 시작 013=11 1곱하기8의1승+3곱하기8의0승
		 * 
		 * 10진수: 소수점업슨 0~9구성된숫자 13
		 * 
		 * 16진수:0x로시작 0xB3= 179 그럼 3곱하기16의0승+b(11)곱하기16의1승
		 * 
		 * 0~9숫자와 ABCDEF라는 영어로구성
		 * 
		 * a=10,b=11,c=12,d=13,e=14,f=15
	
		 *3e6=3000000 3*10의6승이라는뜻 
		지수(e6)가양수면그수만큼 소수점을 오른쪽이동 
		지수가음수면 그수만큼왼쪽이동
		143E-3=0.143
		* 바이트코드로는 10진수 변수로 변화하여 나온다.
		*/
		 

		int var1 = 0b1011;
		int var2 = 0206;
		int var3 = 365;
		int var4 = 0x83;

		System.out.println("var1:" + var3);

	}

}
