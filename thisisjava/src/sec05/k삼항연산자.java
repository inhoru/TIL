package sec05;

public class k삼항연산자 {

	public static void main(String[] args) {
		//3개의 피연산자를 필요로하는 연산자
		//? 앞의 조건식에따라 콜론앞뒤의 피연산자를 선택
		
		int score = 85;
		char grade = (score > 90) ? 'A' : ((score>80) ? 'B' : 'C');//?앞에있는 가 true면 :앞에있는걸 저장 false면:뒤에있는걸 저장해라
		System.out.println(grade);
	}

}
