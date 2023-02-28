package sec04.exam3;

public class 키보드변수저장while반복문 {
											//리드라는매소문사용할려면 예외처리가필요함
	public static void main(String[] args) throws Exception {
		
		int keyCode;
		//while는 가로안이 트루가될경우까지 계속해서 반복해서실행함 이걸반복문이라함 
		while(true) {
			keyCode = System.in.read();//계속해서 리드를읽는중 외일이
			System.out.println("keyCode:" + keyCode);
	}

}

}