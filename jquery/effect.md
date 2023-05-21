# 🔖 목차
1. [ animate 함수 이용하기](#1-animate-함수-이용하기)<br/>
2. [슬라이딩함수](#2-슬라이딩함수)<br/>
3. [fade함수적용](#3-fade함수적용)<br/>
4. [show hide](#4-show-hide)<br/>



<br/>

# 1. animate 함수 이용하기
- animation을 간단하게 적용할 수 있는 함수

```javascript
 <div id="target"></div>
    <style>
        #target {
            width: 200px;
            height: 200px;
            background-color: violet;
        }
    </style>
    <script>
        $("#target").click(e => {
            $(e.target).animate({
                "position": "absolute",
                "left": "200px",
                "top": "200px",
                "width": "500px",
                "height": "500px",
                "opacity": "0.5"
            }, 1000, () => { alert("애니메이션 종료") });
        });
</script>

<br/>

# 2. 슬라이딩함수
- slideUp(진행시간(ms)),slideDown(진행시간(ms)),slideToggle(진행시간(ms))
- FAQ에서 사용한다.

```javascript
 <div id="menucontainer">
        <div>첫번째 메뉴</div>

    </div>
    <button id="btn">slideUP</button>
    <button id="btn2">slideDown</button>
    <button id="btn3">slideToggle</button>
    <style>
        div#menucontainer>div {
            width: 40%;
            height: 300px;
            background-color: lightblue;

        }
    </style>

    <script>
        $("#btn").click(e => {
            $("#menucontainer>div").slideUp(500)
        });
        $("#btn2").on("click", e => {
            $("#menucontainer>div").slideDown(1000)
        });
        $("#btn3").on("click", e => {
            $("#menucontainer>div").slideToggle(1)
        });
</script>

```

<br/>

# 3. fade함수적용
- 점점희미해지거나 점점진해지는 느낌을 주는 것
- fadeIn(),fadeOut(),fadeTo(),fadeToggle()

```javascript
 </p>
    <img src="https://s2.coinmarketcap.com/static/img/coins/200x200/14872.png" alt="" width="200" height="200"
        id="jooyoung">
    <br />
    <button onclick="fadeInTest();">fadeIn</button>
    <button onclick="fadeOutTest();">fadeOut</button>
    <button onclick="fadeToTest();">fadeTo</button>
    <button onclick="fadeToggleTest();">fadeToggle</button>
    <style>
        #jooyoung {
            opacity: 0.3;
        }
    </style>
    <script>
        const fadeInTest = e => {
            $("#jooyoung").fadeIn(1000);
        }
        const fadeOutTest = e => {
            $("#jooyoung").fadeOut(1000);
        }
        const fadeToggleTest = e => {
            $("#jooyoung").fadeToggle(1000);
        }
        const fadeToTest = e => {
            $("#jooyoung").fadeTo(1000, 0.3);
        }

        $("#jooyoung").hover(
            e => {
                $(e.target).fadeTo(1000, 1);
            },
            e => {
                $(e.target).fadeTo(1000, 0.3)
            });
</script>
```

<br/>

# 4. show hide

-  display 속성은 none, block으로 설정하는 함수

```javascript
<h1 id="jqueryEnd">이거까지하면 프론트끝!</h1>
    <button onclick="showTest();">show</button>
    <button onclick="hideTest();">hide</button>
    <script>
        const showTest = () => {
            $("#jqueryEnd").show(1000);
        }
        const hideTest = () => {
            $("#jqueryEnd").hide(1000);
        }
    </script>
    <br><br><br>
    <div id="testMent">
        <div>첫번째메뉴</div>
        <p>첫번째메뉴 내용</p>
        <div>두번째메뉴</div>
        <p>두번째메뉴 내용</p>
        <div>세번째메뉴</div>
        <p>세번째메뉴 내용</p>
        <div>네번째메뉴</div>
        <p>네번째메뉴 내용</p>
    </div>
    <style>
        #testMent>div {
            font-size: 26px;
            font-weight: bolder;

        }

        #testMent>p {
            display: none;
            height: 40px;
            background-color: lightgray;
            margin-left: 20px;
        }
    </style>
    <script>
             const $even=$("#testMent :even");
            const $odd=$("#testMent :odd");
            
            
        $("#testMent>div").on("click", e => {
            //$("#testMent>p").hide();
            $(e.target).next().slideToggle(1000);
           
        });
        

</script>
```

<br/>

























