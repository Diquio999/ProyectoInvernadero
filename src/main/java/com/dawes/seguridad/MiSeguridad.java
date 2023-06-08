package com.dawes.seguridad;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.dawes.servicioImpl.ServicioUsuarioImpl;

@Configuration
@EnableWebSecurity
public class MiSeguridad {
	
	@Autowired
	ServicioUsuarioImpl su;
	

	public String encriptator(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	@Bean
	public SecurityFilterChain filtrocompleto(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests().requestMatchers( new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN").and().exceptionHandling()
				.accessDeniedPage("/403");

		http.authorizeHttpRequests().requestMatchers( new AntPathRequestMatcher("/")).permitAll().anyRequest().authenticated();

		http.formLogin().loginPage("/login").permitAll();

		http.logout().logoutUrl("/logout").permitAll();

		return http.build();
	}
}
