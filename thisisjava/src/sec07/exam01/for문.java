package sec07.exam01;

public class for문 {
	public static void main(String[] args) {
		
	int sum = 0;
	
	for(int i=1; i<=100; i++) {//i가 100이될때까지 i는 +1을더해서 반복하라
		sum += i;//변수대입연산자 sum= sum + 1 
		//1=0+1
		//3=1+2
		//6=3+3
		//인런식으로 변수대입연산자를이용해서 i가100이될때까지 한다.
		
	}
	
		System.out.println("1~100합:" + sum);
	}
}
