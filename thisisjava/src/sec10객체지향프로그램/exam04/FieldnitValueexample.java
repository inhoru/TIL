package sec10객체지향프로그램.exam04;

public class FieldnitValueexample {

	public static void main(String[] args) {
		
		FieldnitValue fiv = new FieldnitValue();//FieldnitValue에서 가져옴<이게객체선언 그래야사용가능
		System.out.println(fiv.byteField);//바이트에초기값0 
		System.out.println(fiv.charField);///u0000유니코드가나옴(빈공백)
		System.out.println(fiv.shortField);//초기값0 
		System.out.println(fiv.intField);//초기값0 
		System.out.println(fiv.longField);//초기값0 
		System.out.println(fiv.booleanField);//초기값false
		System.out.println(fiv.floatField);//초기값0.0
		System.out.println(fiv.dounleField);//초기값0.0
		System.out.println(fiv.arrField);//null
		System.out.println(fiv.strField);//null
	}

}
