package sec05;

public class i논리연산자 {

	public static void main(String[] args) {
		/*AND(논리곱) &or&&(피연산자가 모두 true일경우에만 연산결과가 true)
		 * OR(논리합) |or||(피연사자중 하나만 true일경우에만 연산결고가 true)
		 * XOR(베타적 논리합) ^(피연산자가 하나는 true이고 다른하나는 false일 경우에만 연산 결과가 true)
		 * NOT(논리부정)!(피연사자의 논리값을 바꿈)
		 */
		int charcode = 'A';
		
		if( (charcode>=65) & (charcode<=90) ) {//&가 하나가있는경우는 앞에꺼 확인하고 뒤에꺼도 확인한다는뜻)
			System.out.println("대문자 이군요");
		
		if( (charcode>=97) && (charcode<=122) ) {//&&가 두개가있는경우는 앞에껏만 확인하고 뒤에꺼는 확인안한다는뜻)
			System.out.println("소문자 이군요/");
		}
		
		if( !(charcode<48) && !(charcode>57) ) {//&&가 두개가있는경우는 앞에껏만 확인하고 뒤에꺼는 확인안한다는뜻)
			System.out.println("0~9 이군요/");
		}
		
		int value = 6;
		
		if( (value%2==0) | (value%3==0) ) { // 똑같이 앞에꺼보면 뒤에꺼본다 
			System.out.println("2또는 3의배수군요 이군요");
		}
		
		if( (value%2==0) || !(value%3==0) ) {//똑같이앞에꺼보고 뒤에꺼본다.
			System.out.println("2또는 3의배수군요 이군요");
		}
		
		
		
		
		
		
		
		
		}
	}

}
