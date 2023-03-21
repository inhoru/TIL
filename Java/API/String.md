# 🔖 목차

1. [String](#1-String)<br/>
2. [StringBuffer](#2-StringBuffer)<br/>
3. [StrinfBuilder](#3-StrinfBuilder)<br/>
4. [StringTokenizer](#4-StringTokenizer)<br/>


<br/>

> 자바에서 문자열에 대한 클래스는 3가지가 있다.
> 
> String, StringBuffer, StringBuilder
> 
> String : 클래스지만 기본 자료형처럼 사용하게 설정되어 있다.
> 
> StringBuffer, StringBuilder : 클래스 사용방식으로 문자열을 다룰수있다.
> 
> String은 불변의 문자열 -> 수정이 불가능하다.
> 
> StringBuffer, StringBuilder : 가변의 문자열 -> 수정이 가능하다.
> 

<br/>

# 1. String
## 우리가 많이쓰는것들만 추려서 몇가지를 소개하겟다.

<br/>

- String.concat("문자열값") : 두개의 문자열을 합쳐주는 메소드

```java
String test = "abcd ";
	test = test.concat("아자아자 화이팅!"); // +=연산과 동의하다.
	System.out.println(test);
  //출력결과
  //abcd아자아자화이팅
  ```
  
  -  boolean String contains("문자열")

  	- 문자열에 매개변수로 전달된 문자열이 포함되어있는지 확인해주는 기능

```java
if (test.contains("64")) {
			System.out.println("응 64포함됨");
		};
```

- int indexOf("문자열")
	- 문자열에 매개변수로 전달된 문자가 있는지 확인하고 그 자리수(인덱스번호)를 반환해줌

```java
System.out.println(test.indexOf("D"));
System.out.println(test.indexOf("팅"));
// 중복값이 있을때에는 문자가2개일때 맨처음꺼를 반환한다.
// 단독으로 사용하는경우는 많이없다. 다른 메소드와 연결해서 많이 사용
System.out.println(test.indexOf("아자"));
// 문자에 포함되있지않으면 -1 이나온다
System.out.println(test.indexOf("김아무"));
// lastIndexOf("문자열");
// ?
System.out.println(test.lastIndexOf("아자"));
// 파일명

// date.txt, test.exe
test = "date.test.exe";
System.out.println(test.lastIndexOf("."));
System.out.println(test.indexOf(".", test.indexOf(".") + 1));
```

- String[] split(String)

	- 특정구분자(기호)로 구분할 수 있는 문자열을 구분할 수 있는 배열로 만드는것

```java
test = "김아무,19,경기도시흥시,남";
String[] result = test.split(",");
System.out.println(result[0]);
System.out.println(result[1]);
for (String d : result) {
	System.out.println(d);
}
test = "김아무,19,경기도시흥시,남\n김무무,29,경기도구호시,여\n김지우,26,서울시호로구,여";
String[] persons = test.split("\n");
Person[] personObj = new Person[persons.length];
int i = 0;
for (String p : persons) {
	String[] person = p.split(",");
	Person pobj = new Person(person[0], 
			Integer.parseInt(person[1]), 
					person[2], 
						person[3].charAt(0));
	personObj[i++] = pobj;
	System.out.println("이름 : " + person[0]);
	System.out.println("나이 : " + person[1]);
	System.out.println("주소 : " + person[2]);
System.out.println("성별 : " + person[3]);
			
}
		
for(Person p : personObj) {
	System.out.println(p);
}
```
- String replace("찾을값","대체할값")  

	- 특정문구를 대체문구로 교체하는 것

```java
test="나는 코딩을 정말 못해!";
String testStr=test.replace("못해","잘해");
System.out.println(test);
System.out.println(testStr);
```
- String String.join("구분자",배열) 

	- 배열을 특정구분자로 문자열로 만들어준다.

```java
String [] testArr= {"김지우","김무무","강태풍","강나라","강바람"};
test=String.join("->", testArr);
System.out.println(test);
```
- String subString(시작인덱스번호[,끝인덱스번호])

	- 시작인덱스부터 끝인덱스까지 문자열을 잘라내는 기능

```java
test="수업 좀 잘하세요";
testStr=test.substring(4);
System.out.println(testStr);
//시작은 포함 끝나는건 불포함
testStr=test.substring(2,4);
System.out.println(testStr);
testStr=test.substring(test.indexOf("잘"));
System.out.println(testStr);
test="test.png";
testStr=test.substring(test.indexOf(".")+1);
System.out.println(testStr);
testStr=test.substring(0,test.indexOf("."));
System.out.println(testStr);
```

- toUppercase()/toLowerCase()

	- 대문자를입력하던 소문자를입력하던 자동으로 변경해준다.

```java
test="AbdDefG";
testStr=test.toUpperCase();
System.out.println(testStr);
testStr=test.toLowerCase();
System.out.println(testStr);
```

- String trim() : 문자열의 양쪽 공백을 제거해주는 메소드

```java
test="          안녕하세요";
System.out.println(test);
testStr=test.trim();
System.out.println(testStr);
		
//valueOf() : 기본자료형을 String으로 변환해주는 기능
int age = 19;
//test=(String)age;
test=String.valueOf(age);
System.out.println(test);
test=String.valueOf(180.5);
System.out.println(test);
```

<br/>

# 2. StringBuffer
## 데이터를 수정, 저장하기 가능 원본값을 수정한다.
- 선언방법은 어렵지않다

```java
StringBuffer testSb = new StringBuffer();
System.out.println(testSb);
```
- 간단하다.


<br/>

- append("문자열") : 문자열을 추가하는메소드

```java
StringBuffer testSb = new StringBuffer();
System.out.println(testSb);
System.out.println(testSb.length());
testSb.append("여러분 한시간 남았어요!");
System.out.println(testSb);
System.out.println(testSb.length());
testSb.append(" 우리 힘냅시다! 보강은 어떻게 할까요?");
System.out.println(testSb);
System.out.println(testSb.length());
```

- insert(인덱스번호, 문구) : 특정위치에 문구를 추가하는것

```java
testSb.insert(3, "곧 ");
System.out.println(testSb);
testSb.insert(testSb.indexOf("!"),"????");
System.out.println(testSb);
```

-  delete(시작인덱스, 끝인덱스) : 해당위치에 있는 값을 삭제

```java
testSb.delete(3, 5);
//앞에꺼는 포함 뒤에있는건 포함이안됨
System.out.println(testSb);
testSb.delete(0, 3);
System.out.println(testSb);
		
// deleteCharAt(인덱스번호) : 한글자만 삭제하는 기능
testSb.deleteCharAt(1);
System.out.println(testSb);
```

- setCharAt(인덱스번호, "수정할문자") 

	-  해당 인덱스번호에서 수정할 문자

```java
testSb.setCharAt(1, '공');
System.out.println(testSb);
```
- length() 문자열의 길이를 출력

```java
System.out.println(testSb.length());
```

- replace(시작번호,끝번호,"변경할문구")

	- 원본값 수정

```java
testSb.replace(0, 3, "여러분 힘내요!");
System.out.println(testSb);
```

- reverse()
	- 문자열 반전

```java
estSb.reverse();
System.out.println(testSb);
```

<br/>

# 3. StrinfBuilder
- StringBuffer==StrinfBuilder동일하다
- 단지 하나의차이는 스레드세이프티 기능의차이다.

```java
StringBuilder testSb2=new StringBuilder();
testSb2.append("테스트");
System.out.println(testSb2);
```
- 이렇게 똑같이 만들수가 있다.

<br/>

## String과 StringBuffer의 호환성
```java
test=new String(testSb);

testSb= new StringBuffer(test);
```

- 뉴스트링을 해서 매개변수로 넣어주면된다.
- 이렇게 생성자를 통해 서로 호환이가능하다.

<br/>

# 4. StringTokenizer
- String에서 제공하는 split()메소드와 유사한 기능이다.

```java
test="김아무,최무무,이무지,최무영";
//첫번째에 물자열 test를적고 두번째에는 구분자 ,를적는다
// , 기준으로 출력이된다.
StringTokenizer st =new StringTokenizer(test,",");
//전부 호출할때 까지 반복한다 한번호출되면 그저장소는 사라진다.
while(st.hasMoreElements()) {
	System.out.println(st.nextElement());
	}
}	

```

- 이런식으로 사용이가능하다.
- 나중에 컬렉션 프레임워크에서 이런식으로 사용할거다 알아두자.












