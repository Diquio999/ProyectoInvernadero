package com.dawes.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class Principal {
	@RequestMapping("/index")
	public String principal() {
		return "index";
	}
	@RequestMapping("/admin")
	public String administrador() {
		return "Admin/admin";
	}
	@RequestMapping("/user")
	public String user() {
		return "User/regis";
	}
	
	@RequestMapping("/403")
	public String p403() {
		return "Error/403";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "Logs/login";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "Logs/logout";
	}
	
	@RequestMapping("/salir")
	public String salir(HttpServletRequest request) {
		request.getSession(true).invalidate();
		return "index";
	}
}
