package sec05;

public class h비교연산자2 {

	public static void main(String[] args) {

		int v2 = 1;
		double v3 = 1.0;
		System.out.println(v2 == v3);//비교하기전에 인트가 1.0으로바꿔서 연산이된다.
		
		double v4 = 0.1;
		float v5 = 0.1f;
		System.out.println((double)v5);//0.1이안나오는게 부동소수점방식때문이다 정확하게0.1.을저장할수없
		System.out.println(v4 == v5);//이렇게비교하면안된다 
		System.out.println((float)v4 == v5);//더블을 강제타입변환으로 프론트로바꾼다.
		System.out.println((int)(v4*10) == (int)(v5*10));//둘다 정수화시켜서 비교한다든지 한
	}
}

