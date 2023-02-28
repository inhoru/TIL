package sec08배열.exam04;

public class 배열의속성length {

	public static void main(String[] args) {
		
		int[] scores = {83, 90, 87};
		scores[1] = 100; //1의값을바꾸고싶을떄이렇게바꾼다.
		System.out.println("scores[0]" + scores[0]);
		System.out.println("scores[1]" + scores[1]);
		System.out.println("scores[2]" + scores[2]);
	
		int sum = 0;
		for(int i=0; i<scores.length; i++) {//i<3대신 스콜스 랜스 써도된다.
			sum += scores[i];
			
		}
	System.out.println("총합:  " + sum);
	double avg = (double) sum / scores.length;//평균구하기 더블로 강제변환후 나누기3//나누기3대신 랜스써도됨
	System.out.println("평균:" + avg);
	
	

	}

}
