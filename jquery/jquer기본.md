# 🔖 목차
1.
2.
3.

## jquery 사용
- 페이지에 jquery를 사용하기 위해서는 jquery.js파일을 불러와야한다. 

  -  내부에서 불러오기 -> js파일을 다운로드하고 불러오는 것
  -  \<script src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
  -  외부에서 불러오기 -> 외부에서 제공하는 사이트 이용 CDN방식
  -  \<script src="./js/jquery-3.7.0.min.js"></script>

<br/>

# 1. jquery 사용하기
- jquery는 DOM객체를 편리하게 다룰 수 있는 다양한 함수를 제공
- DOM에 접근하려면 $표현을 이용하거나 jquery명칭을 이용한다.
- \$("선택자").jquery제공함수를 호출
- jQuery("선택자").jquery제공함수를 호출


```javascripy
<h4>jquery로 Element불러오기</h4>
    <p id="first">첫번째 p태그</p>
    <h2 class="second">h2 태그</h2>
    <h3 class="second">h3 태그</h3>
    <script>
        //배열방식으로 반환
        // $("h3").css("color","lime");//==document.querySelectorAll("h3") 비슷
        //jQuery("h3").css("color","magenta");
        const $e = $("h3");
        console.log($e);
        //첫번째 p태그 불러오기
        const $p = $("p#first");
        console.log($p);
        //jquery방식으로 불러온 Element는 chaining방식으로 함수를 실행후 jqueryElement를 반환함
        $("p#first").css("color", "red").text("내가변경한것");

        console.log($(".second"));
        $(".second").css("color", "green").text("내가변경한것2");
    </script>
```

<br/>


# 2. jquery선택자 활용하기

- first : 선택자로 선택된 Element 중 0번인덱스에 있는것
- last : 선택자로 선택된 Element 중 마지막인덱스에 있는것
- odd : 선택자로 선택된 Element 중 홀수인덱스에 있는것
- even : 선택자로 선택된 Element 중 짝수인덱스에 있는것
- eq(인덱스) : 매개변수 인덱스와 일치하는 인덱스 Element
- gt(인덱스) : 매개변수 인덱스보다 인덱스가 큰 Element들
- lt(인덱스) : 매개변수 인덱스보다 인덱스가 작은 Element들

```javascript

<div id="container">
        <p id="pTag">p태그</p>
        <p class="test">p.test</p>
        <p></p>
        <h3 class="test">h3.test</h3>
        <span class="test">span.test</span>
        <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
            <li>4</li>
        </ul>
    </div>
    <button onclick="testSelector();">선택자테스트하기</button>
    <script>
        const testSelector = () => {
            //1. 선택자:first
            $("#container>*:first").css("backgroundColor", "gold");
            $("#container li:first").css("backgroundColor", "gold");
            //2. 선택자:last
            $("#container>*:last").css("backgroundColor", "silver");
            $("#container>.test:last").css("color", "tomato");
            //3. 선택자:odd
            $("#container li:odd").css("backgroundColor", "orangered");
            //4. 선택자:even
            $("#container li:even").css("backgroundColor", "cornflowerblue");
            //5. 선택자:eq()
            $("#container>*:eq(2)").text("새로추가하자");
            //6. 선택자:gt()
            $("#container>*:gt(3)").text("난 3보다 크다").css("backgroundColor", "crimson");
            //7. 선택자:lt()
            $("#container>*:lt(3)").text("난 3보다 작다");


        }
    </script>
    ````
    
    <br/>
    
    
