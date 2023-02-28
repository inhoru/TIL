package cp02.sec01;

public class 숫자와문자열결합VariableUseExample {

	public static void main(String[] args) {
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분" );
		
		int totalMinute = (hour*60) + minute;
		System.out.println("총" + totalMinute + "분");
	}

}
