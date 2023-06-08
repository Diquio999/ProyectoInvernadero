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

	public TratamientoArbolVO save(TratamientoArbolVO tratamientoarbol) {
		return repo.save(tratamientoarbol);

	}
	public TratamientoArbolVO findById(Long id) {
		Optional<TratamientoArbolVO> tratamientoarbol = repo.findById(id);
		if (tratamientoarbol.isPresent()) {
			return tratamientoarbol.get();
		}
		return null;
	}



public List<TratamientoArbolVO> findAll() {
		List<TratamientoArbolVO> tratamientoarboles = repo.findAll();
		return tratamientoarboles;
	}

	
	//TRATAMIENTOS POR ARBOL
	public Optional<List<TratamientoArbolVO>> findAllByArbol(ArbolVO arbol) {
		return repo.findAllByArbol(arbol);
	}
	

	
	public void deleteById(Integer id) {
		tar.deleteById(id);
		
	}

	
}
