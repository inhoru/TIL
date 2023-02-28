package sec10객체지향프로그램.exam06;

public class Koreanexample {

	public static void main(String[] args) {
		
		Korean k1 = new Korean("박자바", "011225-1234567");
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		System.out.println("---------");
		Korean k2 = new Korean("감자바", "031242-1234568");
		System.out.println(k2.nation);
		System.out.println(k2.name);
		System.out.println(k2.ssn);
		
		

	}

}
