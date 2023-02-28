package sec08배열.exam06;

public class 이차원배열 {

	public static void main(String[] args) {
		// int[][] scores = new int[2][3]; 행렬구조 [2]행수[3]열수
		//scores[1][1]=8 1열1행에 8을저장
                       //     0   1    0   1		
		//int[][] scroes = { {95.88}, {92,96} }  
		//                      0         1 
		// int score = scrores[0][0];  =  95         이렇게 값을 이용한 2차원 배열생성도 가능하다.
		// int score = scrores[1][1];  =  96 
		int[][] mathScores = new int[2][3];
		
		
		mathScores[1][2] = 10;
		
		
		for(int i=0; i<2; i++) {
			for(int k=0; k<3; k++) {
				System.out.println("mathScores[" + i + "][" + k + "]="
						+ mathScores[i][k]);
			}
		}
		
		System.out.println();
		
		int[][] englishScores = new int[2][];//계단식구조 행수만주고 배열객체를 만듬  변수선언때 대입할떄 만들어짐 
		englishScores[0] = new int[2]; // 0행수에 길이2짜리 대입 
		englishScores[1] = new int[3]; // 1행수에 길이3짜리 대입
		for(int i=0; i<2; i++) {
			for(int k=0; k<englishScores[i].length; k++) {//2행이라서 3열을표현못함 그래서 랜스라는속성을줌
				System.out.println("englishScores[" + i + "][" + k + "]="
						+ englishScores[i][k]);
					
			}
		}
		
	System.out.println();
	                  //     0          1
	int[][] javaScores = { {80,90}, {92,96,58} };  //값의목록으로 행렬루조 계단식구조만들기가능
	for(int i=0; i<2; i++) {
		for(int k=0; k<javaScores[i].length; k++) {//i가 0이면 k<2,i가 1이되면 k<3 
			System.out.println("javaScores[" + i + "][" + k + "]="
					+ javaScores[i][k]);
				
		}
	}
		
		
		
		
		
	}

}
