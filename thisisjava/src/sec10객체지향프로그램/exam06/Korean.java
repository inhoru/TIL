package sec10객체지향프로그램.exam06;

public class Korean {
	//Field
	String nation = "대한민국";
	String name;
	String ssn;
	
	//constructor
	Korean(String n, String s) { 
		name = n;
		ssn = s;
		
		//매개변수가 필드이름과동일하면
		//String name;
		//Korean(String name, String s) { 
		//this.name = name; 디스쩜을 붙여준다.
	}
	
}
