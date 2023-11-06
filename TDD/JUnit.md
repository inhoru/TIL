

# 1. JUnit
- JUnit이란 자바 프로그램의 단위 테스트를 위한 대표적인 프레임 워크이다.

<br/>

## 특징
- "@Test"메소드가 호출될 때마다 새로운 인스턴스를 생성하여 독립적 테스트를 수행한다.

- assertXXXX 메소드로 테스트 케이스의 수행 결과를 판단한다.

- 어노테이션을 제공하여 매우 쉽고 간결하게 테스트 코드를 작성하여 실행 가능하다.

- 현재 가장 최신버전은 JUnit 5 이다.

<br/>

## 예시

```
public class SomeTest{
	
    //합계테스트 / 유닛테스트1
	@Test
    public void testSum(){
    	int result = 0;
        
        Something some = new Somthing();
        result = som.sum(10);
        assertEquals(55, result);
        
    //정렬테스트 / 유닛테스트2
    @Test
    public void testSort(){
    	int[] a = {44, 33, 66, 22, 55, 11};
        int[] b = {11, 22, 33, 44, 55, 66};
        
        Somthing some = new Somthing();
        some.bubble_sort(a);
        assertArrayEquals(b, a);
    }
    
}
```
- 테스트는 준비 -> 동작 -> 확인 과정을 거친다.
- @Test : 단위 테스트 메소드임을 나타낸다.
- * 준비(Arrange) : 테스트를 수행하기위한 테스트 환경 조성 부분
- 동작(Act) : 실제 테스트 대상 기능 실행
- 확인(Assert) : 동작의 실제 실행 결과와 기대 결과를 비교 확인

<br/>

# 2. 어노테이션
- 테스트에 쓰이는 어노테이션을 소개하겟다

- @Test : 해당 메소드가 테스트 대상 메소드임을 의미

- @Test(timeout=10) : 테스트 메소드 수행 시간이 10 millisecond를 넘기면 실패

- @Test(expected=RuntimeException.class) : RuntimeException이 발생하면 테스트 성공, 아니면 실패

- @Before 메소드 : 각 테스트 메소드에서 공통적으로 실행해야 할 작업 포함, 테스트 메소드가 실행되기 전에 실행됨

- @After 메소드 : 각 테스트 메소드의 실행이 완료된 후에 동일한 마무리 작업을 수행할 경우 사용, 테스트 메소드가 실행된 후에 실행됨

- @BeforeClass 메소드 : static 메소드이며, 모든 테스트 메소드가 동작하기 전 공통적으로 실행해야 하는 작업 수행

- @AfterClass 메소드 : static 메소드이며, 모든 테스트 메소드가 생행되고 난 후에 한번 실행하는 메소드

<br/>

## 반복테스트 어노테이션

- 동일한 기능을 다른 값으로 여러번 테스트를 실행해야 하는 경우가 있을 것이다.

- 그때에는 어떻게 해야하는지 살펴보자.

- @Runwith(Parameterized.class) 사용
- @Parametes를 통하여 데이터 등록
- 생성자 생성
- 테스트 코드 작성
- 말로만 보았을 때, 이해가 안간다.
- 코드를 통해 확실히 보자!

<br/>

## 예시

```
@RunWith(Parameterized.class)
public class AnotherTest{
	private int expected;
    private int value;
    
    @Parameters
    public static Collection getParameters(){
    	return Arrays.asList(new Object[][]{
        	{4, 10},
            {-200, -10}
            });
        }
        
        public AnotherTest(int expected, int value){
        	this.expected = expected;
            this.value = value;
        }
        
        @Test
        public void testSum(){
        	Something some = new Something();
            int result = some.sum(value);
            assertEquals(expected, result);
        }
}
```
