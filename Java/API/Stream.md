## stream

<br/>

> 스트림(Stream)은 자바 8 API에 새로 추가된 기능이다. 스트림을 이용하면 선언형(더 간결하고 가독성이 좋도록)으로 컬렉션 데이터를 처리할 수 있다.
> 
>스트림이 데이터 컬렉션 반복을 멋지게 처리하는 기능이라고 생각하자.
> 
>또한 스트림을 이용하면 멀티스레드 코드를 구현하지 않아도 데이터를 투명하게 병렬로 처리할 수 있다.
>
> 스트림은 데이터소스 객체 집합 , stream생성, 중개연산, 최종연산 이있다 그종류에대해 알아보겠다.
> 


<br/>

# 1. stream생성

스트림은 여러가지 데이터 소스를 생성할수있다.


<img width="583" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/73125fa1-6f90-4539-be33-35a83f87288f">



<br/>

# 2. 중개연산

- 중개연산은 Stream을 전달받아 Stream으로 반환하여 중개 연산을 연속으로 사용할수있게해준다.
- 대표적인 중개 연산과 그에 따른 메소드를 소개해보겠다.


<img width="679" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/c7ae52f3-3eb9-48cc-b8af-3ce7eb955976">



## 필터링
- <code>filter()</code>,'''distinct()'''
<img width="628" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/de157bf1-5aea-4e53-b5a7-f0d1fe83be7a">


<br/>

## 변환

- Map(),flatMap()



