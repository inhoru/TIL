<img width="644" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/367462f8-d85d-432d-8765-5e5f261a0abe">## stream

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
- <code>filter()</code>,<code>distinct()</code>
<img width="628" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/de157bf1-5aea-4e53-b5a7-f0d1fe83be7a">


<br/>

## 변환

- <code>Map()</code>,<code>flatMap()</code>

<img width="639" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/367d4736-2672-4fa1-a98b-4c9f2ab5706e">



<br/>

## 제한
- <code>limit()</code>,<code>skip()</code>


<img width="644" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/37fd4a9c-f016-4b23-b5ab-bb2682cd0336">


<br/>

## 정렬
- <code>sorted()</code>

<img width="639" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/947abd31-692e-409d-bd77-c624cbc53288">


<br/>


# 3. 최종연산
- 최종연산은 앞서 중개 연산을 통해 만들어진 stream에있는 요소들에 대해 마지막으로 각 요소를 소모하며 최종 결과를 표시한다.
- 이렇게 최종연산시에 모든 요소를 소모한 해당 stream은 더이상사용할수없다.

<img width="683" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/431ec6d2-c964-4e9e-9785-4b03e09046d4">

<br/>


## 출력

- <code>forEach()</code>

<img width="393" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/e2f5e4f6-1071-4e73-a0bc-554ef890e8ab">

<br/>

## 소모

- <code>reduce()</code>
<img width="462" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/cbb3102c-04a6-48c1-8a6f-b00c23b81ece">

</br>

## 검색

- <code>findFirst()</code>,<code>findAny()</code>

<img width="647" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/5a8fb8b7-ec3c-4da7-8de8-dee5bd9b77d3">

<br/>

## 통계

- <code>count()</code>,<code>min()</code>,<code>max()</code>

<img width="461" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/3bd4c0cc-1d5c-42d8-ab27-1a0b77166e17">

<br/>

## 연산

- <code>sum()</code>,<code>average()</code>

<img width="516" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/901ee5cb-49f1-4307-bff2-1bfae418130d">

<br/>

## 수집

- <code>collect()</code>

<img width="639" alt="image" src="https://github.com/inhoru/TIL/assets/126074577/3041a4f7-f26d-48fc-9c5d-e45dfd383423">



<br/>









