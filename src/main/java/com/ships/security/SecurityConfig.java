package com.ships.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/addShip","/addShippingCompany", "/createOrder")
		.hasRole("USER").and().formLogin().and()
	    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    .logoutSuccessUrl("/index.html");
	  }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)

			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}

}
