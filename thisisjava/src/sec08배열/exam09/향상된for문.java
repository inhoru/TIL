package sec08배열.exam09;

public class 향상된for문 {

	public static void main(String[] args) {
	
		int[] scores = {95, 71, 84, 93, 87};
		
		int sum= 0;
		for(int score : scores) { //scores값을 앞에서부터 끝까지 더하기를한다 그리고 빠져나간다. 더욱간결하게 바꿀수있다.
			sum += score;
		}
		System.out.println("점수총합=" + sum);
		
		double avg = (double) sum / scores.length;  //sum은정수니간 더블로 강제타입변환 소수로변환후 나누기
		System.out.println("점수평균=" + avg);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
