package sec08배열.exam08;

public class 배열복사 {

	public static void main(String[] args) {
		
		int[] oldIntArray = {1, 2, 3 };
		int[] newIntArray = new int[5];
		
		for(int i=0; i<oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];//원본 i 를읽어서 새로운 값i에저장해라
			}
		
		for(int i=0; i<newIntArray.length; i++) {
			System.out.println(newIntArray[i] + ", ");
			}
	}

}
