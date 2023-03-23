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

