package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;
import com.dawes.repositorio.ArbolRepositorio;
import com.dawes.repositorio.FincaRepositorio;
import com.dawes.servicio.ServicioArbol;

@Service
public class ServicioArbolImpl implements ServicioArbol {

	@Autowired
	private ArbolRepositorio ar;
	

	public <S extends ArbolVO> S save(S entity) {
		return ar.save(entity);
	}


	public Optional<ArbolVO> findById(Integer id) {
		return ar.findById(id);
	}


	
	public Iterable<ArbolVO> findAll() {
		return ar.findAll();
	}



	public void deleteById(Integer id) {
		ar.deleteById(id);
	}

}
