/*package com.dawes.servicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.modelo.RecoleccionVO;
import com.dawes.repositorio.RecoleccionRepositorio;

@Service
@Transactional
public class ServicioRecoleccionImpl{

	@Autowired
	private RecoleccionRepositorio repo;
	
		public RecoleccionVO save(RecoleccionVO finca) {
		return repo.save(finca);

	}

	

		public RecoleccionVO findById(Integer id) {
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
		repo.deleteById(id);
	}

	

}
*/
