# 🔖 목차 

1. [List](#1-List)<br/>
2. [원하는 인덱스 위치에 값 추가](#2-원하는-인덱스-위치에-값-추가)<br/>
3. [원하는 인덱스의 값을 수정하기](#3-원하는-인덱스의-값을-수정하기)<br/>
4. [원하는 인덱스의 값 삭제](#4-원하는-인덱스의-값-삭제)<br/>
5. [매개변수와 일치하는 값 삭제](#5-매개변수와-일치하는-값-삭제)<br/>
6. [ArrayList의 데이터들을 관리할 수 있는 메소드](#6-ArrayList의-데이터들을-관리할-수-있는-메소드)<br/>
7. [List 정렬](#7-List-정렬)<br/>
8. [LinkedList클래스이용](#8-LinkedList클래스이용)<br/>
9. [List 사용](#9-List-사용)<br/>


<br/>


# 1. List
-  List인터페이스는 Collection인터페이스를 상속받은 인터페이스다.
-  클래스를 다수 저장/관리하는 기능을 정의한다.
-  자료들을 순차적으로 나열한 자료구주로 인덱스로 관리한다.
-  중복해서 객체 저장이가능하다



## 구현클래스

- <code>ArrayList</code>,<code>LinkedList</code>,<code>Vector</code> 세가지클래스로 구현이가능하다.

  - 선형자료구조를 갖는 클래스로 배열과 유사하다.
  - 인덱스번호와 순서가 있다.
  - 삽입 삭제 메소드가 구현이되어있다.
  - 결과적으로 **클래스가 제공하는 메소드를 이용해서 데이터를 관리한다.**

## ArrayList클래스 이용하기

- 생성된 List저장소에 데이터를 저장이가능하다.
- <code>ArrayList</code>객체에 **저장가능한 데이터는 자바에서 사용하는 모든데이터가 저장이가능하다.**
- 먼저 저장을 할려면 <code>add</code>(저장데이터) 메소드를 이용해서 저장한다.

```java
list.add(true);
list.add(19);
list.add("김아무");
list.add('남');
list.add(180.5);
list.add(new Date());
```
<br/>

## 저장된 데이터 가져오기
- <code>get()</code> 메소드를 사용한다.
- ()안에 인덱스번호를 적어 저장소를 불러온다.

```java
list.add(true);
list.add(19);
list.add("김아무");
list.add('남');
list.add(180.5);

System.out.println(list.get(0));
System.out.println(list.get(1));
System.out.println(list.get(2));
System.out.println(list.get(3));
System.out.println(list.get(4));
//출력결과
//true
//19
//유병승
//남
//180.5
```

<br/>

- 여기서 주의할점이 하나있다.
- 기본적으로 ArrayList에 저장되는 데이터는 **Object자료형으로 저장이된다.**
- 대입된 실제 데이터를 사용하려면 **형변환** 을해야한다.


<br>

## 전체 데이터 접근(순회)
- List는 배열과 비슷한점이많다.
- 배열은 전체조회를 반복문으로 이용을한다.
- 방법은 여러가지가있다.

  - <code>for문</code>
  - <code>forEach</code>
  - <code>iterator()</code> 메소드


<br/>

## for문

```java
for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
```
- 우리가 자주쓰던 for반복문이다
- 한가지다른점은 List자료형의 길이는 <code>Size()</code>메소드를 이용한다.

<br/>

## forEach

```java
for(Object o: foods) {
	System.out.println(o);
}
```
- 배열에서도 사용한적 있는 녀석이다.
- 하지만 Object 는처음볼거다.
- **Object가 모든 자료형의 부모라는것만 알고있으면 이해하기쉬울거다**
- **원래 저기에 자료형이 들어와야하지만 Object는 최상위 부모이기때문에**
- **Object만쓴다면 아무 자료형이와도 반복을 돌릴수가있는것이다.**

<br/>

## iterator()

- 이방식은 Iterator객체를 이용하는것이다.
- Iterator는 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화한 것이다.
- 자세히 어떻게 동작하는지 알필요없다.
- 어떤기능인지만 알고 쓰는방법만알고 넘어가자

	- hasNext() : 읽어올 요소가 남아있는지 확인하는 메소드. 요소가 있다면 true, 없다면 false
	- next() : 다음 데이터를 반환한다

```java
animals.add(new Animal("음메에",30.5,3,"양"));
Iterator it=animals.iterator();
while(it.hasNext()) {
			
			
	System.out.println(it.next());


}
//출력결과
//Animal [name=음메에, weight=30.5, age=3, type=양]
```

<br/>

# 2. 원하는 인덱스 위치에 값 추가
- add를통해 추가하는건 이미알고있다.
- 이번엔 원하는 인덱스위치에 값을 추가할수가있다.
- 추가가된다면 알아서 자동으로 **그자리에있던값은 뒤로밀려나서 한칸씩밀린다.**
- <code>set(index, element)</code> 이런식으로 선언한다.



```java
ArrayList animals=new ArrayList();
animals.add(new Animal("뽀삐", 5.3,10,"강아지"));
animals.add(new Animal("야옹이", 4.2,5,"고양이"));
animals.add(new Animal("킥킥이", 15.3,3,"원숭이"));
animals.add(new Animal("하하", 200.2,9,"하마"));

animals.add(1,new Animal("부엉",4.3,3,"부엉이"));
		for(int i=0;i<animals.size();i++) {
			System.out.println(i+" "+animals.get(i));
		}
//출력결과
//0 Animal [name=뽀삐, weight=5.3, age=11, type=강아지]
//1 Animal [name=부엉, weight=4.3, age=3, type=부엉이]
//2 Animal [name=야옹이, weight=4.2, age=6, type=고양이]
//3 Animal [name=킥킥이, weight=15.3, age=4, type=원숭이]
//4 Animal [name=하하, weight=200.2, age=10, type=하마]
```

<br/>

# 3. 원하는 인덱스의 값을 수정하기
- 이번에는 추가인add가아닌 set 를 이용한다.
- <code>set(index, element)</code>

```java
ArrayList animals=new ArrayList();
animals.add(new Animal("뽀삐", 5.3,10,"강아지"));
animals.add(new Animal("야옹이", 4.2,5,"고양이"));
animals.add(new Animal("킥킥이", 15.3,3,"원숭이"));
animals.add(new Animal("하하", 200.2,9,"하마"));

animals.set(1, new Animal("고라",20.2,1,"고라니"));
	for(int i=0;i<animals.size();i++) {
		System.out.println(i+" "+animals.get(i));
	}
//출력결과
//0 Animal [name=뽀삐, weight=5.3, age=11, type=강아지]
//1 Animal [name=고라, weight=20.2, age=1, type=고라니]
//2 Animal [name=야옹이, weight=4.2, age=6, type=고양이]
//3 Animal [name=킥킥이, weight=15.3, age=4, type=원숭이]
//4 Animal [name=하하, weight=200.2, age=10, type=하마]
```

<br/>

# 4. 원하는 인덱스의 값 삭제
- 추가와 수정이가능하다면 삭제도가능하다.
- <code>remove(index);</code>

```java
ArrayList animals=new ArrayList();
animals.add(new Animal("뽀삐", 5.3,10,"강아지"));
animals.add(new Animal("야옹이", 4.2,5,"고양이"));
animals.add(new Animal("킥킥이", 15.3,3,"원숭이"));
animals.add(new Animal("하하", 200.2,9,"하마"));

animals.remove(1);
	for(int i=0;i<animals.size();i++) {
		System.out.println(i+" "+animals.get(i));
	}
//출력결과
//0 Animal [name=뽀삐, weight=5.3, age=11, type=강아지]
//1 Animal [name=킥킥이, weight=15.3, age=4, type=원숭이]
//2 Animal [name=하하, weight=200.2, age=10, type=하마]
```
<br/>

# 5. 매개변수와 일치하는 값 삭제
- 매개변수와 일치하는 값을 삭제하는방법이있는데
- 단 주의할점은 **대상 클래스에 equals, hasCode가 오버라이딩 되어있어야한다.**



```java
ArrayList animals=new ArrayList();
animals.add(new Animal("뽀삐", 5.3,10,"강아지"));
animals.add(new Animal("야옹이", 4.2,5,"고양이"));
animals.add(new Animal("음메에",30.5,3,"양"));

animals.remove(new Animal("음메에",30.5,3,"양"));
	for(int i=0;i<animals.size();i++) {
		System.out.println(i+" "+animals.get(i));
	}
//출력결과
//0 Animal [name=뽀삐, weight=5.3, age=11, type=강아지]
//1 Animal [name=야옹이, weight=4.2, age=6, type=고양이]

```
<br/>

# 6. ArrayList의 데이터들을 관리할 수 있는 메소드
- List를 관리하기 수월하게만드는 메소드들을 소개하겠다.

<br/>


## 특정 객체가 리스트에 포함되어있는지 확인하는 메소드
- <code>contains(Object) : boolean</code>
- **boolena 값이기때문에 맞다면 true 틀리다면 false 를 반환한다.**

```java
ArrayList animals=new ArrayList();
animals.add(new Animal("야옹이", 4.2,5,"고양이"));

boolean result=animals.contains(new Animal("야옹이", 4.2,6,"고양이"));
System.out.println(result);
//출력결과
//true
```

## 동일한 객체를 찾아서 그 인덱스를 반환해주는 메소드
- <code>indexOf(Object)</code> : 앞에서부터 동일한객체를 찾으면 그객체를 반환 아니면 -1을 반환한다.
- <code>lastIndeOf(Object)</code> : 뒤에서부터 동일한객체를 찾으면 그객체를 반환 아니면 -1을 반환한다.

```java
ArrayList animals=new ArrayList();
animals.add(new Animal("야옹이", 4.2,5,"고양이"));

boolean result=animals.contains(new Animal("야옹이1", 4.2,6,"고양이"));
System.out.println(result);
//출력결과
//false
```
<br/>

## ArrayList로 저장된 데이터를 배열로 변화해주는 메소드
- List에 저장된데이터를 배열로 변경이가능하다.
- 그반대로 List에서 배열로 변경이가능하다.

	- Arrays클래스의 <code>asList()</code>메소드를 이용하면 변경할수있음

```java
//List로변경
Object[] objArr=animals.toArray();
for(Object o : objArr)
	System.out.println(o);
System.out.println(objArr[0]);

// 배열로변경
List animals2=Arrays.asList(objArr);
for(Object o:animals2) {
	System.out.println(o);
}

```
## ArrayList에 저장된 데이터를 한번에 전체삭제
- 어렵지않다 <code>clear()</code>메소드를 사용하면된다.

```java
animals.clear();
```

## List 선언과 동시에 초기화
- List도 배열과 마찬가지로 생성과 동시에 초기화가 가능하다.
- <code>List.of()</code> 메소드를 이용한다.

	- 한가지 주의할점은
	- List.of로 생성한 list는 불변의 리스트
	- 아무리값을 추가해도 추가되지않는다
	- final이라고 생각하자

- List.of로 선언한것은 변경할수없지만
- list의 자체를 선언하면
- list 객체의 갯수를 정해놓고사용할수있다.
- 그객체의 내용은 변경이가능하다.


```java
List intList=List.of(1,2,3,4,5);
//List.of로 생성한 list는 불변의 리스트
//intList.add(6);
//intList.set(0, 100);
-------------------------------------
List animalList = List.of(new Animal(),new Animal(),new Animal());	
((Animal)animalList.get(0)).setName("햄찌");

```

<br/>


# 7. List 정렬

- 지금까지 우리는 정렬을 하기위해서
- 서로 값을 비교해서 위치를 변경했는데
- List는 메소드를 통해 정렬을 할수가 있다.

	- <code>Collection클래스에서 제공하는 sort()</code>
	- <code>List인터페이스에서 제공하는 sort()</code>

- 먼저 List sort()를 알아보자
- Comparator 인터페이스를 사용한다.

```java
//오름차순
public class FoodPriceAes implements Comparator{

@Override 
public int compare(Object o1, Object o2) {
	Food f=(Food)o1;
	Food f2=(Food)o2;
	//가격기준으로 정렬
	// 반환값설정
	// + : 두개의 객체 위치를 변경
	//-, 0 : 변경하지 않음
	//동일한값에 대한 설정
	//오름차순정렬
	if(f.getPrice()>f2.getPrice()) return +1;
	else if(f.getPrice()<f2.getPrice()) return -1;
	else return 0;
---------------------------------------------------------------
//
public class FoodPriceDecending implements Comparator {
	
	@Override
	public int compare(Object o1, Object o2) {
		Food prev=(Food)o1;
		Food next=(Food)o2;
		if(prev.getPrice()<next.getPrice()) return +1;
		else if(prev.getPrice()>next.getPrice()) return -1;
		else return 0;
	}
	
}	


```

- 보면 많이어려워보인다.
- 지금은 어떻게 쓰는지만알고있자.
- 간다히 이야기하자면 반환값에 따라 달라진다.

	- + : 두개의 객체 위치를 변경
	- -,0 : 변경하지않는다.

- 오름차순 정렬
	- 매개변수에 o1과 o2 의값을 비교해서
	- o1이 크다면 +1을 반환
	- o2가 크다면 -1을 반환
	- 0을 리턴한다면 변경값없이 그대로
- 내림차순 정렬

	- 매개변수에 o1과o2 의값을 비교해서
	- o1이 작다면 +1을 반환
	- o2가 크다면 -1을 반환
	- 0을 리턴한다면 변경값없이그대로

- **오름차순 정렬과 내림차순 정렬의 인터페이스 재정의 해서 사용한다.**

<br/>

- 이렇게 인터페이스를 만들었으면 <code>sort</code>를 사용이가능하다.

```java
//오름차순정렬
foods.sort(new FoodPriceAes());
		System.out.println("===== 정렬 후 =====");
		for(Object o : foods) {
			System.out.println(o);
		}
------------------------------------------------------------
//내림차순정렬

foods.sort(new FoodPriceDecending());
		for(Object o : foods) {
			System.out.println(o);
		}
		
```



<br/>
## 문자열 비교


- 위에쓰인 <code>compare</code>는 대소비교를 통해 +1,-1,0 을반환해서 사용했다.
- 그렇다며 문자열을 어떻게 정렬할까?

	- 예를들어 문자의 길이순으로 말이다.
	- ("가나") , ("가나다") 이문자열을 오름차순한다면  이렇게 나와야할거다.
	- 이걸해주는게 <code>compareTo()</code> 메소드다  재정의해서사용한다.

- <code>compare</code>과 똑같이 대소비교를 통해 +1,-1,0,을반환해서사용한다.
- 문자열의 숫자의 대소비교를 어떻게하지?
- 문자안에 있는 아스키 코드를 이용해서 비교를한다.

	- 문자열이 일치하는 경우 숫자비교와 똑같이 0 리턴
	- 기준값의 앞자리부터 일치하는 문자열이 포함된 경우 (기준문자열길이-비교대상문자열길이) 리턴


```java
//오름차순
public class FoodNameAscending implements Comparator{
	
@Override
public int compare(Object o1, Object o2) {
	Food prev=(Food)o1;
	Food next=(Food)o2;
	return prev.getName().compareTo(next.getName());
	}
}
-----------------------------------------------------------
//내림차순
public class FoodDecending implements Comparator{

@Override
public int compare(Object o1, Object o2) {
	return ((Food)o2).getName().compareTo(((Food)o1).getName());
	}
	
}

```
- 오름차순 과 내림차순의 차이가 뭘까?
- **바로 매개변수의 위치다**
- **매개변수 1이 앞으로 오고 compareTO괄호안에 매개변수 2가 오면 오름차순이다.**
- **매개변수 2가 앞으로 오고 compareTo괄호안에 매개변수 1이 오면 내림차순이다.**


<br/>
## 람다식

- 사실 위에처럼 따로 인터페이스르 재정의 하지않고 
- **람다식 표현방법**을 사용한다면 코드를 매우 줄일수가있다.

```java
foods.sort((o,o2)->((Food)o).getName().compareTo(((Food)o2).getName()));
```
- 이한줄로 위에썻던 모든것들이 정리가된다.
- 람다식표현 꼭 익혀두자.



 

<br/>

# 8. LinkedList클래스이용
- List인터페이스를 구현한 클래스다.
- 사용방법은 ArrayList클래스와 유사하다.

```java
LinkedList linkList=new LinkedList();
		
linkList.add("김아우");
linkList.add("강태풍");
linkList.add("강바람");

linkList.forEach((e)->System.out.println(e));

System.out.println(linkList.getFirst());
System.out.println(linkList.getLast());
		
//출력결과
//김아우
//강태풍
//강바람

//김아우
//강바람

```

- <code>getFirst()</code> 메소드를 통해 첫번째 출력한다.
- <code>getLast()</code> 메소드를 통해 마지막 출력한다.

- 기본적으로 데이터 저장 , 출력 : ArrayList사용
- 저장된 데이터에 조작이 많을때 : LinkedList를 사용


<br/>


 
# 9. List 사용
- List를 사용해서 저장된 내용에대한 분기처리도가능하다.
- 예를 들어 음식의 이름 가격 종류 를 List에 저장햇다고하다.

  - 전체 음식의 타입, 이름, 가격만 출력
  - 전체 음식중 5000원 이하인 음식만 타입 이름 가격 출력

- 이렇게 사용자가원하는 대로 분기처리해서 사용이가능하다.


<br/>

## 전체 음식의 타입, 이름, 가격만 출력

```java
ArrayList foods=new ArrayList();
		
foods.add(new Food("돈까스",10000,"일식",new Date()));
foods.add(new Food("초밥",2000,"일식",new Date()));
foods.add(new Food("컵라면",1400,"한식",new Date()));
foods.add(new Food("샐러드",12000,"건강식",new Date()));

for(int i=0;i<foods.size();i++) {
			Food f1=(Food)foods.get(i);
			System.out.println(f1.getType()+" "
			+f1.getName()+" "+f1.getPrice());
		}
//출력결과
//일식 돈까스 10000
//일식 초밥 2000
//한식 컵라면 1400
//건강식 샐러드 12000

```

- 위에 코드에서 한까지 의문인점이 있을거다
- <code>Food f=(Food)foods.get(1);</code> 이부분은 왜 Food로 형변환을 한걸까?

  - 이유는 간단하다 <code>Object</code>로 받기때문이다
  - **우리는 Food클래스에 getName()가 필요하기때문에 food클래스에접근하려면 형변환을 할수밖에없다.**
  - 그래서 형변환후 Food에접근해서 get()을 가져온거다.

<br/>

## 전체음식중 가격이 5000천원이하인 음식의 타입, 이름, 가격을 출력하기

```java
ArrayList foods=new ArrayList();
		
foods.add(new Food("돈까스",10000,"일식",new Date()));
foods.add(new Food("초밥",2000,"일식",new Date()));
foods.add(new Food("컵라면",1400,"한식",new Date()));
foods.add(new Food("샐러드",12000,"건강식",new Date()));

for(int i=0;i<foods.size();i++) {
			Food f1=(Food)foods.get(i);
			if(f1.getPrice()<=5000) {
				System.out.println(f1.getType()
						+" "+f1.getName()
						+" "+f1.getPrice());
			}
	}  
//출력결과
//일식 초밥 2000
//한식 컵라면 1400
```

- 위와 똑같이 Food로 형변환을해서 get()을가져온후 if문을 사용해서
- 사용자가 원하는 값만 출력을 할수가있다.

<br/>




    
    
	
