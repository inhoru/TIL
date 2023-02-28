package sec04.exam4;

public class 키보드변수저장while끝내기 {


		public static void main(String[] args) throws Exception {
		
		int keyCode;
		//while는 가로안이 트루가될경우까지 계속해서 반복해서실행함 이걸반복문이라함 
		while(true) {
			keyCode = System.in.read();//계속해서 리드를읽는중 while
			System.out.println("keyCode:" + keyCode);
			if(keyCode == 113) {//if문 만약에 113(q)을 입력했다면 멈춰라 
				break;
				
			}
		}

		System.out.println("종료");
		
		//read는 하나밖에못읽음 a,b,가,나, 그래서스캐너사용
		

		
		
		
		
	}

}
