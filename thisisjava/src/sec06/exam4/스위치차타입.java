package sec06.exam4;

public class 스위치차타입 {

	public static void main(String[] args) {
		//차타입 스위치문
		
		char grade = 'A';
		
		switch(grade) {
			case 'A' : //만약 A라면 값이없으니 그대로 내려가서 밑에께출력된다.
			case 'a' :
				System.out.println("우수회원입니다.");
				break;
			case 'B' ://만약 B라면 값이없으니 그대로 내려가서 밑에께출력된다.
			case 'b' :
				System.out.println("일반 회원입니다.");
				break;
			default://둘다아니라면 이게출력
				System.out.println("손님입니다.");
				
				
				
		}
	}

}
