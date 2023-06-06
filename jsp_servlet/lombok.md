# 🔖 목차

1. [lombok jar](#1.-lombok-jar)<br>
2. [lombok사용](#2.-lombok사용)<br/>

<br/>



# lombok

- lombok 라이브러리를 이용해서 게터세터 생성자 매개변수 생성자등등등 만들어주는 라이브러리다.
- 먼저 라이브러리이기때문에 jar파일을 가져와야한다.
- 그리고 IDE도구로 연동을해준다.
- lombok이 제공하능 어노테이션을 이용해서 활용을하면된다.



<br/>



# 1. lombok jar

- 라이브러리이기때문에 jar 파일을 사용한다.

- https://mvnrepository.com/ 이사이트에서 다운이가능하다
- lombok만이아니라 자바에서 제공하는 라이브러리들을 다운받을수가있다.



![lombok](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225054001.png)

![lombok2](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225122753.png)

- 아무거나 다운받아도된다 

![lombok3](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225152158.png)

- jar파일을 다운받자

![lombok4](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225233361.png)

- jar 파일을 다운받은곳에서 powerShell을연다.
- 이때 이클립스는 꺼놓고 실행하자



![lombok6](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225347535.png)

- java -jar .\lombok-1.18.24 .jar 
- 을 적어주자 lombok만 쓰고 탭을누르면 자동완성이될것이다.



![lommok7](![image-20230606225437405](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225437405.png)

- 엔터를 누르면 이렇게 뜰텐데
- 이클립스를 찾아서 연동시켜주면된다.

![롬복 8](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225522557.png)

- 그런후 이클립스 설치한경로에가서 exe를 선택한다.

![롬복 9](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225548478.png)

- 그런후 인스토을누르면 연동이완료된거다.

- 이제 이클립스를 다시켜보자

<br/>



# 2. lombok사용



![이클](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225728262.png)

- 이런식으로 어노테이션을이용해서 사용들이가능하다
- 우리가 지금까지 계속만들었던 생성자게터새터 등등 전부 어노테이션으로 끝난다.



<br/>



![이클2](C:\Users\inho\AppData\Roaming\Typora\typora-user-images\image-20230606225837282.png)

- 이렇게  outine를 들어가면보면 어노테이션을 지정한것들만
- 이렇게 나오는걸볼수가있다. 이제 우리는 저기에 있는것들을 사용할수가있는거다.
- 한가지 주의할점은
- **tostring은 모든것들을 추력을해주는데 제외를시켜야할때**
- **@ToString(exclude = {"memberPwd"}) 를 사용해서 제외를 시켜줄수가있다.**



<br/>







