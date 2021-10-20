package com.cev.prueba.prueba.config;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception {

			
			httpSecurity.csrf().disable()
							.authorizeRequests()
							.antMatchers(HttpMethod.GET, "/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER")
							.antMatchers(HttpMethod.POST, "/cine*").hasAnyAuthority("ROLE_ADMIN" , "ROLE_MANAGER")
							.antMatchers(HttpMethod.PUT, "/cine*").hasAnyAuthority("ROLE_ADMIN" , "ROLE_MANAGER")
							.anyRequest().hasAuthority("ROLE_ADMIN")
							.and().httpBasic();
			
			/*
			 * 			httpSecurity.csrf().disable()
							.authorizeRequests()
							.antMatchers(HttpMethod.GET, "/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
							.anyRequest().hasAuthority("ROLE_ADMIN")
							.and().httpBasic();
			 */
			
		}
		
		@Autowired
		protected void configure(AuthenticationManagerBuilder authentication) 
				throws Exception {
			authentication.inMemoryAuthentication()
				.withUser("admin")
				.password(PasswordEncoder().encode("admin"))
				.authorities("ROLE_ADMIN")
				.and()
				.withUser("manager")
				.password(PasswordEncoder().encode("manager"))
				.authorities("ROLE_MANAGER")
				.and()
				.withUser("user")
				.password(PasswordEncoder().encode("user"))
				.authorities("ROLE_USER");
			
			/*
			 * 			authentication.inMemoryAuthentication()
				.withUser("admin")
				.password(PasswordEncoder().encode("admin"))
				.authorities("ROLE_ADMIN")
				.and()
				.withUser("user")
				.password(PasswordEncoder().encode("user"))
				.authorities("ROLE_USER");
			 */
		}

		@Bean
		public PasswordEncoder PasswordEncoder() {
			return new BCryptPasswordEncoder();
		}		
	
}


  