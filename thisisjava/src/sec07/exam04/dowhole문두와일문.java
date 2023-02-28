package sec07.exam04;

public class dowhole문두와일문 {

	public static void main(String[] args) {
		//조건식에의해반복실행하는점은 와일문과같다
		
		int sum = 0;
		int i = 1;
		
		do {
			sum += 1;
			i++;
		} while(i<=100);
	
	System.out.println("1~" +  (i - 1)  + "합:" + sum);//i가 101로밖으로나왓으니 -1해준다.
		
		
	
	}

}
 