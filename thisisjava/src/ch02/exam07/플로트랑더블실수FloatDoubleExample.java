package ch02.exam07;

public class 플로트랑더블실수FloatDoubleExample {

	public static void main(String[] args) {
		
		//float var1 = 3.14f;float 뒤에f를꼭붙이자
		float var2 = 3.14f;
		double var3 = 3.14;
		
		System.out.println(var2);
		System.out.println(var3);
		//float 소수이하자리 7개만 저장가능(맨마지막꺼는 반올림해서나온거기떄문에 정밀x)
		float var4 = 0.1234567890123456789f;
		//double 소수이하자리 15개만 저장가능(맨마지막꺼는 반올림해서나온거기떄문에 정밀x)
		double var5 = 0.1234567890123456789;
		
		System.out.println(var4);
		System.out.println(var5);
		
		/*3e6=3000000 3*10의6승이라는뜻 
		지수(e6)가양수면그수만큼 소수점을 오른쪽이동 
		지수가음수면 그수만큼왼쪽이동
		143E-3=0.143*/
		double var6 = 3e6;
		double var8 = 2e-3;
		
		System.out.println(var6);
		System.out.println(var8); 
		
		
		
		
	
	}
	

}
