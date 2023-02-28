package sec07.exam03;

public class 와일문예시 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		
		while(i<=100) {//i가 101이될때까지 반복 101이되면 와일문 바깥으로감 
			sum += 1;//1부터+1해서더하는 연산식
			i++;
		}
	
	System.out.println("1~" +  (i - 1)  + "합:" + sum);//i가 101로밖으로나왓으니 -1해준다.
		
		
	}

}
