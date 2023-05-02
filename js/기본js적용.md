# 🔖 목차
1. [inline](#1-inline)<br/>
2. [internal](#2-internal)<br/>
3. [extarnal](#3-extarnal)<br/>

<br/>

# 1. inline
- 태그의 이벤트 속성에 javascript코드를 작성하는 방식이다.

```javascript
<h3>inline방식으로 적용하기</h3>
<button onclick="alert('클릭했니');">이거눌러봐!</button>
```

- 태그 안에 js이벤트를 작성한다.

<br/>

# 2. internal
- script태그 내부에 필요한 javascript코드를 작성하는 방식
- inline방식으로 적용할때 body위에 써주는게좋다.
- 위에서 아래로 읽기때문에 head부분에 써주면 안될경우가 생길수도있다.

```javascript

 <h3>internal방식으로 적용하기</h3>

<script>
        alert('interal로 적용');
        document.querySelector("h3").style.color="magenta";
</script>
```

<br/>

# 3. extarnal
- js파일에 javascript코드를 작성하고 script태그로 불러와서 적용하는 방식

```javascript
//js
alert('external로 실행하기');

const testfunc=()=>{
    alert("testfunc함수를 실행하기");
}
----------------------------------------------------------------
//새로고침시 alert가 실행된다.
<script src="./js/test.js"></script>

<script>
      testfunc();
</script>
```
- js파일안에 있는 함수들을 저렇게 불러와서 사용이가능하다.
- 주의할점은 js파일을 불러오기전에 js파일안에있는 함수들을 사용할수는없다.

<br/>


