package sec05;

public class b증감연산자2 {

	public static void main(String[] args) {
		//증감 연산자 boolean 타입외 모든 기본 타입 피연산자에 사용 가능
		//증가 연산자가 다른연산자랑 함께할경우 연산자위치에따라 결과가 다름
		//++x(연산자가 피연산자앞에있을때 먼저 증감연산자를하고 값계산
		//x--(연산자가 뒤에있을때 값을계산한후에 증감연산자 적용
		int x= 10;
		int y = 10;
		int z;
		
		System.out.println("--------------------------------");
		x++;//연산자하나만잇기에 그냥+1 x=11
		++x;//그다음에x에다시 x+1=12
		System.out.println("x=" + x);

		System.out.println("--------------------------------");
		y--;//연산자하나만잇게에 그냥 -1 y=9
		--y;//그다음에y다시 y-1=8
		System.out.println("y=" + y);
		
		System.out.println("--------------------------------");
		z = x++; //대입연산자(=)랑 같이잇으니 x를z에 저장하고 그다음에 x에 1을넣는다
		System.out.println("z=" + z); //x=12니간 z=12
		System.out.println("x=" + x); //x=12인데 +1을하니 x=13
		
		System.out.println("--------------------------------");
		z = ++x;//대입연산자랑(=)랑 같으니 증감먼저계산하고 값계산
		System.out.println("z=" + z); //x=13이니+1하면 x=14
		System.out.println("z=" + x); //x=14이니 z=14

		System.out.println("--------------------------------");
		z = ++x + y++; //다른연산자랑함께다.
		System.out.println("z=" + z);//x에1을더한후 y랑더하면 z다. x=14+1=x y=8 이니간 x=15,y=8  x+y=23
		System.out.println("x=" + x);//x는 14+1 =15
		System.out.println("y=" + y);//y는 연산자가 뒤에잇으니 8+1 =9
	}

}
