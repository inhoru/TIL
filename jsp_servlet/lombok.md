# 🔖 목차

1. [lombok jar](#1-lombok-jar)<br/>
2. [lombok사용](#2-lombok사용)<br/>

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



![lombok](https://user-images.githubusercontent.com/126074577/243721124-6e8f7519-4562-43ba-84dc-760fabd62c97.png)

![lombok2](https://user-images.githubusercontent.com/126074577/243721130-36ccea76-2868-485f-86d2-f42cf072b6da.png)

- 아무거나 다운받아도된다 

![lombok3](https://user-images.githubusercontent.com/126074577/243721130-36ccea76-2868-485f-86d2-f42cf072b6da.png)

- jar파일을 다운받자

![lombok4](https://user-images.githubusercontent.com/126074577/243721145-2046964b-ec13-42ba-9dc5-2ae99e20c02f.png)

- jar 파일을 다운받은곳에서 powerShell을연다.
- 이때 이클립스는 꺼놓고 실행하자



![lombok6](https://user-images.githubusercontent.com/126074577/243721156-61bca82b-5fe6-464a-a928-a2de42ce86f2.png)

- java -jar .\lombok-1.18.24 .jar 
- 을 적어주자 lombok만 쓰고 탭을누르면 자동완성이될것이다.



![lommok7](https://user-images.githubusercontent.com/126074577/243721195-34ed148c-1125-45a1-b8e5-952149a644ae.png)

- 엔터를 누르면 이렇게 뜰텐데
- 이클립스를 찾아서 연동시켜주면된다.

![롬복 8](https://user-images.githubusercontent.com/126074577/243721195-34ed148c-1125-45a1-b8e5-952149a644ae.png)

- 그런후 이클립스 설치한경로에가서 exe를 선택한다.

![롬복 9](https://user-images.githubusercontent.com/126074577/243721222-7d448026-0fec-403a-bf6a-47114ac02afc.png)

- 그런후 인스토을누르면 연동이완료된거다.

- 이제 이클립스를 다시켜보자

<br/>



# 2. lombok사용



![이클](https://user-images.githubusercontent.com/126074577/243721232-d81d119e-e529-4c6a-8e8e-d5f7a210b346.png)

- 이런식으로 어노테이션을이용해서 사용들이가능하다
- 우리가 지금까지 계속만들었던 생성자게터새터 등등 전부 어노테이션으로 끝난다.



<br/>



![이클2](https://user-images.githubusercontent.com/126074577/243721246-87dfec4a-805b-4670-acc1-dea7b09b9ba0.png)

- 이렇게  outine를 들어가면보면 어노테이션을 지정한것들만
- 이렇게 나오는걸볼수가있다. 이제 우리는 저기에 있는것들을 사용할수가있는거다.
- 한가지 주의할점은
- **tostring은 모든것들을 추력을해주는데 제외를시켜야할때**
- **@ToString(exclude = {"memberPwd"}) 를 사용해서 제외를 시켜줄수가있다.**



<br/>







