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
- \jquery는 DOM객체를 편리하게 다룰 수 있는 다양한 함수를 제공
- \DOM에 접근하려면 $표현을 이용하거나 jquery명칭을 이용한다.
- \$("선택자").jquery제공함수를 호출
- \jQuery("선택자").jquery제공함수를 호출


```jquery
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
