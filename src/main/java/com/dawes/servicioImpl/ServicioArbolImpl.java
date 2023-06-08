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
	private ArbolRepositorio repo;
	

		//GUARDAR ARBOL
	public ArbolVO save(ArbolVO arbol) {
		return repo.save(arbol);

	}

	//ARBOL POR REFERENCIA
	public ArbolVO findById(Long id) {
		Optional<ArbolVO> arbol = repo.findById(id);
		if (arbol.isPresent()) {
			return arbol.get();
		}
		return null;
	}
	
	
	public List<ArbolVO> findAll() {
		List<ArbolVO> arboles = repo.findAll();
		return arboles;
	}

	

	public void deleteById(Integer id) {
		ar.deleteById(id);
	}

}
