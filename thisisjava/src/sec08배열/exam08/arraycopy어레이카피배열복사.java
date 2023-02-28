package sec08배열.exam08;

public class arraycopy어레이카피배열복사 {
	public static void main(String[] args) {
		
		String[] oldStrArray = { "java", "array", "copy" } ;
		String[] newStrArray = new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);//배열복사문
		//                원복배열,0부터시작,대상배열,0부터시작,몇개까지 복사할건지
		for(int i=0; i<newStrArray.length; i++) {
			System.out.println(newStrArray[i] + ",");
		}
	}
}
