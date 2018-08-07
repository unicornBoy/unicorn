package com.hsbc.unicorn.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * springsecurity的自定义配置类
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private MyAuthenticationProvider provider;//自定义验证
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring().antMatchers("/js/**","/css/**","/images/**");//对于这些静态文件，忽略拦截
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.httpBasic().and()
				.authorizeRequests()//访问首页不需要权限，其他页面需要权限
				.antMatchers("/").permitAll().anyRequest().authenticated().and()
				.logout()//退出不需要权限
				.permitAll().and()
				.formLogin()//支持表单登陆
				.and()
				.csrf()//关闭默认的csrf认证
				.disable();
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
		//不删除凭据，以便记住用户
		auth.eraseCredentials(false);
	}
	
	/**
	 * 手动在拦截器中配置注册一个单例的bean对象，避免每次都重新生成
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
