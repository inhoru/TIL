package sec08배열.exam05;

public class mainstring {

	public static void main(String[] args) {
		//덧셈을하는프로그램만드는중
		if(args.length != 2) {//!부정문
			System.out.println("값의 수가 부족합니다.");
			System.exit(0);//강제종료하는 코드
		
		
		
		
		
		}

		
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1);//문자열을기본타입으로변환
		int num2 = Integer.parseInt(strNum1);
	
		int result = num1 + num2;	
		System.out.println(num1 + "+" + num2 + "=" + result);
	}

}
