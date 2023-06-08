package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.FincaVO;
import com.dawes.modelo.RecoleccionVO;
import com.dawes.repositorio.RecoleccionRepositorio;
import com.dawes.servicio.ServicioRecoleccion;

@Service
public class ServicioRecoleccionImpl implements ServicioRecoleccion{

	@Autowired
	private RecoleccionRepositorio repo;
	
		public RecoleccionVO save(RecoleccionVO finca) {
		return repo.save(finca);

	}

	

		public RecoleccionVO findById(Long id) {
		Optional<RecoleccionVO> recoleccion = repo.findById(id);
		if (recoleccion.isPresent()) {
			return recoleccion.get();
		}
		return null;
	}
	
	
	
	
		public List<RecoleccionVO> findAll() {
		List<RecoleccionVO> recolecciones = repo.findAll();
		return recolecciones;
	}


	


	public void deleteById(Integer id) {
		rr.deleteById(id);
	}

	

}
