package sec06.exam3;

public class ifelseifelsea문 {

	public static void main(String[] args) {
		// 조건식이 여러개인 if문
		// 처음 if문의 조건식 false일경우 다른조건식의 결과에 따라 실행 블록 선택
		// if블록 끝에 else if문 추가
		// else if문 개수는 제한이없다.

		int score = 75;

		if (score >= 90) {
			System.out.println("점수가100~90 입니다.");
			System.out.println("등급은 A 입니다.");
		} else if (score >= 80) {//true이기에 출력x
			System.out.println("점수가90~80 입니다.");
			System.out.println("등급은 B 입니다.");
		}else if (score>=70) {//true이기에 출력x
			System.out.println("점수가80~70 입니다.");
			System.out.println("등급은 C 입니다.");
		}else {//전부false일경우에 출력한다
			System.out.println("점수가70~60 입니다.");
			System.out.println("등급은 D 입니다.");
		}

	}

}
