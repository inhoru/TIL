package sec06.exam3;

public class 이프엘스문예제 {
	public static void main(String[] args) {
		//Math.random();0.0(0을포함하고)에서 1.0미만(1은포함하지않는다.)사이에 임의의 실수를 출력시켜준다
		//System.out.println((int)(Math.random()*6)); 0.0사이에서6.0사이에서만나온다 정수로바꿀려면 강제타입변한 int한다
		
		int num = (int)(Math.random()*6) + 1 ;
		
		if(num==1) {
			System.out.println("1번이나왔습니다");
		} else if(num==2) {
			System.out.println("2번이나왔습니다");
		} else if(num==3) {
			System.out.println("3번이나왔습니다");
		} else if(num==4) {
			System.out.println("4번이나왔습니다.");
		} else if(num==5) {
			System.out.println("5번이나왔습니다.");
		} else {
			System.out.println("6번이나왔습니다.");

		
		
		
		
		
		
		}
		
	}
}
