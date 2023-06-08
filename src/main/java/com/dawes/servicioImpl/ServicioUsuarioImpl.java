package com.dawes.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dawes.repositorio.UsuarioRepositorio;

@Service
public class ServicioUsuarioImpl implements UserDetailsService {
	@Autowired
	UsuarioRepositorio ur;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return ur.findByUsername(username);
	}

}
