package sec06.exam01;

public class if문 {

	public static void main(String[] args) {
		//if문 조건식 결과에 따라 블록 실행여부가 결정된다
		//조건식에 올수있는요소는 true/false값을 산출하는연산식(비교,논리)
		//boolean타입변수
		//{ 괄호 블록은 조건식이 true가될때 실행(실행할문장이 하나뿐인겨우 생략가능)
		
		
		int score = 90;
		 
		 if (score>=90) {
			System.out.println("점수가 90보다 큽니다.");//if가 true이기때문에 실행
			System.out.println("등급은 A 입니다.");
			 
		}

		 if (score< 90) 
				System.out.println("점수가 90보다 작습니다.");//{ 중괄호가없으면 바로아래있는것 하나만 실행한다. 
				System.out.println("등급은 B 입니다.");//위에께 false여서 밑에꺼를 출력
				 
			
	

	}

}