package sec08배열.exam03;

public class 배열생성2 {

	public static void main(String[] args) {

		// int[] scores;
		// scores = {83, 90, 87 };이런식으로 변수를 선언한후에 값의목록을 선언하는건 컴파일오류가생긴다.

		int[] scores;
		scores = new int[] { 83, 90, 87 };// 변수를선언한후 쓸려면 뉴를 붙이고 값을선언해야함
		int sum1 = 0;
		for (int i = 0; i < 3; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합:" + sum1);

		int sum2 = add(new int[] { 83, 90, 87 });//여기로 
		System.out.println("총합:" + sum2);

	}

	public static int add(int[] scores) {// add매소드 결과값을 돌려준다
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += scores[i];
		}
		return sum;//되돌린다.

	}

}
