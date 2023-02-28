package sec06.exam4;

public class switch문노브레이크케이스 {
	public static void main(String[] args) {
		//8<= ...<12(8+4) 사이에 정수얻기
		int time = (int)(Math.random()*4) + 8;//0에서 4사이에 정수 0,1,2,3만나오고 거기에8더하기
		System.out.println("[현재시간: " + time + " 시]");
		
		switch(time) {
		case 8 ://브레이크가없기떄문에 8이나오면 밑에전부출력한다.
			System.out.println("출근합니다.");
		
		case 9 ://8빼고 전부 출력
			System.out.println("회의합니다.");
		
		case 10 ://89뺴고 전부출력
			System.out.println("업무합니다.");
		
		default://이것만출력
			System.out.println("외근을나갑니다.");
		}
				
		
		
		
		
		
		
		
	}
}
