package sec05;

public class c논리부정연산자 {

	public static void main(String[] args) {
	//true를false로, false를true로변경 하는것
	
		boolean play = true;
		System.out.println(play);
		
		play = !play;//false로바뀜
		System.out.println(play);

		play = !play;//다시true로바뀜
		
		System.out.println(play);
	}

}
