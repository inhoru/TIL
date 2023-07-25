## 🔖 목차


<br/>


# 1. boot security
- 부트자체에서도 security가 있기때문에 add starters 로 추가해줄수있다.

![image](https://github.com/inhoru/TIL/assets/126074577/623f3c11-73ff-463c-ba10-69c5217e94a4)


<br/>

스프링에서 security를 적용할려면 클래스파일을 하나만들어서 설정을해주면된다.
그리고 그자바 파일에서 @Configuration , @EnableWebSecurity를 메소드위에 설정해주자

![image](https://github.com/inhoru/TIL/assets/126074577/b3e40e3a-0fe7-4b26-9d13-31dab5baa2fc)



<br/>

# 2. boot에서 security적용
- boot에서 security를 적용할려면 2가지단계가있다.

> 1. 인증처리할 bean을 등록하기.
> 인증관련설정하는 bean - > SecurityFilterChain bean 등록
> 2. 인증방법에 대한 설정 클래스 등록
> inMemory, DB연동방식 -> provider를 등록

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private DbConnectProvider provider;
	
	public SecurityConfig(DbConnectProvider provider) {
		this.provider=provider;
	}

// 빈등록
@Bean
	public SecurityFilterChain authenticationPath(HttpSecurity http) throws Exception {
		//and()하게되면 다시http로 돌아간다.
		return http.csrf().disable()
				.formLogin()
					.successForwardUrl("/successLogin")
					.failureForwardUrl("/errorLogin")
					.usernameParameter("userId")
					.passwordParameter("pw")
					.loginProcessingUrl("/login.do")
					.loginPage("/loginpage")
				.and()
				.authorizeHttpRequests()//interceptor를 등록하는 것과 동일한 기능
					.antMatchers("/loginpage").permitAll()
					.antMatchers("/**").hasAnyAuthority(MyAuthority.ADMIN.name(),MyAuthority.USER.name())
				.and()
				.logout()
					.logoutSuccessUrl("/logout")
					.logoutUrl("/logout.do")
				.and()
				.authenticationProvider(provider)
				.build();
				
				
	}

```
	

