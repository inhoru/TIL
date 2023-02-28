package sec06.exam4;

public class 스위치스트링 {

	public static void main(String[] args) {
//케이스값에 문자열도올수있다.
		String position = "과장";

		switch (position) {
		case "부장":
			System.out.println("700만원");
			break;
		case "과장":
			System.out.println("500만원");
			break;
		default:
			System.out.println("300만원");

		}

	}

}
