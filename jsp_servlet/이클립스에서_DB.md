# :bookmark: 목차

1. [이클립스 DB데이터가져오기](#1-이클립스-DB데이터가져오기)<br/>




# 1.  이클립스 DB데이터가져오기

- 이클립스에서 db데이터를 가져올수가있다.
- 마켓플레이스에서 dbeaver(community) 을설치해야한다.

![db](https://user-images.githubusercontent.com/126074577/240451861-c1cfe479-533a-4ac8-99a8-bae31a824160.png)

![dbeaver community](https://user-images.githubusercontent.com/126074577/240451876-65ea1248-8f10-4714-97f8-6cd6c790a832.png)

- show view에서 
- Databasc Navigator 을 만든다.

![돼지코2]([C:\Users\GDC10\AppData\Roaming\Typora\typora-user-images\image-20230524101338779.png](https://user-images.githubusercontent.com/126074577/240455135-6c6cd775-c9dc-42e2-bcaa-c39329c7c2d2.png))

<br/>



- 돼지코를 눌러서 오라클을 선택한다

![돼지코](https://user-images.githubusercontent.com/126074577/240453390-9407fd1d-cb6e-4af6-9cda-4c1518a717bb.png)

![오라클](https://user-images.githubusercontent.com/126074577/240453724-b4e1f273-45f7-4ef5-94b3-862accec02bb.png)

- 이렇게 익숙한 오라클창이나올텐데 여기에서 post랑 sid xe를 설정하면된다.
- usernam과 password는 오라클 접속 아이디와 비밀번호다.
- 그리고 왼쪽하단에 test를 해서 접속이잘되는지 확인을할수가있다.

- 성공이된다면 connected가 뜬다.
- 중간에 뭘다운로드하라고 뜰텐데 그냥다운하면된다.

![다운](https://user-images.githubusercontent.com/126074577/240453636-df9487d6-1aff-4ea1-a0fb-60d108e76789.png)





<br/>



## 스크립트 작성

- 이클립스에서 스크립트를 만들수가있다.

![SQL문](https://user-images.githubusercontent.com/126074577/240455135-6c6cd775-c9dc-42e2-bcaa-c39329c7c2d2.png)

![SQL2](https://user-images.githubusercontent.com/126074577/240455252-cb1c3b3a-3825-4b12-947b-8f7b88dd4ffb.png)

- 이런식으로 이클립스에서 DB의 정보를 볼수가있다.
- 단주의할점은 오라클명령어는 사용이불가능하다.
- DESC라든가..등등등

<BR/>

