package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ArbolVO;
import com.dawes.repositorio.ArbolRepositorio;

@Service
@Transactional
public class ServicioArbolImpl {

	@Autowired
	private ArbolRepositorio repo;
	

		//GUARDAR ARBOL
	public ArbolVO save(ArbolVO arbol) {
		return repo.save(arbol);

	}

	//ARBOL POR REFERENCIA
	public ArbolVO findById(Integer id) {
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
		repo.deleteById(id);
	}

}
