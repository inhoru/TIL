package sec04.exam1;

public class 모니터로변수값출력PrintfExample {//지시자

	public static void main(String[] args) {
		//형식문자열:%[argument_idex$] [flags] [width]   [.precision] conversion ,  값1,값2
		//				값의순번		  -.0    전체자릿수    소수자릿수      변환문자 
 		//형식문자열에서%와conversion외에는 모두 생략가능
		//conversion에는 제공되는 값의 타입에 따라 d(정수),f(실수),s(문자열)입력
		//형식 문자열에 포함될 값 2개 이상인 경우 값의 순번(1$,2$)을 표시해야한다
		//퍼센트 뒤에 - 붙으면 왼쪽정렬 아무것도없으면 오른정렬 0이면 오른쪽정렬 나머지0으로채움
		
		int value = 123;
		System.out.printf("상품의 가격:%d원\n", value);//%d(정수):123
		System.out.printf("상품의 가격:%6d원\n", value);//%6d(6자리의정수 왼쪽 빈 자리 공백):___123
		System.out.printf("상품의 가격:%-6d원\n", value);//%-6d(6자리의정수 오른쪽빈자리공백(-는 왼쪽부터채워라뜻):123___
		System.out.printf("상품의 가격:%06d원\n", value);//%06d(6자리의정수 왼쪽빈자리 0으로채움):000123
		
		//소수점 이상 7자리,소수점이하2자리,왼쪽빈자리공백 ex(%10.2f)
		double area = 3.14159 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n", 10 , area); //($표시없으면 앞에서부터 순서대로대입)
		
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
		
		
		
	}

}