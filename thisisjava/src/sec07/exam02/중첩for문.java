package sec07.exam02;

public class 중첩for문 {

	public static void main(String[] args) {
	
		for (int m=2; m<=9; m++) {//구구단 m2로시작해서n1부터 9까지 끝나면 다시 m3으로해서 1부터9까지 구구단예시
			System.out.println("***" + m +"단 ***");
			for(int n=1; n<9; n++) {
				System.out.println(m + " x " + n + " = " + (m*n));
			}
		}

	}

}
