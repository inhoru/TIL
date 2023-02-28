package sec08배열.exam03;

public class 배열생성 {

	public static void main(String[] args) {
		/*데이터를 연속된 공간에 나열 하고 각데이터에 인덱스(0부터시작하는번호)
		 부여한 자료구조
		 같은타입의 데이터만 저장가능
		 한번생선된 배열은 길이를 늘리거나 줄일수 없음

		 타입[] 변수 = (값0, 값1, 값2,)
		 SCORES[1]=100 1의값을바꾸고싶을떄이렇게바꾼다.*/

		int[] scores = {83, 90, 87};
		scores[1] = 100; //1의값을바꾸고싶을떄이렇게바꾼다.
		System.out.println("scores[0]" + scores[0]);
		System.out.println("scores[1]" + scores[1]);
		System.out.println("scores[2]" + scores[2]);
	
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += scores[i];//sum=sum+scores[i]
			
		}
	System.out.println("총합:  " + sum);
	double avg = (double) sum / 3;//평균구하기 더블로 강제변환후 나누기3
	System.out.println("평균:" + avg);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
