package sec07.exam05;

public class break문 {

	public static void main(String[] args) {
		// for,while,do-while,switch문의 중지할때사용
		//주로 if문과 함께사용
		//반복문이 중첩되어잇을경우 Label을 이용해서 바깥 반복문 빠져나감
		//주사위를던져서 눈이 6이나오면 멈추는 예제
		while(true) {
			int num = (int)(Math.random()*6) + 1;
			System.out.println(num);
			if(num==6) {
				break;
			}
				
		}
			System.out.println("프로그램 종료");
		

	}

}
