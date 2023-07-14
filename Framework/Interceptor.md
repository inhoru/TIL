## 🔖 목차
1. [Interceptor](#1-Interceptor)<br/>




<br/>


# 1. Interceptor
- 인터셉터는 컨트롤러에들어오는 요청과 응답을 가로채는 역할을한다.
- WAS에서의 필터와 비슷하다고 볼수있다.
- 다른점이있다면 인터셉터는 reqyestm response를 앞 , 뒤에서 가로채는역할을한다.

<br/>

## 환설정정
- servlet-context.xml에 설정해주면 사용이가능하다.

```xml
<interceptors>
    <interceptor>
    	 		<mapping path="/demo/*"/>
    	 		<beans:ref bean="loginCheck"/>
    </interceptor>
</interceptors>
 <beans:bean id="loginCheck" class="com.bs.spring.common.interceptor.LoginCheckInterceptor"/>
```
- demo에있는 모든 요청을 가로채서 oginCheckInterceptordptj 실행을시키겟다는 뜻이다.
- interceptor을더추가하고싶다면 interceptors 안에 추가해서 사용하면된다.


<br/>

## 클래스
- 요청을 가로채서 실행할 클래스가 필요하다.
- 메소드의 종류는 3가지가있다.
-  preHandle() : 컨트롤러가 호출되기전에 실행을한다.
-  postHandle() : 컨트롤러가 실행된 후에 호출됩니다.
-  afterComplete() : 뷰에서 최종 결과가 생성하는 일을 포함한 모든일이 완료되었을때 실행한다.


```java
public class LoginCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	HttpSession session=request.getSession();
	Member loginMember=(Member)session.getAttribute("loginMember");
	if(loginMember==null) {
		//로그인 안됨
		request.setAttribute("msg", "로그인 후 이용할 수 있는 서비스입니다. :(");
		request.setAttribute("loc", "/");
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
		return false;
	}
	
	return true;
			
	}
	

}
```
- 각메서드의 반환값이 true면은 바로 컨트롤러 실행이되지만 false면은 중단하고 컨트롤러가 실행되지않는다.

<br/>




