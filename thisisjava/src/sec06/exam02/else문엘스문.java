package sec06.exam02;

public class else문엘스문 {

	public static void main(String[] args) {
		 //if문을 else문블록과함께사용
		//조건식의 결과에 따라 실행 블록선택
		//if문의 조건식 true이면 if문실행
		//if문의 조건식 false이면 else실행
		
		int score = 85;
		
		if(score>=90) {//false이기에 출력안함
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
		} else {//if가false이기에 else엘스 출력
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B 입니다.");
		}//
		System.out.println("종료");
		
	
		
	}

}
