# 🔖 목차
1.
2.
3.

<br/>

# 1. File

- java 코드로 file를 다룰 수 있는 file클래스에대해 알아보자.
- file은 하드에 저장되어있는 걸 말하는거다.
- 그래서 그파일과 연동해서 file을 관리할수가있다.


## File클래스 생성하기

- <code>File</code> 클래스는 항상 매게변수 있는 생성자로 생성해야한다.
- 경로를 입력하지 않는다면 사용하고 있는 프로젝트 안에 만들어진다.

```java
File f = new File("test.txt");
```
- 이렇게 생성할수가있다.
- 여기서 경로를 입력하지않는다면 현재 사용하고있는 프로젝트 폴더안에 만들어진다.

<br/>

- 절대경로를 입련한 생성자만드는법도알아보자.

```java
File f = new File("c:/Users/GDJ/wowfile.txt");
```

- 이런식으로 절대경로를 설정해서 파일을 생성할수도 있다.



<br/>


## 지정된 파일 생성하기
- 메소드를 입력해야한다 <code>createNewFile()</code> 사용할수가있다.
- 하지만 한가지 주의할점은 **무조건 예외처리를 해줘야한다는 점이있다.**
- 그리고 파일을 생성후에 자바프로젝트에 보이게할려면 <code>represh(f5)</code>를 눌러줘야 보여진다.

```java
try {

	f.createNewFile();
	System.out.println("파일생성완료");
} catch (IOException e) {
	e.printStackTrace();
	System.out.println("파일생성실패");
		}
    
```
- 파일생성이 성공하면 파일생성 완료 가 출력되고
- 파일생성이 실패하면 파일생성 실패 가 출력된다.

<br/>

## 내가 원하는 폴더에 생성하기
- 내가원하는 폴더를 만드는메소드는 2가지가있다.

  - <code>mkdir()</code>,<code>mkdirs()</code> 두가지를 사용 할수가있다.

- **mkdir()** :  한개의 폴더만 생성이 가능하다.

- **mkdirs()** : 하위폴더까지 여러개의 폴더를 생성할수가 있다.

<br/>

## mkdir()


```java

 File dir =  new File ("./myfolder");
 boolean result1 = dir.mkdir();
//폴더  myfolder가 만들어진다. 
```

- 주의할점 
- 이 메소드는 여러개를 만들고싶어도 불가능하다.

```java
File dirs = new File("./myfolder/a/b");
boolean result = dirs.mkdir();
System.out.println(result);
//출력결과
//false
```

- 여러개를 만들고싶어도 불가능하다.
- 위를 예시를 들자면 myfolder 폴더안에  a폴더안에 b폴더를 만들라는 뜻이다.
- a폴더가 없으니깐 만들어지지않고 false가 나온다.

<br/>
## mkdirs()
- 이메소드를 사용한다면 하위폴더까지 한번에 폴더를생성할수가있다.

```java
File dirs = new File("../myfolder/a/b/c");
boolean result = dirs.mkdirs();
System.out.println(result);
//출력결과
//true
```

- 이렇게 폴더를 생성할 수있는 두가지방법을 알아봣는데
- 궁금한점이 하나있다
- 폴더명을적을때 **./**와 **../** 이둘의차이점을뭘까?

	-  간단하게 말하겟다.
	-  (./) 는현재경로를 표현한다.예를들면 c:/test/ 가있다면 ./test를 쓴다면 test에 만들어진다.
	-  (../) 는상위경로를 표현한다 예를들면 c:/test/ 가있다면 ../test를 쓴다면 c에 만들어진다.

<br/>


## file 삭제하기
- File클래스에서 제공하는 delete()메소드를 이용한다.
- 이메소드를 이용하면  폴더와 파일을 삭제할수가있다.


<br/>

- **파일삭제**

```java

 File delFile = new File("myfolder/mytest.txt");
delFile.delete();
```

- 이런식으로 myfolder폴더안에있는 mytest.txt 파일이 삭제간된다.
- 경로를먼저 적은후에 삭제할파일을 적으면 파일삭제가 된다.

<br/>

- **폴더삭제**

- 파일을 삭제할수 있다면 폴더도 삭제할수있다.
- 먼저 예시부터 보여주겟다.

```java
File delDir = new File("myfolder/a/b");
delDir.delete();
```

- 이런식으로 myfolder폴더안에 a폴더안에 b폴더가 삭제되었다.
- 여기서 궁금증이 하나 생긴다. 저렇게 경로설정하고 delete를 햇는데 myfolder가 삭제되지않을까?
- 그래서 **myfolder만 적어두고 실행해봣지만 삭제되지않앗다.**

	- 여기서 알수있는건 상위폴더를 한번에 삭제하진못한다는거
	- 하위폴더부터 하나씩 삭제가 가능하다는것이다.
	- 기억해두자


<br/>



 
