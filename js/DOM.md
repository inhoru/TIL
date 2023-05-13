# 🔖 목차

1. [태그생성](#1-태그생성)<br/>
2. [textNode가 없는 태그 생성하기](#2-textNode가-없는-태그-생성하기)<br/>
3. [구조가 있는 태그 만들기](#3-구조가-있는-태그-만들기)<br/>
4. [생성된 태그를 원하는 위치에 넣기](#4-생성된-태그를-원하는-위치에 넣기)<br/>
5. [태그삭제](#5-태그삭제)<br/>



<br/>

## js를 이용해서 태그생성하기
-  태그를 동적으로 생성할때는 document객체가 제공하는 createElement()메소드를 이용한다.<br />
- 생성한 태그에 출력할 문구가 필요하면 document객체가 제공하는 createTexNode()메소드를 이용한다.<br />
- 생성한 태그에 출력할 문구가 업으면 태그가 가지고 있는 속성설정을 한다. setAttribute()메소드를 이용한다.<br />
- 생성태그를 화면에 출력하려면 화면에 출력되어있는 태그중 한개에 연결을 해줘야한다.
- 연결할땐 appendChild()메소드를 이용한다



<br/>

# 1. 태그생성
- 먼저 출력문구가있는 태그를 생성해보자

```javascript
<button onclick="addElement();">태그 추가하기</button>
    <input type="text" id="tagName" size="5">
    <input type="text" id="tagContent">
    <button onclick="myTag();">태그생성</button>
    <div id="addTag"></div>
    <script>
        const myTag = () => {
            const tag = document.getElementById("tagName").value
            const tagText = document.getElementById("tagContent").value
            const p = document.createElement(tag);
            const pText = document.createTextNode(tagText);
            p.appendChild(pText);
            const $container = document.getElementById("addTag");
            $container.appendChild(p);
        }
        const addElement = () => {
            //태그생성하기
            const btn = document.createElement("h2");
            console.log(btn);
            console.dir(btn);
            //텍스트노드 생성하기
            const btnText = document.createTextNode("점심먹자");
            console.log(btnText);
            //생성된 태그와 텍스트합치기
            //부모객체명.appendChild(자식으로 들어갈객체) : 
            btn.appendChild(btnText);
            console.log(btn);
            const $container = document.getElementById("addTag");
            $container.appendChild(btn);
        }
```

<br/>

# 2. textNode가 없는 태그 생성하기
- img,input,audio,video,br 같은 것들을말한다.

```javascript

 <button onclick="addImg();">이미지 추가하기</button>
    <div id="imgcontainer"></div>
    <script>
        const addImg = () => {
            const img = document.createElement("img");
            console.log(img);
            //속성값을 설정.
            //속성값을 설정하는 방법
            //1. 생성된 객체에서 직접 속성명으로 접근해서 값을 대입.
            //2. 생성된 객체가 제공하는 setAttribute("속성명","속성값")메소드를 이용
            console.dir(img);
            img.src = "https://file.mk.co.kr/meet/neds/2017/09/image_readtop_2017_656480_15067482203049448.jpg"
            console.log(img);
            img.setAttribute("width", "180");
            img.setAttribute("height", "180");

            document.getElementById("imgcontainer").appendChild(img);

        }
```

<br/>

# 3. 구조가 있는 태그 만들기

-  table, 리스트(ul, ol, dl), feildset, div안에 div 같은것들을 말한다.

<br/>

## 리스트태그 만들기

```javascript
 <button onclick="makeList();">리스트만들기</button>
    <!-- 
                . html
                . css
                . javascript
                . jquery
                . servler/jsp 
             -->
    <div class="listTarget"></div>
    <script>
        const makeList = () => {
            const ul = document.createElement("ul");
            const data = ["html", "css", "javascript", "jquery", "servlet/jsp"];
            data.forEach(e => {
                const li1 = document.createElement("li");
                const li1Text = document.createTextNode(e);
                li1.appendChild(li1Text);
                ul.appendChild(li1);
            });
            document.getElementsByClassName("listTarget")[0].appendChild(ul);
  </script>
  
  ```
  
- forEach를 이용해서 배열을 돌면서 차례대로 li에 textNode를 넣을수가있다.


<br/>

## 사용자에게 , 구분된 문자열을 입력받아 ol태그로 출력하기

```javascript
<!-- name은 배열로가져오기때문에 인덱스를써야한다. -->
    <input type="text" name="list" placeholder=", 로 여러값 입력"><button onclick="makeOl();">입력</button>
    <div class="olList"></div>
    <script>
        const makeOl = () => {
            const input = document.getElementsByName("list")[0].value.split(",");
            const ol = document.createElement("ol");
            input.forEach(e => {
                const li = document.createElement("li");
                //li.innerText=e;  <- 이렇게도가능
                const liText = document.createTextNode(e);
                li.appendChild(liText);
                ol.appendChild(li);
            });
            document.getElementsByClassName("olList")[0].appendChild(ol);
        }
```

- textNode 대신 innerText 를 사용해도된다.

<br/>


## 테이블만들기

```javascript

<div id="tableContainer"></div>
    <button onclick="addTable()">3*3 테이블 추가하기</button><br />
 const addTr = () => {
            const $inputs = document.querySelectorAll(".row");
            console.log($inputs);
            const tr = document.createElement("tr");
            $inputs.forEach(e => {
                const td = document.createElement("td");
                td.innerText = e.value;
                tr.appendChild(td);
            });
            document.querySelector("div#tableContainer>table").appendChild(tr);
```
<br/>


# 4. 생성된 태그를 원하는 위치에 넣기

- Element.insertAdjacentElemnet("지정된예약어",element);
- beforebegin : 지정한 태그의 앞에(같은 레벨에서 위에 위치하게 하는것)
- afterend : 지정한 태그의 뒤에(같은 레벨에서 아래 위치하게 하는것)
- beforeend : 지정한 태그의 맨밑 자식으로 추가 == appendChild() 이용한것과 동일
- afterbegin : 지정한 태그의 맨위 자식으로 추가

```javascript

<div id="target">
        <h1 style="color: lime; background-color: magenta;">기준태그</h1>
    </div>
    <button onclick="beforebeginTest();">beforebeginTest</button>
    <button onclick="afterendTest();">afterendTest</button>
    <button onclick="beforeendTest();">beforeendTest</button>
    <button onclick="affterbeginTest();">affterbeginTest</button>
    <style>
        div#target {
            width: 400px;
            height: 300px;
            border: 1px solid red;
        }
    </style>
    <script>
        let count = 0;
        const beforebeginTest = () => {
            const $h3 = document.createElement("h3");
            $h3.innerText = "새로추가한것" + (count++);
            const $divContainer = document.querySelector("#target");
            $divContainer.insertAdjacentElement("beforebegin", $h3);
        }
        const afterendTest = () => {
            const $h3 = document.createElement("h3");
            $h3.innerText = "afterlike -아이브-" + (count++);
            const $divContainer = document.querySelector("#target");
            $divContainer.insertAdjacentElement("afterend", $h3);
        }
        const beforeendTest = () => {
            const $h4 = document.createElement("h4");
            $h4.innerText = "childEnd add";
            const $divContainer = document.querySelector("#target");
            $divContainer.insertAdjacentElement("beforeend", $h4);

        }
        const affterbeginTest = () => {
            const $h4 = document.createElement("h4");
            $h4.innerText = "childfirst add";
            const $divContainer = document.querySelector("#target");
            $divContainer.insertAdjacentElement("afterbegin", $h4);
        }
    </script>

```
<br/>

## 태그 이동시키기

-  페이지에 출력된 태그를 이동시킬때도 insertAdjacentElement()메소드를 이용할 수 있다.

```javascript

<div id="moveTest">
        <h1>h1태그</h1>
        <p>p태그</p>
        <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
            <li>4</li>
        </ul>
    </div>
    <button onclick="moveTest()">이동시키기</button>
    <button onclick="moveTest2()">li순서변경하기</button>
    </style>
    <script>
    // 태그 이동시키기
        const moveTest = () => {
            const $h1 = document.querySelector("#moveTest>h1");
            const $container = document.querySelector("#moveTest");
            $container.insertAdjacentElement("afterend", $h1);
        }
        
     // li 이동시키기   
        const moveTest2 = () => {
            // const $li=document.querySelector("#moveTest>ul>li:first-child");
            // const $container=document.querySelector("#moveTest>ul");
            // $container.insertAdjacentElement("beforeend",$li);

            const $firstLi = document.querySelector("#moveTest>ul>li:first-child");
            const $container = document.querySelector("#moveTest>ul>li:last-child");
            $container.insertAdjacentElement("afterend", $firstLi);
        }
    </script>

```

<br/>

# 5. 태그삭제
- 태그를 삭제하는 방법은 2가지
- 자기자신을 삭제하기 : 삭제할Element.remove()
- 자식태그를 삭제하기 : 부모Element.removeChild(자식element)

```javascript

<div id="removeContainer">
        <p>1</p>
        <p>2</p>
        <p>3</p>
    </div>
    <button onclick="selfRemove();">자기자신을 삭제하기</button>
    <button onclick="childRemover();">자식을 삭제하기</button>
    <script>
        const selfRemove = () => {
            document.querySelector("#removeContainer>p").remove();
        }
        const childRemover = () => {
            const $container = document.querySelector("#removeContainer");
            const $remove = document.querySelector("#removeContainer>p:last-child");
            $container.removeChild($remove);
        }
    </script>
```
<br/>


## 첨부파일 삭제

    
    
    
 ```javascript   
    
    <fieldset>
        <legend>첨부파일</legend>
        <div>
            <button onclick="addFile();">추가</button>
            <button onclick="removeFile();">삭제</button>
        </div>
        <div  class="container">
            <input type="file" name="upfiles">
        </div>
        
    </fieldset>
    <script>
        const addFile=()=>{
            const length=document.querySelectorAll("fieldset input").length;
            if(length<5){
                const $input=document.createElement("input");
                $input.type="file";
                $input.name="upfiles";
                document.getElementsByClassName("container")[0].appendChild($input);
            }else{
                alert("5개까지만 가능합니다.")
            }

        }  
        const removeFile=()=>{
            const $remove=document.getElementsByClassName("container")[0];
            const remove=document.getElementsByName("upfiles");
            console.log(remove);
            if(remove.length>1){
                $remove.removeChild(remove[0]);
            }else{
                alert("더이상삭제불가능");
            }


        }


    </script>

```













        
        
        
        
        
        
        
        
        
        
        
        
        
        
