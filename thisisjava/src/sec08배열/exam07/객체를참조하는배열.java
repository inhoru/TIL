package sec08배열.exam07;

public class 객체를참조하는배열 {

	public static void main(String[] args) {
		
		String[] strArray = new String[3];
		strArray[0] = "Java";
		strArray[1] = "Java";
		strArray[2] = new String("Java");
		
		System.out.println(strArray[0] == strArray[1]); //객체비교
		System.out.println(strArray[0] == strArray[2]); //객체비교인덱스객체비교
		System.out.println(strArray[0].equals (strArray[2])); //equals문자열 비교 
		
		
	}

}
