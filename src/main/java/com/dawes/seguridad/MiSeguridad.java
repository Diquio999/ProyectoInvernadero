package com.dawes.seguridad;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dawes.servicioImpl.ServicioUsuarioImpl;

@Configuration
@EnableWebSecurity
public class MiSeguridad {
	
	@Autowired
	ServicioUsuarioImpl su;
	
	@Bean
	public BCryptPasswordEncoder encripta() {
		return new BCryptPasswordEncoder();
	}
	
	public String encripta(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
	@Bean
	public SecurityFilterChain filtrocompleto(HttpSecurity http) throws Exception{
		//programamaos la autenticacion
		http
		.getSharedObject(AuthenticationManagerBuilder.class)
		.userDetailsService(su)
		.passwordEncoder(encripta());
		
		//autorizamos acceso a los recursos de user
		http
		.authorizeHttpRequests()
		.requestMatchers(new AntPathRequestMatcher("/user/**"))
		.hasAnyRole("ADMIN", "USER")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403");
		
		//autorizamos acceso a los recursos de admin
		http
		.authorizeHttpRequests()
		.requestMatchers(new AntPathRequestMatcher("/admin/**"))
		.hasRole("ADMIN")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403");
		
		//acceso publico a los recursos en el raiz en el pincipal, login
		http
		.authorizeHttpRequests()
		.requestMatchers(new AntPathRequestMatcher("/"), new AntPathRequestMatcher("/login"), new AntPathRequestMatcher("/index"))
		.permitAll()
		.anyRequest()
		.authenticated();
		
		//personalizar login
		http
		.formLogin()
		.loginPage("/login")
		.permitAll();
		
		// programamos el logout
		http
		.logout()
		.logoutUrl("/logout")
		.permitAll();
		
		return http.build();
	}
}
