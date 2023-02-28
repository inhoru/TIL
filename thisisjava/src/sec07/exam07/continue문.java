package sec07.exam07;

public class continue문 {

	public static void main(String[] args) {
		//for ,while, do-while에서만사용
		//for의증감식이거나 while do와일문의 조건식이동
		//주로 if문과함께사용
		for(int i = 1; i<=10; i++) {
			if(i%2 != 0) {//2로나눈 나머지가 0이아니냐?=홀수냐? 라는뜻 !는 부정 을뜻함
				continue;//홀수가나오면 for문의 증감식으로다시간다(1++)
			}
			System.out.println(i);
		}
	}

}
