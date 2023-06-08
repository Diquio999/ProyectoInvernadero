package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.TratamientoArbolVO;
import com.dawes.repositorio.TratamientoArbolRepositorio;
import com.dawes.servicio.ServicioTratamientoArbol;

@Service
public class ServicioTratamientoArbolImpl implements ServicioTratamientoArbol{
	@Autowired
	private TratamientoArbolRepositorio repo;

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
		tar.deleteById(id);
		
	}

	
}
