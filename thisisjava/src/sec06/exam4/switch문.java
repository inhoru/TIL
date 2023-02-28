package sec06.exam4;

public class switch문 {

	public static void main(String[] args) {
		//switch문
		//변수가 어떤값을 갖는가에따라 실행문선택
		//같은기능의if문보다 코드가 간결
		
		int num = (int)(Math.random()*6) + 1 ;
		
		switch(num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		default://변수값이 모두아닐경우 출력
			System.out.println("6번이 나왔습니다.");
			//break;
			
		}
	}

}
