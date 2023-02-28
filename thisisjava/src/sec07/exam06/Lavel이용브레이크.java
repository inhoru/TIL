package sec07.exam06;

public class Lavel이용브레이크 {

	public static void main(String[] args) {
		// Lavel 은 중첩반복문 완전히종료시키고싶을때 쓰는것

		Level: for (char upper = 'A'; upper <= 'Z'; upper++) {
			for (char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + "_" + lower);
				if (lower == 'g') {
					break Level;
				}
			}
		}
		System.out.println("프로그램종료");
	}

}
