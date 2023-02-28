package sec04.exam2;

public class 키보드에서입력된내용을변수에저장KeyCodeExample {

	public static void main(String[] args) throws Exception/*예외처리코드*/{
		//키보드에 키를 입력할때 프로그램에서 숫자로 된 키코드를 읽음
		//Ststem.in의read()사용
		//얻은 키코드는 대입 연산자 int변수에 저장
		int keyCode;
		
		//실행하고 콘솔에 입력하고엔터하면 숫자가나옴
		keyCode = System.in.read();
		System.out.println("keyCode: " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode: " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode: " + keyCode);

		
		
	}

}
