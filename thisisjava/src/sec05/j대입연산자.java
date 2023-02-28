package sec05;

public class j대입연산자 {

	public static void main(String[] args) {
		/* 단순대입연사자 (=) 오른쪽에 피연산자값을 왼쪽 변수에저장 
		 * 복합대입 연산자 +=,-+,*,/=,%=,&=,|=,^=등등 변수에저장하기전에 변수+피연산자를 한후에 변수에저장
		 */
		
		int result = 0;
		result += 10;//0에10을더한후 변수에저장
		System.out.println(result);
		
		result -= 5;//10에-5를한후 변수에저장
		System.out.println(result);
		
		result *= 3;//5에곱하기3을한후 저장
		System.out.println(result);

		result /= 5;//15에 나누기5를한후 저장
		System.out.println(result);

		result %=3 ;//3에 나머지를구한후 저장 
		System.out.println(result);

		
		
		
		
	}

}
