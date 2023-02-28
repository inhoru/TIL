package sec08배열.exam01;

public class 참조타입String타입뉴연산자 {

	public static void main(String[] args) {
		//스트링 타입 변수에 문자 대입면 변수가 스트링객체를 참조
		//네임이라는 변수로하면 스택영역에 생성되구 문자열에대한스트링객체는 힙영역에 저장된다. 5번지에생선되면 네임에 5가생선된다.
		//문자열 리터럴이동일한경우 스트링객체 공유 네임1,네임2 이름이같을때 두변수는 동일한 객체 공유
		//뉴로생성하면 힙영영겡 새로운 스트링객체 생성가능
		//String name1 = new String("신용권") : 안에들어가있는 문자열은같지만 	
		//String name2 = new String("신용권") : 다른스트링객체를 가짐
		//문자열 비교:equals():문자열비교 boolean result = st11.eqyals(str2); 문자열이 비교 할때 사용
		String strVar1 = "신민철";
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2 ) {
			System.out.println("strVa1과 staVar2 는 참조가 같음");
		} else {
			System.out.println("strVa1과 staVar2 는 참조가 같음");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("strVa1과 staVar2 는 참조가 같음");
		}
	
	
		String strVar3 = new String("신밀철");
		String strVar4 = new String("신밀철");
		
		if(strVar3 == strVar4) {
			System.out.println("strVar3과 staVar4 는 참조가 같음");
		} else {
			System.out.println("strVa3과 staVar4 는 참조가 다름");//뉴를썻기에 참조가 다르다.
		}
		
		if(strVar3. equals(strVar4)) {
			}
		System.out.println("strVa1과 staVar2 는 참조가 같음");//신민철 문자열기같다.
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	

}
